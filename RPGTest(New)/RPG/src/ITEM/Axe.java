package ITEM;

public class Axe extends Weapon
{

//------------------------------------

    //Constructor
    public Axe(int x, int y)
    {
        super("Axe", x, y, 10, 10);
    }

    @Override
    public String getMark()
    {return "A";}
}
