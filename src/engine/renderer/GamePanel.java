package engine.renderer;

import engine.Constants;
import engine.Entity;
import engine.utilities.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel {

    public void paintComponent(Graphics graphics){
        for (Tile tile : Constants.GAME_MAP.getTileList()) {
            tile.drawTile(graphics);
        }
        for (Entity entity : Constants.ENTITIES_IN_GAME){
            entity.drawEntity(graphics);
        }
        Constants.PLAYER.drawEntity(graphics);
    }

    public void gameLoop(){
        TimerTask tick = new TimerTask() {
            @Override
            public void run() {
                for (Entity entity : Constants.ENTITIES_IN_GAME){
                    entity.doMove();
                }
            }
        };

        TimerTask render = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        Timer t = new Timer();
        t.scheduleAtFixedRate(tick, 0, 1000 / Constants.MAX_UPS);
        t.schedule(render, 0, 1000 / Constants.MAX_FPS);
    }

}
