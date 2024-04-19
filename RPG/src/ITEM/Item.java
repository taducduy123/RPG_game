package ITEM;


public abstract class Item 
{
    private String name;
    private int x;
    private int y;
    
//-------------------------------------------------

    public Item(String name, int x, int y)
    {
        this.name = name;  
        this.x = x;
        this.y = y;
    }


    //Getter Methods
    public int getX()
    {return this.x;}
    public int getY()
    {return this.y;}
    public String getName()
    {return this.name;}


    //Abstract Methods
    public abstract String getMark();
    public abstract int getType();

}
