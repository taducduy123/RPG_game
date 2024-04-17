package GameMain;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import BasicSetting.BasicSetting;
import CollisionChecker.CollisionChecker;
import ENTITY.Player;
import ENTITY.Wolf;
import ENTITY.Character;
import ENTITY.Lion;
import MAP.*;

public class GameMain implements BasicSetting
{
     
    //Create hero
    public Player player = new Player("Hero", 100, 100, 10, 10);

    //Create monsters
    public List<Character> monsters;
    

    //Create Map
    String map1FilePath = "G:\\Code Java\\RPGTest(New)\\RPG\\src\\FileText\\map1.txt";       //NOTICE: this link can be changed when moving to another device
    public Map map = new Map1(map1FilePath, this);

    
    //Create tool to check collision
    public CollisionChecker cCheck = new CollisionChecker(this);


//--------------------------------------------------------

    //Constructor
    public GameMain()
    {
        this.SettingMonsters();
    }


    //SettingMonsters
    public void SettingMonsters()
    {
        this.monsters = new LinkedList<>();
        monsters.add(new Wolf(3, 2));
        monsters.add(new Wolf(19, 19));
        monsters.add(new Lion(8, 5));
    }


    //Start Game
    public void start()
    {
        //
        map.drawMap();
        System.out.println("");

        //Read input from keyboard
        Scanner keyboard = new Scanner(System.in);

        int choice;

        do
        {
            System.out.println("\n------------------------------------------------------\n");
            System.out.println("1. Move Up");
            System.out.println("2. Move Down");
            System.out.println("3. Move Left");
            System.out.println("4. Move Right");
            System.out.println("5. No Move");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = keyboard.nextInt();

            switch (choice) 
            {
                case 1:
                        characterMove("up", player);
                        updateMonsters();
                        map.drawMap();
                        break;

                case 2:
                        characterMove("down", player);
                        updateMonsters();
                        map.drawMap();
                        break;

                case 3:
                        characterMove("left", player);
                        updateMonsters();
                        map.drawMap(); 
                        break;

                case 4:
                        characterMove("right", player);
                        updateMonsters();
                        map.drawMap(); 
                        break;  
                case 5:
                        updateMonsters();
                        map.drawMap();
                        break;
                case 6:
                        System.out.println("See You Next Time");
                        break;
                default:
                        System.out.println("Invalid choice!");
                        break;
            }
        } while(choice != 6);

        //this.map.drawMap();
    }
    

    public void characterMove(String direction, Character obj)            //Move with cheking collision
    {
        switch (direction) 
        {
            case "up":
                        if(!cCheck.collideSolidAfterUp(obj))
                            obj.moveUp();
                        break;

            case "down":
                        if(!cCheck.collideSolidAfterDown(obj))
                            obj.moveDown();
                        break;
                
            case "left":
                        if(!cCheck.collideSolidAfterLeft(obj))
                            obj.moveLeft();
                        break;

            case "right":
                        if(!cCheck.collideSolidAfterRight(obj))
                            obj.moveRight();
                        break;

            default:
                    System.out.println("Invalid direction!");
                    break;
        }
    }


    public void randomMove(Character monster)
    {
        Random random = new Random();
        int ranNum = random.nextInt(100) + 1;       //1,2,3,...,100

        if (ranNum <= 25) 
        {
            characterMove("up", monster);
        }
        else if (ranNum > 25 && ranNum <= 50)
        {
            characterMove("down", monster);
        }
        else if(ranNum > 50 && ranNum <= 75)
        {
            characterMove("left", monster);
        }
        else
        {
            characterMove("right", monster);
        }
    }


    public void updateMonsters()
    {
        for(int i = 0; i < this.monsters.size(); i++)
        {
            randomMove(this.monsters.get(i));
        }
    }



    public static void main(String[] args) 
    {
        GameMain game = new GameMain();
        game.start();
    }
}
