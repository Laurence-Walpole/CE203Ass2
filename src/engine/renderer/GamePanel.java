package engine.renderer;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import engine.Constants;
import engine.Entity;
import engine.utilities.Tile;

import javax.swing.*;
import java.awt.*;

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
        while (true){
            tick();
            repaint();
            try {
                Thread.sleep(300);
            }catch(Exception e){

            }
        }
    }

    private void tick(){
        for (Entity entity : Constants.ENTITIES_IN_GAME){
            entity.doMove();
        }
    }

}
