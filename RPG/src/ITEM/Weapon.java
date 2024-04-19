package ITEM;

public class Weapon extends Item
{
    private int attack;
    private int defense;

//-------------------------------------

    //Constructor
    public Weapon(String name, int x, int y, int attack, int defense)
    {
        super(name, x, y);
        this.attack = attack;
        this.defense = defense;
    }


    @Override
    public String getMark(){return "WP";}

    @Override
    public int getType()
    {return -1;}
}
