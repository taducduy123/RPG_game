package MAP.TILE;

import ENTITY.Character;
public abstract class Tile 
{
    

//--------------------------------------------------

    //Constructor
    public Tile()
    {
        
    }

    //Abstract
    public abstract void drawTile(String mark);
    public abstract void applyEffectTo(Character character);

}
