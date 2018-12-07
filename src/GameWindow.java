import engine.Constants;
import engine.Entity;
import engine.Game;
import engine.entities.NPC;
import engine.utilities.Loader;
import engine.utilities.Tile;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public static void main(String[] args){
        init();
        GameWindow gw = new GameWindow();
        GamePanel gp = new GamePanel();
        gw.add(gp);

        gp.gameLoop();
    }

    public GameWindow(){
        setTitle("CE203 Assignment | 1604065");
        setSize(Constants.WINDOW_SIZE + 21, Constants.WINDOW_SIZE + 44);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private static void init(){
        Loader.loadEntities();
        Loader.loadMap();
    }
}
