package engine.renderer;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {

    public void paintComponent(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.BLACK);
        graphics.drawString("HELLO YOU CRAZY NOOOTER", 0, 0);
    }

}
