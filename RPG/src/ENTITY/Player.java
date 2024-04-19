package ENTITY;

public class Player extends Character
{
    
//-------------------------------------------

    //Constructor
    public Player(String name, int hp, int maxhp, int at, int def)
    {
        super(name, hp, maxhp, at, def, 0, 0);
    }


    @Override
    public String getMark()
    {return "X";}

    //Show state of player
    public void showState()
    {
        System.out.println("HP: " + this.getHP() + " / " + this.getMaxHp());
    }
}
