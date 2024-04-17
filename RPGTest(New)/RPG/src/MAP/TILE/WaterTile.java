package MAP.TILE;

public class WaterTile extends Tile
{
    private int heal;

    //---------------------------------------------------
    public WaterTile()
    {   
        
    }

    @Override
    public void drawTile(String mark)
    {
        System.out.print(" ("  +  mark + ") ");
    }    

    //public void applyEffect(Character ch) /// hoi mau
}
