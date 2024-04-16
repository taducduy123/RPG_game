package ENTITY;

public abstract class Character
{
    private String Name;
    private int HP, maxHP;
    private int Attack;
    private int Defense;
    private int x;
    private int y;

//---------------------------------------------------
    public Character(String name, int hp, int maxhp, int at, int def, int x, int y)
    {
        this.Name = name;
        this.HP = hp;
        this.maxHP = maxhp;
        this.Attack = at;
        this.Defense = def;
        this.x = x;
        this.y = y;
    }


    //Getter Methods
    public int getX()
    {return this.x;}
    public int getY()
    {return this.y;}

    //Setter Methods
    public void setX(int x)
    {this.x = x;}
    public void setY(int y)
    {this.y = y;}

    //Abstract Methods
    public abstract String getMark();
   
}
