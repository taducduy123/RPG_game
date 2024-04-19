package ApplyingUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameMain.GameMain;

import java.awt.event.*;


public class KeyListenerExample extends JFrame 
{
    private GameMain gm = new GameMain();
    JPanel panel = new JPanel();
    JLabel message = new JLabel("Press [A], [D], [S], [W] to move the character and see the output in terminal port");

//---------------------------------------------------

    //Constructor
    public KeyListenerExample()
    {
        final int WIDTH = 500;
        final int LENGTH = 500;

        this.setSize(WIDTH, LENGTH);
        this.add(message);
        //this.pack();

        this.addKeyListener(new KeyHandler());
        this.setVisible(true);
    }

    //Private class
    private class KeyHandler implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) 
        {
            
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            int code = e.getKeyCode();
            
            if(code == KeyEvent.VK_A)
            {
                //System.out.println("You are entering A");
                gm.characterMove("left", gm.player);
                gm.updateMonsters();
                gm.map.drawMap();
                System.out.println("--------------------------------------------------------------------------\n");
            }
            else if(code == KeyEvent.VK_D)
            {
                //System.out.println("You are entering D");
                gm.characterMove("right", gm.player);
                gm.updateMonsters();
                gm.map.drawMap();
                System.out.println("--------------------------------------------------------------------------\n");
            }
            else if(code == KeyEvent.VK_W)
            {
                //System.out.println("You are entering W");
                gm.characterMove("up", gm.player);
                gm.updateMonsters();
                gm.map.drawMap();
                System.out.println("--------------------------------------------------------------------------\n");
            }
            else if(code == KeyEvent.VK_S)
            {
                //System.out.println("You are entering S");
                gm.characterMove("down", gm.player);
                gm.updateMonsters();
                gm.map.drawMap();
                System.out.println("--------------------------------------------------------------------------\n");
            }
            else
            {
                //System.out.println("You don't press any key of A,S,D,W");
                gm.updateMonsters();
                gm.map.drawMap();
                System.out.println("--------------------------------------------------------------------------\n");
            }
                
        }

        @Override
        public void keyReleased(KeyEvent e) 
        {
            int code = e.getKeyCode();
            if(code == KeyEvent.VK_A)
            {
                //System.out.println("You are releasing A");
            }
            else if(code == KeyEvent.VK_D)
            {
                //System.out.println("You are releasing D");
            }
            else if(code == KeyEvent.VK_W)
            {
                //System.out.println("You are releasing W");
            }
            else if(code == KeyEvent.VK_S)
            {
                //System.out.println("You are releasing S");
            }
        }

    }

    public static void main(String[] args) 
    {
        KeyListenerExample ex = new KeyListenerExample();
    }
}
