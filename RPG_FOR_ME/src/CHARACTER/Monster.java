package CHARACTER;

import java.util.LinkedList;
import java.util.List;

import ITEM.Item;

public abstract class Monster extends Character
{
    protected List<Item> itemsToDrop;

//------------------------------------------

    //Constructor
    public Monster(String name, int maxhp, int atk, int def, int range, int x, int y) 
    {
        super(name, maxhp, atk, def, range, x, y);
        itemsToDrop = new LinkedList<>();
    }



//------------------------------ Getter Method ------------------------------------
    
//------------------------------ Abstract Methods ---------------------------------

    public abstract void setItemToDrop();
    public abstract Item lootItem();
    
}