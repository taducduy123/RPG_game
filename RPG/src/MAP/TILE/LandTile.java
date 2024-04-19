package MAP.TILE;

import ENTITY.Character;

public class LandTile extends Tile
{

//---------------------------------------------

    public LandTile()
    {   
        
    }

    @Override
    public void drawTile(String mark)
    {
        System.out.print(" ["  + mark +   "] ");
    }

    @Override
    public void applyEffectTo(Character character) 
    {
        
    }

    
}
