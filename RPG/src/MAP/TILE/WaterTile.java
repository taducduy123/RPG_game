package MAP.TILE;

import ENTITY.Character;

public class WaterTile extends Tile
{
    private int hpToHeal = 5;

    //---------------------------------------------------
    public WaterTile()
    {   
        
    }

    @Override
    public void drawTile(String mark)
    {
        System.out.print(" ("  +  mark + ") ");
    }

    @Override
    public void applyEffectTo(Character character)
    {
        character.heal(hpToHeal);
    }    

    
}
