package MAP.TILE;

import ENTITY.Character;

public class WallTile extends Tile
{

//-----------------------------------------

    public WallTile()
    {   
        
    }

    @Override
    public void drawTile(String mark)
    {
        System.out.print(" <"  + "0" + "> ");
    }

    @Override
    public void applyEffectTo(Character character) 
    {
        
    }
    
}
