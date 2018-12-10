package engine.items;

import java.awt.*;

public enum ItemClass {

    NORMAL(0.525, "Normal", new Color(120, 220, 232), 0),
    MEDIUM(0.35, "Medium", new Color(255, 216, 102), 2),
    RARE(0.1, "Rare", new Color(255, 97, 136), 3),
    VERY_RARE(0.025, "Very Rare", new Color(171, 157, 242), 4);

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
