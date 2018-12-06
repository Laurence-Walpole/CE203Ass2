package engine.renderer;

import java.awt.*;

public enum TileType {

    WALL("Wall", "W" , false, Color.DARK_GRAY),
    FLOOR("Floor", "F", true, Color.LIGHT_GRAY),
    DOOR("Door", "D", true, new Color(86, 59, 24)),
    CHEST("Chest", "C", true, Color.ORANGE),
    NULL("Null", "N", true, new Color(255, 0, 242));

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
