package engine.shapes;

import engine.Constants;
import engine.renderer.TileType;
import engine.utilities.Location;

import java.awt.*;

public class Square extends Shape {

    public Square(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    public void drawTile(Graphics graphics, TileType type, Location location) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(type.getColour());
        graphics2D.setBackground(type.getColour());
        int offsetX = (location.getX() * Constants.TILE_SIZE) + 5;
        int offsetY = (location.getY() * Constants.TILE_SIZE) + 5;

        graphics2D.fillRect(offsetX, offsetY, Constants.TILE_SIZE, Constants.TILE_SIZE);
    }

}
