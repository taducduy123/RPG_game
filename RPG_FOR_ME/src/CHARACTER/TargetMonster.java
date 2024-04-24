package CHARACTER;

import java.util.Random;

import ITEM.*;

public class TargetMonster extends Monster
{
 



//-----------------------------------------------------------

    //Constructor
    public TargetMonster(String name, int maxHP, int atk, int def, int x, int y) 
    {
        super(name, maxHP, atk, def, 1, x, y); 
        this.setItemToDrop();   
    }

//----------------------------- Override Methods -------------------------------------------------
    @Override
    public String getMark() 
    {
        return "TM";
    }


    @Override
    public void setItemToDrop() 
    {
        this.itemsToDrop.add(new Armor("Shield", 10, 10, this.getX(), this.getY()));
        this.itemsToDrop.add(new Armor("Shield", 10, 10, this.getX(), this.getY()));
        this.itemsToDrop.add(new Potion("Big Potion", 40, this.getX(), this.getY()));
        this.itemsToDrop.add(new Potion("Small Potion", 10, this.getX(), this.getY()));
        this.itemsToDrop.add(new Potion("Small Potion", 10, this.getX(), this.getY()));
        this.itemsToDrop.add(new Potion("Small Potion", 10, this.getX(), this.getY()));
        this.itemsToDrop.add(new Potion("Small Potion", 10, this.getX(), this.getY()));
    }


    @Override
    public Item lootItem() 
    {
        Random random = new Random();
        int ranNum = random.nextInt(100) + 1;       //1,2,3,....,100

        Item itemToLoot = null;
        //Loot root = 60%
        if(ranNum <= 60)
        {
            ranNum = random.nextInt(itemsToDrop.size()) + 1;            //1,2,3, .... size of itemToDrop
            itemToLoot = itemsToDrop.get(ranNum - 1);
        }
        
        return itemToLoot;     
    }


    public static void main(String[] args) 
    {
        TargetMonster monster = new TargetMonster("monster", 0, 0, 0, 0, 0);
        
        Item item = monster.lootItem();

        if(item == null)
        {
            System.out.println("null");
        }
        else
        {
            System.out.println(item);
        }
        
    }
}
