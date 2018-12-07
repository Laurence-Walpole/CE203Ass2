import engine.Constants;
import engine.renderer.GamePanel;
import engine.renderer.InventoryPanel;
import engine.utilities.Loader;
import engine.utilities.PlayerKeyListener;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static GameWindow gw = new GameWindow();
    public static void main(String[] args){
        init();

        gw.setLayout(null);

        Constants.gamePanel.gameLoop();
    }

    private GameWindow(){
        setTitle("CE203 Assignment | 1604065");
        setSize(Constants.WINDOW_SIZE + 12, Constants.WINDOW_SIZE + 44 + 170);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new PlayerKeyListener());
        //setResizable(false);
        setVisible(true);
    }

    private static void init(){
        Loader.loadEntities();
        Loader.loadMap();

        Constants.gamePanel.setBounds(0, 0, Constants.WINDOW_SIZE, Constants.WINDOW_SIZE);
        Constants.inventoryPanel.setBounds(Constants.WINDOW_SIZE, Constants.WINDOW_SIZE -170 , Constants.WINDOW_SIZE, 170);
        Constants.inventoryPanel.setBackground(Color.BLUE);
        gw.add(Constants.gamePanel);
        gw.add(Constants.inventoryPanel);
    }
}
