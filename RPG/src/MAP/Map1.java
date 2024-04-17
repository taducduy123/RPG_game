package MAP;
import GameMain.GameMain;
import ITEM.Axe;
import ITEM.Sword;

public class Map1 extends Map
{
   
    
//-------------------------------------

    //Constructor
    public Map1(String mapFilePath, GameMain gm)
    {
        super(mapFilePath, gm);
    }

    @Override
    public void setItems() 
    {
        super.items.add(new Axe(3, 0));
        super.items.add(new Sword(10, 2));
    }

}
