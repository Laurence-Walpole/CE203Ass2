import engine.Constants;
import engine.utilities.InventoryMouseListener;
import engine.utilities.Loader;
import engine.utilities.PlayerKeyListener;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static GameWindow gw = new GameWindow();
    public static void main(String[] args){
        init();
        Constants.inventoryPanel.repaint();
        Constants.gamePanel.gameLoop();
    }

    private GameWindow(){
        setTitle("CE203 Assignment | 1604065");
        setSize(Constants.WINDOW_SIZE + 12, Constants.WINDOW_SIZE + 34 + 170);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new PlayerKeyListener());
        addMouseListener(new InventoryMouseListener());
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    private static void init(){
        Loader.loadEntities();
        Loader.loadMap();

        Constants.gamePanel.setBounds(0, 0, Constants.WINDOW_SIZE, Constants.WINDOW_SIZE);
        Constants.inventoryPanel.setBounds(0, Constants.WINDOW_SIZE, Constants.WINDOW_SIZE, 170);
        gw.add(Constants.gamePanel);
        gw.add(Constants.inventoryPanel);
    }
}
