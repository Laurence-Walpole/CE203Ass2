import engine.Constants;
import engine.utilities.Highscores;
import engine.utilities.InventoryMouseListener;
import engine.utilities.Loader;
import engine.utilities.PlayerKeyListener;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static GameWindow gw = new GameWindow();
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null,
                "Welcome!\n\n" +
                        "You control the Player using 'WASD'\n" +
                        "You open chests (the gold squares) using 'E'\n" +
                        "You attack monsters (red circles) using 'Space'\n" +
                        "To attack a monster you must be next to it.\n" +
                        "Monsters cannot go through doors (brown squares)\n" +
                        "You can equip any equipment you find in your inventory panel\n" +
                        "Any consumable items you can eat/use to add bonuses to your character"
        );
        Highscores.loadHighscores();
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
        setLocationRelativeTo(null);
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
