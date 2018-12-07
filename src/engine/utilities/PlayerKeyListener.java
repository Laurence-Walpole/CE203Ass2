package engine.utilities;

import engine.Constants;

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
        int newY, newX;
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                newY = Constants.PLAYER.getLocation().getY() - 1;
                Constants.PLAYER.setLocation(new Location(Constants.PLAYER.getLocation().getX(), newY));
                break;

            case KeyEvent.VK_S:
                newY = Constants.PLAYER.getLocation().getY() + 1;
                Constants.PLAYER.setLocation(new Location(Constants.PLAYER.getLocation().getX(), newY));
                break;

            case KeyEvent.VK_D:
                newX = Constants.PLAYER.getLocation().getX() + 1;
                Constants.PLAYER.setLocation(new Location(newX, Constants.PLAYER.getLocation().getY()));
                break;

            case KeyEvent.VK_A:
                newX = Constants.PLAYER.getLocation().getX() - 1;
                Constants.PLAYER.setLocation(new Location(newX, Constants.PLAYER.getLocation().getY()));
                break;
        }
    }
}
