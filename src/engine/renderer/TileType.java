package engine.renderer;

import java.awt.*;

public enum TileType {

    WALL("Wall", "W" , false, false, Color.DARK_GRAY),
    FLOOR("Floor", "F", true, true, Color.LIGHT_GRAY),
    DOOR("Door", "D", true, false, new Color(120, 75, 25)),
    CHEST("Chest", "C", true, false, new Color(255, 216, 102)),
    NULL("Null", "N", true, true, new Color(255, 0, 242));

    String name, icon;
    boolean walkable, npcWalkable;
    Color colour;

    TileType(String name, String icon, boolean walkable, boolean npcWalkable, Color colour){
        this.name = name;
        this.icon = icon;
        this.walkable = walkable;
        this.npcWalkable = npcWalkable;
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

    public boolean isNpcWalkable() {
        return npcWalkable;
    }

    @Override
    public String toString() {
        return getName();
    }
}
