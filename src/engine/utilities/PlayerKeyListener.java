package engine.utilities;

import engine.Constants;
import engine.Entity;
import engine.Map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class PlayerKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) {
        Location l;
        int newY, newX;
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                newY = Constants.PLAYER.getLocation().getY() - 1;
                l = new Location(Constants.PLAYER.getLocation().getX(), newY);
                if (Constants.GAME_MAP.isTileAccessible(l)) Constants.PLAYER.setLocation(l);
                break;

            case KeyEvent.VK_S:
                newY = Constants.PLAYER.getLocation().getY() + 1;
                l = new Location(Constants.PLAYER.getLocation().getX(), newY);
                if (Constants.GAME_MAP.isTileAccessible(l)) Constants.PLAYER.setLocation(l);
                break;

            case KeyEvent.VK_D:
                newX = Constants.PLAYER.getLocation().getX() + 1;
                l = new Location(newX, Constants.PLAYER.getLocation().getY());
                if (Constants.GAME_MAP.isTileAccessible(l)) Constants.PLAYER.setLocation(l);
                break;

            case KeyEvent.VK_A:
                newX = Constants.PLAYER.getLocation().getX() - 1;
                l = new Location(newX, Constants.PLAYER.getLocation().getY());
                if (Constants.GAME_MAP.isTileAccessible(l)) Constants.PLAYER.setLocation(l);
                break;

            case KeyEvent.VK_E:
                Tile tile = Constants.PLAYER.isPlayerOnChest();
                if (tile != null){
                    if (Constants.PLAYER.getItems().size() < 10) {
                        Constants.PLAYER.getInventory().addItems(RNG.generatePopulatedContainer("Chest Loot", 2));
                        Constants.GAME_MAP.removeTile(tile);
                    }
                }
                Constants.inventoryPanel.repaint();
                break;

            case KeyEvent.VK_SPACE:
                List<Entity> entities = Map.getEntityInRadius(Constants.PLAYER.getLocation());
                for(Entity entity : entities){
                    Combat.performAttack(entity);
                }
                break;
        }
    }
}
