package engine.renderer;

import engine.Constants;
import engine.Entity;
import engine.Skills;
import engine.entities.Item;
import engine.items.ItemType;
import engine.utilities.InventoryButtonAction;
import engine.utilities.Location;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryPanel extends JPanel {

    public static List<InventoryButton> inventoryButtons = new ArrayList<>();

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(5, 0, getWidth() - 5, getHeight());

        graphics2D.setColor(Color.WHITE);
        Map<Entity, Integer> inv = Constants.PLAYER.getItems();
        graphics2D.drawString("Player Inventory:", 15, 15);
        graphics2D.drawString("Player Stats:", 300, 15);

        int y = 15;
        int maxDist = Constants.PLAYER.getInventory().findLongestString();

        for (Map.Entry item: inv.entrySet()) {
            graphics2D.setColor(((Item)item.getKey()).getItemClass().getColour());
            String invString = ((Item)item.getKey()).getInventoryText() + " x" + item.getValue();
            graphics2D.drawString(invString, 15, y += 15);

            InventoryButtonAction buttonAction;

            if (((Item)item.getKey()).getItemType() == ItemType.EQUIPMENT) buttonAction = InventoryButtonAction.EQUIP;
            else buttonAction = InventoryButtonAction.USE;

            InventoryButton btn1 = generateButton(buttonAction, new Location(maxDist, y), (Item)item.getKey());
            InventoryButton btn2 = generateButton(InventoryButtonAction.DROP, new Location(maxDist + 40, y), (Item)item.getKey());
            graphics2D.drawString(btn1.getButtonLabel(), maxDist, y);
            graphics2D.drawString(btn2.getButtonLabel(), maxDist + 40, y);
        }
        graphics2D.setColor(new Color(255, 193, 193));
        y = 15;
        for (int i = 0; i < Constants.PLAYER.getXpInSkills().length; i++){
            Skills skill = Skills.getSkill(i);
            String skillString = skill.getName() + ": " + Constants.PLAYER.calculateLevel(skill);
            graphics2D.drawString(skillString, 300, y += 15);
        }

    }

    private static InventoryButton generateButton(InventoryButtonAction type, Location location, Item item){
        InventoryButton button = new InventoryButton(type, location, item);
        inventoryButtons.add(button);
        return button;
    }

}
