package MAP.TILE;

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

    
}
