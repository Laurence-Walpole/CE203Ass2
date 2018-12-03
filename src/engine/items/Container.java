package engine.items;

import engine.Entity;
import engine.utilities.UUID;

import java.util.HashMap;

public class Container {

    private UUID id;
    private String name;
    private HashMap<Entity, Integer> inventory = new HashMap<>();

    public Container(){
        this.id = new UUID();
    }

    public Container(String name){
        this.id = new UUID();
        this.name = name;
    }

    public Container(String name, HashMap<Entity, Integer> inventory){
        this.id = new UUID();
        this.name = name;
        this.inventory = inventory;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<Entity, Integer> getInventory() {
        return inventory;
    }

    public void addItem(Entity item, int amount){
        getInventory().put(item, amount);
    }

    public void removeItem(Entity item){
        getInventory().remove(item);
    }
}
