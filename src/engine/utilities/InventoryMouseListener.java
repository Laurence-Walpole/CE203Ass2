package engine.utilities;

import engine.Constants;
import engine.renderer.InventoryButton;
import engine.renderer.InventoryPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int xOffset = 4;
        int yOffset = 522;
        for (InventoryButton button : InventoryPanel.inventoryButtons){

            int btnTopX = button.getButtonLocation().getX() + xOffset;
            int btnTopY = button.getButtonLocation().getY() + yOffset;
            int btnBottomX = btnTopX + (button.getButtonLabel().length() * 6);
            int btnBottomY = btnTopY + 15;

            if (e.getX() >= btnTopX &&
                e.getY() >= btnTopY &&
                e.getX() <=  btnBottomX &&
                e.getY() <= btnBottomY){
                Constants.PLAYER.useItem(button.getRelatedItem(), button.getButtonAction());
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
