package ApplyingUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import GameMain.GameMain;
import java.awt.event.*; // Needed for ActionListener Interface
import java.awt.*; //for color


public class GameContentPane extends JFrame
{
    private JPanel panel;
    private JButton buttonUp, buttonDown, buttonLeft, buttonRight, buttonNoMove;

    GameMain gm = new GameMain();

    private final int WIDTH_SCREEN = 600;
    private final int HEIGHT_SCREEN = 600;


    //Constructor
    public GameContentPane()
    {
        // 1. Setting Frame
        this.setTitle("2D RPG");
        this.setSize(WIDTH_SCREEN, HEIGHT_SCREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));          //Adjust every at center with horizontal gap = 20 and vertical gap = 20

        // 2. Build Panel and add to the Content Pane
        buildPanel();

        // 3. Add Panel to the Content Pane
        this.add(panel);
        this.pack();                                    //Make Content Pane and Panel allign

        // 4. Add ActionListener for each component of Panel 
        buttonUp.addActionListener(new handleButtonUp());
        buttonDown.addActionListener(new handleButtonDown());
        buttonLeft.addActionListener(new handleButtonLeft());
        buttonRight.addActionListener(new handleButtonRight());
        buttonNoMove.addActionListener(new handleButtonNoMove());

        // 5. Display Frame
        this.setVisible(true);
    }


//---------------------------------- Bulid Panel (private) ------------------------------------------

    private void buildPanel()
    {
        // 1. Create button and add them to panel
        buttonUp = new JButton("Move Up");
        buttonDown = new JButton("Move Down");
        buttonLeft = new JButton("Move Left");
        buttonRight = new JButton("Move Right");
        buttonNoMove = new JButton("No Move");

        // 2. Add components to Panel with specifying location with Setting Layout:
        panel = new JPanel();                               //Contain components
        panel.setLayout(new BorderLayout(5, 10)); //Use to adjust layout with vertical gap = 5 and horrizontal gap 10

        panel.add(buttonUp, BorderLayout.NORTH);            //Place buttonUp at the north of layout
        panel.add(buttonDown, BorderLayout.SOUTH);          //Place buttonDown at the south of layout
        panel.add(buttonLeft, BorderLayout.WEST);           //Place buttonLeft at the west of layout
        panel.add(buttonRight, BorderLayout.EAST);          //Place buttonRight at the east of layout
        panel.add(buttonNoMove, BorderLayout.CENTER);       //Place buttonNoMove at the center of layout


    }

//------------------------------- handleButtonUp (inner private CLASS) ----------------------------------------------------
    private class handleButtonUp implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            gm.characterMove("up", gm.player);
            gm.map.drawMap();
            gm.updateMonsters();
            System.out.println("------------------------------------------------------\n");
        }
    }

//------------------------------- handleButtonDown (inner private CLASS) ----------------------------------------------------
    private class handleButtonDown implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            gm.characterMove("down", gm.player);
            gm.map.drawMap();
            gm.updateMonsters();
            System.out.println("------------------------------------------------------\n");
        }
    }

//------------------------------- handleButtonLeft (inner private CLASS) ----------------------------------------------------
    private class handleButtonLeft implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            gm.characterMove("left", gm.player);
            gm.map.drawMap();
            gm.updateMonsters();
            System.out.println("------------------------------------------------------\n");
        }
    }

//------------------------------- handleButtonRight (inner private class) ----------------------------------------------------
    private class handleButtonRight implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            gm.characterMove("right", gm.player);
            gm.map.drawMap();
            gm.updateMonsters();
            System.out.println("------------------------------------------------------\n");
        }
    }


//------------------------------- handleButtonNoMove (inner private class) ----------------------------------------------------
private class handleButtonNoMove implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        gm.updateMonsters();
        gm.map.drawMap();
        System.out.println("------------------------------------------------------\n");
    }
}


    //Embedded Main for Testing
    public static void main(String[] args) 
    {
        GameContentPane game = new GameContentPane();
    }
}
