package engine.items;

import java.awt.*;

public enum ItemClass {

    NORMAL(0.525, "Normal", new Color(153, 204, 255), 0),
    MEDIUM(0.35, "Medium", new Color(51, 51, 255), 2),
    RARE(0.1, "Rare", new Color(204, 0, 0), 3),
    VERY_RARE(0.025, "Very Rare", new Color(204, 0, 255), 4);

    double rarity;
    String name;
    Color colour;
    int multiplier;

    ItemClass(double rarity, String name, Color colour, int multiplier){
        this.rarity = rarity;
        this.name = name;
        this.colour = colour;
        this.multiplier = multiplier;
    }

    public double getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public Color getColour() {
        return colour;
    }

    public int getMultiplier() {
        return multiplier;
    }

    @Override
    public String toString() {
        return getName();
    }
}
