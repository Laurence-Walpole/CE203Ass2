package engine.utilities;

import engine.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

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

            case KeyEvent.VK_SPACE:
                if (Constants.PLAYER.isPlayerOnChest()){
                    Constants.PLAYER.getInventory().addItems(RNG.generatePopulatedContainer("Chest Loot", 3));
                }
                System.out.println(Constants.PLAYER.getInventory().getName() + " Inventory:");
                System.out.println(Constants.PLAYER.getInventory());
                break;
        }
    }
}
