package engine.shapes;

import engine.renderer.TileType;
import engine.utilities.Location;

import java.awt.*;

public abstract class Shape extends Rectangle {

    Shape(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    public abstract void drawTile(Graphics graphics, TileType type, Location location);

    @Override
    public String toString() {
        return "null";
    }
}
