import engine.Constants;
import engine.utilities.Loader;
import engine.utilities.Tile;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JComponent {

    public static JFrame gameFrame = new JFrame("CE203 Assignment | 1604065");

    public static void main(String[] args){
        init();
        gameFrame.setSize(Constants.WINDOW_SIZE + 21, Constants.WINDOW_SIZE + 44);
        gameFrame.add(new GameWindow());
        gameFrame.setBackground(Color.GRAY);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    public void paintComponent(Graphics graphics){
        for (Tile tile : Constants.GAME_MAP.getTileList()){
            tile.drawTile(graphics);
        }
    }

    private static void init(){
        Loader.loadMap();
        Loader.loadEntities();
    }
}
