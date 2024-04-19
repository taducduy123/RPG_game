package ITEM;

public class Sword extends Weapon
{

//--------------------------------------------

    //Constructor
    public Sword(int x, int y)
    {
        super("Sword", x, y, 30, 30);
    }


    @Override
    public String getMark()
    {return "S";}

    @Override
    public int getType()
    {return 1;}
}
