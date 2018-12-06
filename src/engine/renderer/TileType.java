package engine.renderer;

import java.awt.*;

public enum TileType {

    WALL("Wall", "W" , false, Color.DARK_GRAY),
    FLOOR("Floor", "F", true, Color.LIGHT_GRAY),
    DOOR("Door", "D", true, Color.getHSBColor(28, 90, 23)),
    CHEST("Chest", "C", true, Color.ORANGE),
    NULL("Null", "N", true, Color.pink);

    String name, icon;
    boolean walkable;
    Color colour;

    TileType(String name, String icon, boolean walkable, Color colour){
        this.name = name;
        this.icon = icon;
        this.walkable = walkable;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Color getColour() {
        return colour;
    }

    public boolean isWalkable() {
        return walkable;
    }

    @Override
    public String toString() {
        return getName();
    }
}
