package engine.renderer;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.BLACK);
        //graphics2D.fillRect(5, 0, getWidth() - 5, getHeight());
    }

}
