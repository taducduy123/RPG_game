package MAP.TILE;

import ENTITY.Character;
import ENTITY.Player;

public class FireTile extends Tile
{
    private int lossHP = 10;

//---------------------------------------------------
    public FireTile()
    {   
        
    }

    @Override
    public void drawTile(String mark)
    {
        System.out.print(" {" + mark + "} ");
    }

    @Override
    public void applyEffectTo(Character character) 
    {
        character.takeDamage(lossHP);
    }    

     

    public static void main(String[] args) 
    {
        Player player = new Player("null", 100, 100, 0, 0);

        Tile fTile = new FireTile();
        fTile.applyEffectTo(player);

        player.showState();
    }
}
