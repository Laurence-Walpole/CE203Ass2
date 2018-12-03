package engine.entities;

import engine.Entity;
import engine.items.ItemClass;
import engine.items.ItemType;

public class Item extends Entity {

    private ItemType itemType;
    private ItemClass itemClass;
    private double itemWorth;

    public Item(){super();}

    public Item(String name, ItemType itemType){
        super(name);
        this.itemType = itemType;
    }

    public Item(String name, ItemType itemType, ItemClass itemClass){
        super(name);
        this.itemType = itemType;
        this.itemClass = itemClass;
    }

    public Item(String name, ItemType itemType, ItemClass itemClass, double itemWorth){
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

    public double getItemWorth() {
        return itemWorth;
    }

    public void setItemWorth(double itemWorth) {
        this.itemWorth = itemWorth;
    }
}
