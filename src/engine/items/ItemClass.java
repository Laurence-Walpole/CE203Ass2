package engine.items;

import javafx.scene.paint.Color;

public enum ItemClass {

    NORMAL(0.525, "Normal", Color.LIGHTBLUE, 0),
    MEDIUM(0.35, "Medium", Color.DARKBLUE, 2),
    RARE(0.1, "Rare", Color.DARKRED, 3),
    VERY_RARE(0.025, "Very Rare", Color.MEDIUMPURPLE, 4);

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
