package engine;

import engine.Constants;
import engine.utilities.Loader;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(){
        setTitle("CE203 Assignment | 1604065");
        setSize(800, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        //Do some other stuff
        init();

        setVisible(true);
    }

    private void init(){
        Loader.loadMap();
        Loader.loadEntities();
        Constants.GAME_MAP.drawMap(this);
    }
}
