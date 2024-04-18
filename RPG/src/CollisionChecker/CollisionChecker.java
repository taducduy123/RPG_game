package CollisionChecker;

import GameMain.GameMain;
import BasicSetting.BasicSetting;
import ENTITY.Character;

public class CollisionChecker implements BasicSetting
{
    private GameMain gm;


//------------------------------------------
    //Constructor
    public CollisionChecker(GameMain gm)
    {
        this.gm = gm;
    }


//------------------------------------ Check if character collides solid -----------------------------------------

    public boolean collideSolidAfterUp(Character obj)
    {
        boolean collision = false;
        int y_afterUp = obj.getY() - 1;    

        if(y_afterUp >= 0 && gm.map.tileManager[y_afterUp][obj.getX()] == 0)  
        {
            collision = true;
        }
        return collision;
    }


    public boolean collideSolidAfterDown(Character obj)
    {
        boolean collision = false;
        int y_afterDown = obj.getY() + 1;

        if(y_afterDown < maxTileRows &&  gm.map.tileManager[y_afterDown][obj.getX()] == 0)                //a[][]
        {
            collision = true;
        }
        return collision;
    }


    public boolean collideSolidAfterLeft(Character obj)
    {
        boolean collision = false;
        int x_afterLeft = obj.getX() - 1;

        if(x_afterLeft >= 0 && gm.map.tileManager[obj.getY()][x_afterLeft] == 0)
        {
            collision = true;
        }
        return collision;
    }


    public boolean collideSolidAfterRight(Character obj)
    {
        boolean collision = false;
        int x_afterRight = obj.getX() + 1;          // > 0  

        if(x_afterRight < maxTileCols && gm.map.tileManager[obj.getY()][x_afterRight] == 0)  
        {
            collision = true;
        }
        return collision;
    }


    public static void main(String[] args) 
    {
        GameMain gm = new GameMain();       //pos_x = 0, pos_y = 0

        gm.map.drawMap();
        gm.player.moveDown();
        

        CollisionChecker ck = new CollisionChecker(gm);
        System.out.println(ck.collideSolidAfterDown(gm.player));
    }
}
