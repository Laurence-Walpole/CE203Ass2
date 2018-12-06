package engine.entities;

import engine.Entity;
import engine.items.ItemClass;
import engine.items.ItemType;

public class Item extends Entity {

    private ItemType itemType;
    private ItemClass itemClass;
    private int itemWorth;
    private double itemModifier;
    private int[] extraStats;

    public Item(){super();}

    public Item(String name, ItemType itemType){
        super(name);
        this.itemType = itemType;
        this.itemClass = ItemClass.NORMAL;
    }

    public Item(String name, ItemType itemType, int itemWorth){
        super(name);
        this.itemType = itemType;
        this.itemWorth = itemWorth;
        this.itemClass = ItemClass.NORMAL;
    }

    public Item(String name, ItemType itemType, int itemWorth, double itemModifier){
        super(name);
        this.itemType = itemType;
        this.itemWorth = itemWorth;
        this.itemModifier = itemModifier;
        this.itemClass = ItemClass.NORMAL;
    }

    public Item(String name, ItemType itemType, int itemWorth, double itemModifier, int[] extraStats){
        super(name);
        this.itemType = itemType;
        this.itemWorth = itemWorth;
        this.itemModifier = itemModifier;
        this.extraStats = extraStats;
        this.itemClass = ItemClass.NORMAL;
    }

    public Item(String name, ItemType itemType, ItemClass itemClass){
        super(name);
        this.itemType = itemType;
        this.itemClass = itemClass;
    }

    public Item(String name, ItemType itemType, ItemClass itemClass, int itemWorth){
        super(name);
        this.itemType = itemType;
        this.itemClass = itemClass;
        this.itemWorth = itemWorth;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public ItemClass getItemClass() {
        return itemClass;
    }

    public int getItemWorth() {
        return itemWorth;
    }

    public void setItemWorth(int itemWorth) {
        this.itemWorth = itemWorth;
    }

    public double getItemModifier() {
        return itemModifier;
    }

    public int[] getExtraStats() {
        return extraStats;
    }

    public Item setItemClass(ItemClass itemClass) {
        this.itemClass = itemClass;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s, Item Type: %s, Item Worth: %d", getItemClass(), getName(), getItemType(), getItemWorth());
    }
}
