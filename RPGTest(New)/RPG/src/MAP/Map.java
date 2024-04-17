package MAP;
import BasicSetting.*;
import MAP.TILE.*;
import java.io.*;
import java.util.*;
import FileText.*;
import GameMain.GameMain;
import ITEM.Axe;
import ITEM.Item;
import ITEM.Sword;
import ENTITY.Character;
import ENTITY.*;




public abstract class Map implements BasicSetting
{
    private Tile[] tile;
    public int[][] tileManager;

    protected List<Item> items;

    private GameMain gm;           //Link to Main Game
    
    
    
//-----------------------------------------------------

    //Constructor
    public Map(String mapFilePath, GameMain gm)
    {
        //Reference to the "player in the EntireGame"
        //this.player = player;

        //Reference to GameMain
        this.gm = gm;

        //Create List to store items then setting items
        this.items = new LinkedList<>();
        setItems();

        //All possible types of Tile
        this.tile = new Tile[4];
        tile[0] = new WallTile();
        tile[1] = new LandTile();
        tile[2] = new WaterTile();
        tile[3] = new FireTile();
    
        //Using 2D-array to store tokens in file .txt
        this.tileManager = new int[maxTileRows][maxTileCols];
        loadMap(mapFilePath);
    }


    //Read a specific map from file .txt
    public void loadMap(String mapFilePath)
    {
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

            //
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
        } 
        catch (Exception e) {
            System.out.println("Fail to open file!");
        }

    }


    //Setting items in the map
    public abstract void setItems();
    

    //drawMap
    public void drawMap()
    {
        for(int i = 0; i < maxTileRows; i++)        // i ~ y-coordinate
        {
            for(int j = 0; j < maxTileCols; j++)    // j ~ x-coordinate
            {    
                if(i == gm.player.getY() && j == gm.player.getX() )  //Draw player first
                {
                    tile[tileManager[i][j]].drawTile(gm.player.getMark());   
                }
                else if(containMonsterAt(j, i))                      //Draw monsters
                {
                    tile[tileManager[i][j]].drawTile(correspondingMonsterAt(j, i).getMark());
                }
                else if(containItemAt(j, i))                        //Draw items
                {
                    tile[tileManager[i][j]].drawTile(correspondingItemAt(j, i).getMark());      
                }
                else                                                 //Draw tiles
                {
                    tile[tileManager[i][j]].drawTile(" ");
                }
            }
            System.out.println("");
        }
    }


    //Check if position (x, y) contains any monster
    public boolean containMonsterAt(int x, int y)
    {
        boolean contain = false;
        for(int i = 0; i < gm.monsters.size(); i++)
        {
            if(gm.monsters.get(i).getX() == x && gm.monsters.get(i).getY() == y)
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
        for(int i = 0; i < gm.monsters.size(); i++)
        {
            if(gm.monsters.get(i).getX() == x && gm.monsters.get(i).getY() == y)
            {
                monsterToFind = gm.monsters.get(i);
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



    //Embedded Main
    public static void main(String[] args) 
    {
        //String path = "D:\\RPGTest\\RPG\\src\\FileText\\map1.txt"; //linkPath sẽ khác nhau khi tải về máy, lưu ý update lại linkPath trước khi chạy

        //Player player = new Player("Hero", 100, 100, 50, 30);
        //player.setX(2);


        //Map game = new Map(path, player);

        //game.drawMap(game.player.getMark());


        GameMain newGame = new GameMain();
        newGame.start();
    }
    
}