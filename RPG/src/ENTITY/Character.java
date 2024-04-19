package ENTITY;

import BasicSetting.BasicSetting;

public abstract class Character implements BasicSetting
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
    public int getMaxHp()
    {return this.maxHP;}
    public int getHP()
    {return this.HP;}

    //Setter Methods
    public void setX(int x)
    {this.x = x;}
    public void setY(int y)
    {this.y = y;}


    //Other usefull methods
    public void heal(int hpToHeal)
    {
        if(HP < maxHP)          
        {
            if(HP + hpToHeal >= maxHP)
            {
                HP = maxHP;
            }
            else
            {
                HP += hpToHeal;
            }
        }
    }
    public void takeDamage(int dame)
    {
        HP -= dame;
    }

    //Abstract Methods
    public abstract String getMark();
   

    public void moveUp()
    {
        int y_afterUp = this.y - 1;
        if(!(y_afterUp < 0 || y_afterUp >= maxTileRows))        //Check if character move out of screen
        {        
            this.y = y_afterUp;
        }
    }

    public void moveDown()
    {
        int y_afterDown = this.y + 1;
        if(!(y_afterDown < 0 || y_afterDown >= maxTileRows))        //Check if character move out of screen
        {
            this.y = y_afterDown;
        }
    }
    

    public void moveLeft()
    {
        int x_afterLeft = this.x - 1;
        if(!(x_afterLeft < 0 || x_afterLeft >= maxTileCols))        //Check if character move out of screen
        {
            this.x = x_afterLeft;
        }
    }


    public void moveRight()
    {
        int x_afterRight = this.x + 1;
        if(!(x_afterRight < 0 || x_afterRight >= maxTileCols))        //Check if character move out of screen
        {
            this.x = x_afterRight;
        }       
    }

    

   
    
}
