package ITEM;
import CHARACTER.Character;

public abstract class Item 
{
    private String name;
    private int type;
    private int x;
    private int y;
    
//-------------------------------------------------

    public Item(String name, int type, int x, int y)
    {
        this.name = name;  
        this.type = type;
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
    public int getType()
    {return this.type;}


    //Abstract Methods
    public abstract String getMark();
    public abstract void applyEffectTo(Character obj);
    public abstract void unapplyEffectTo(Character obj);


    

}
