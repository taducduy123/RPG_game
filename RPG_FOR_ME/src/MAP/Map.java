package MAP;
import java.io.*;
import java.util.*;
import CHARACTER.Character;
import CHARACTER.Player;
import CHARACTER.RegularMonster;
import ITEM.*;
import MAP.TILE.*;


public class Map 
{
    private final int maxTileCols = 20;
    private final int maxTileRows = 20;

    private Tile[] tile;
    private int[][] tileManager;

    private Character player;
    private List<Item> items;
    private List<Character> monsters;

//--------------------------------------------------

    //Constructor
    public Map(String mapFilePath)
    {
        //Intialize items and monsters
        this.items = new LinkedList<>();
        this.monsters = new LinkedList<>();

        //Loading Map
        loadMap(mapFilePath);
    }


//---------------------------------------------- Load Map from File ------------------------------------------------------------

    public void loadMap(String mapFilePath)
    {
    //Define all possible types of tile on the map
        this.tile = new Tile[4];
        this.tile[0] = new WallTile();
        this.tile[1] = new LandTile();
        this.tile[2] = new WaterTile();
        this.tile[3] = new FireTile();

    //Initialize tileManager
        this.tileManager = new int[maxTileRows][maxTileCols];

    //Read Map From File
        File myFile = new File(mapFilePath);

        //Check if file does not exist
        if(!myFile.exists())
        {
            System.out.println("Unable to open file " + mapFilePath);
        }

        try 
        {
            //Open input file for reading
            Scanner inputFile = new Scanner(myFile);

            //Read line by line
            String line;
            for(int i = 0; i < maxTileRows; i++)            // i ~ y-coor of obj in xy plane
            {
                //Read every line in text file
                line = inputFile.nextLine();

                //Get tokens from the line
                String[] numbers = line.split(" ");

                //Load all tokens into int[][] tileManager
                for(int j = 0; j < maxTileCols; j++)        //j ~ x-coor of obj in xy plane
                {
                    tileManager[i][j] = Integer.parseInt(numbers[j]);
                }
            }

            //Close the file
            inputFile.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Fail to open file!");
        }
    }


//--------------------------------  Diplaying Map + Objects on map ------------------------------------------------------------

    //Draw Map (draw every tile + items + monsters + player)
    public void drawMap()
    {
        for(int i = 0; i < maxTileRows; i++)        // i ~ y-coordinate
        {
            for(int j = 0; j < maxTileCols; j++)    // j ~ x-coordinate
            {    
                if(player != null && i == player.getY() && j == player.getX() )             //1. Draw player first
                {
                    tile[tileManager[i][j]].drawTile(player.getMark());   
                }
                else if(containMonsterAt(j, i))                                             //2. Draw monsters
                {
                    tile[tileManager[i][j]].drawTile(correspondingMonsterAt(j, i).getMark());
                }
                else if(containItemAt(j, i))                                                //3. Draw items
                {
                    tile[tileManager[i][j]].drawTile(correspondingItemAt(j, i).getMark());      
                }
                else                                                                        //4. Draw tiles
                {
                    tile[tileManager[i][j]].drawTile("");
                }
            }
            System.out.println("");
        }
    }



//---------------------------------------------- Searching Objects ------------------------------------------------------------

    //Check if position (x, y) contains any monster
    public boolean containMonsterAt(int x, int y)
    {
        boolean contain = false;
        for(int i = 0; i < this.monsters.size(); i++)
        {
            if(this.monsters.get(i).getX() == x && this.monsters.get(i).getY() == y)
            {
                contain = true;
                break;
            }
        }
        return contain;
    }
   
    
    //Find the monster in the list whose position is (x, y)
    public Character correspondingMonsterAt(int x, int y)
    {
        Character monsterToFind = null;
        for(int i = 0; i < monsters.size(); i++)
        {
            if(monsters.get(i).getX() == x && monsters.get(i).getY() == y)
            {
                monsterToFind = monsters.get(i);
                break;
            }
        }
        return monsterToFind;
    }


    //Check if position (x, y) contains any item
    public boolean containItemAt(int x, int y)
    {
        boolean contain = false;
        for(int i = 0; i < this.items.size(); i++)
        {
            if(this.items.get(i).getX() == x && this.items.get(i).getY() == y)
            {
                contain = true;
                break;
            }
        }
        return contain;
    }


    //Find the item in the list whose position is (x, y)
    public Item correspondingItemAt(int x, int y)
    {
        Item itemToFind = null;
        for(int i = 0; i < this.items.size(); i++)
        {
            if(this.items.get(i).getX() == x && this.items.get(i).getY() == y)
            {
                itemToFind = this.items.get(i);
                break;
            }
        }
        return itemToFind;
    }


    //Check if the area at position (x, y) is solid
    boolean isSolidAt(int x, int y)
    {
        boolean solid = false;
        if(this.tile[tileManager[y][x]].getSolid() == true)
        {
            solid = true;
        }
        return solid;
    }

//---------------------------------------------- Setting Objects ------------------------------------------------------------

    //Adding the player in the map: position of player reset to (0, 0) by default
    public void addPlayer(Character player)
    {
        if(this.player != null)
        {
            System.out.println("ERROR: Cannot Add More Hero (Player) in This Map");
        }
        else
        {
            this.player = player;
            this.player.setX(0);
            this.player.setY(0);
        }
    }


    //Adding a monster in the map
    public void addMonster(Character monster)
    {
        if(!isSolidAt(monster.getX(), monster.getY()))
        {
            this.monsters.add(monster);
        }
        else
        {
            System.out.println("ERROR: You Cannot Set a Monster into a Solid Area!");
        }
    }


    //Adding an item in the map
    public void addItem(Item item)
    {
        if(!isSolidAt(item.getX(), item.getY()))
        {
            this.items.add(item);
        }
        else
        {
            System.out.println("ERROR: You Cannot Set an Item into a Solid Area!");
        }
    }


    //Remove a monster from map
    public void removeMonsterHavingPosition(int x, int y)
    {
        //Search monster having postion (x,y) in the list
        boolean found = false;
        for(Character monster: this.monsters)
        {
            if(monster != null && monster.getX() == x && monster.getY() == y)
            {
                found = true;
                this.monsters.remove(monster);
                break;
            }
        }

        if(!found)
        {
            System.out.println("ERROR: Not Found Corresponding Monster to Delete!");
        }      
    }


    //Remove an Item from map
    public void removeItemHavingPosition(int x, int y)
   {
       //Search item having postion (x,y) in the list
       boolean found = false;
       for(Item item: this.items)
       {
           if(item != null && item.getX() == x && item.getY() == y)
           {
               found = true;
               this.items.remove(item);
               break;
           }
       }

       if(!found)
       {
           System.out.println("ERROR: Not Found Corresponding Item to Delete!");
       }      
   }


//---------------------------------------------- Check Validation of Moving ------------------------------------------------------------

   public boolean validMove(Character obj, int dx, int dy)
   {
        int x_toCome = obj.getX() + dx;
        int y_toCome = obj.getY() + dy;

        if(x_toCome >= maxTileCols || x_toCome < 0 || y_toCome >= maxTileRows || y_toCome < 0)   //if obj move out of border
        {
            return false;
        }
        else if(this.tile[tileManager[y_toCome][x_toCome]].getSolid() == true)     //if obj collides solid tile after moving
        {
            return false;
        }
        else
        {
            return true;
        }
   }
   








   //Embedded Main
   public static void main(String[] args) 
   {
        Player hero = new Player("Hero", 0, 0, 0, 0, 0, 0);

        String path = "G:\\Code Java\\RPG_TEST_FORME\\RPG_FOR_ME\\src\\InputFile\\map1.txt";
        Map map = new Map(path);

        //map.addItem(new Armor("ARmor", 0, 0, 5, 2));
        //map.addItem(new Armor("ARmor", 0, 0, 17, 17));
        //map.addMonster(new We("Wolf", 19, 19));
        //map.addItem(new LongRangeWeapon("Ac", 0, 0, 18, 18));
        //map.addPlayer(hero);

        map.drawMap();
   }
}
