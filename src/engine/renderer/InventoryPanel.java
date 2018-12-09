package engine.renderer;

import engine.Constants;
import engine.Entity;
import engine.entities.Item;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class InventoryPanel extends JPanel {

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(5, 0, getWidth() - 5, getHeight());

        graphics2D.setColor(Color.WHITE);
        Map<Entity, Integer> inv = Constants.PLAYER.getItems();
        graphics2D.drawString("Player Inventory:", 15, 15);

        int y = 15;

        for (Map.Entry item: inv.entrySet()) {
            graphics2D.setColor(((Item)item.getKey()).getItemClass().getColour());
            String invString = ((Item)item.getKey()).getInventoryText() + " x" + item.getValue();
            graphics2D.drawString(invString, 15, y += 15);
        }
    }

}
