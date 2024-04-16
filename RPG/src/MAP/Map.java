package MAP;
import BasicSetting.*;
import MAP.TILE.*;
import java.io.*;
import java.util.*;
import FileText.*;
import ENTITY.Character;
import ENTITY.*;




public class Map implements BasicSetting
{
    private Tile[] tile;
    private int[][] tileManager;
    private Player player;        //Link to EntireGame

    
    
//-----------------------------------------------------

    //Constructor
    public Map(String mapFilePath, Player player)
    {
        //Reference to the "player in the EntireGame"
        this.player = player;

        //All possible types of Tile
        this.tile = new Tile[maxTypeOfTile];
        tile[0] = new WallTile();
        tile[1] = new LandTile();
        tile[2] = new WaterTile();
        tile[3] = new FireTile();
    
        //Using 2D-array to store tokens in file .txt
        this.tileManager = new int[maxTileRows][maxTileCols];
        loadMap(mapFilePath);

        /*
        //All possible type of Monster
        monster[0] = null;
        monster[1] = new Wolf(0, 0);
        monster[2] = new Lion(0, 0);

        //this.monsterManager = new int[maxTileRows][maxTileCols];
        //loadMonsters(mapFilePath)
        */
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

            for(int i = 0; i < maxTileRows; i++)
            {
                //Read every line in text file
                line = inputFile.nextLine();

                //Get tokens from the line
                String[] numbers = line.split(" ");

                //Load all tokens into int[][] tileManager
                for(int j = 0; j < maxTileCols; j++)
                {
                    tileManager[i][j] = Integer.parseInt(numbers[j]);
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Fail to open file!");
        }

    }



    //public abstract void setMonsters();

    /* 
    public void loadMonsters(String mapFilePath)
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

            for(int i = 0; i < maxTileRows; i++)
            {
                //Read every line in text file
                line = inputFile.nextLine();

                //Get tokens from the line
                String[] numbers = line.split(" ");

                //Load all tokens into int[][] tileManager
                for(int j = 0; j < maxTileCols; j++)
                {
                    monsterManager[i][j] = Integer.parseInt(numbers[j]);
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Fail to open file!");
        }
    }
    */


    public void drawMap(String PlayerMark)
    {
        for(int i = 0; i < maxTileRows; i++)
        {
            for(int j = 0; j < maxTileCols; j++)
            {    
                if(i == player.getY() && j == player.getX() )  //Draw player first
                {
                    tile[tileManager[i][j]].drawTile(PlayerMark);   
                }
                else                                            //Draw tiles
                {
                    tile[tileManager[i][j]].drawTile(" ");
                }
            }
            System.out.println("");
        }
    }


    //Embedded Main
    public static void main(String[] args) 
    {
        String path = "D:\\RPGTest\\RPG\\src\\FileText\\map1.txt"; //linkPath sẽ khác nhau khi tải về máy, lưu ý update lại linkPath trước khi chạy

        Player player = new Player("Hero", 100, 100, 50, 30);
        player.setX(2);


        Map game = new Map(path, player);

        game.drawMap(game.player.getMark());
    }
    
}