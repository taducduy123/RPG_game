package ENTITY;

public class Wolf extends Character 
{

//-----------------------------------------------

    //Constructor
    public Wolf(int x, int y)
    {
        super("Wolf", 20, 20, 10, 10, x, y);
    }

    @Override
    public String getMark() 
    {
        return "W";
    }
}
