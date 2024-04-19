package ITEM;

import java.util.*;
import java.util.stream.Stream;

public class Inventory 
{
    private int cap;
    private List<Item> items;

//------------------------------------------------------------
    //Constructor
    public Inventory(int cap)
    {
        this.cap = cap;
        this.items = new ArrayList<>(cap);
    }

    //Display
    public void displayInventory()
    {
        //Sort list by type
        List<Item> sortedList = this.items.stream()
                                    .sorted((item1, item2) -> {
                                        return item1.getType() - item2.getType();
                                    })
                                    .sorted((item1, item2) -> {
                                        return item1.getName().compareToIgnoreCase(item2.getName());
                                    })
                                    .toList();


        System.out.printf("%10s %20s %10s \n", "No.",
                                                       "Name",
                                                       "Type");
        for(int i = 0; i < sortedList.size(); i++)
        {
            System.out.printf("%10d %20s %10d \n", i + 1, 
                                                        sortedList.get(i).getName(),
                                                        sortedList.get(i).getType());
        }
       
    }
        
    //Add Item
    public void addItem(Item item)
    {
        if(this.items.size() >= cap)
        {
            //System.out.println();
        }
        else
        {
            this.items.add(item);
        }
    }

    //Remove Item
    public void removeItemByIndex(int index)
    {
        if(this.items.isEmpty())
        {
            //System.out.println();
        }
        else
        {                                                                       //list = i1, i2 , i3
            this.items.remove(index);
        }
    }

    //isFull
    public boolean isFull()
    {
        if(this.items.size() >= this.cap)
            return true;
        else    
            return false;
    }

    //isEmpty

    public boolean isEmpty()



    {
        if(this.items.isEmpty())
            return true;
        else    
            return false;
    }
    public static void main(String[] args) 
    {
        
        Item[] list = new Item[5];
        list[0] = new Axe(0, 0);
        list[1] = new Sword(0, 0);
        list[2] = new Axe(0, 0);
        list[3] = new Sword(0, 0);
        list[4] = new Axe(0, 0);

        Inventory inven = new Inventory(5);
        /* 
        
        for(int i = 0; i < 5; i++)
        {
           inven.addItem(list[i]);
        }
        */

        inven.displayInventory();
        System.out.println("\n");
        System.out.println(inven.isEmpty());


        //inven.removeItemByIndex(0);
        //inven.displayInventory();
        //System.out.println("\n");


    }
}
