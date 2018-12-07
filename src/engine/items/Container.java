package engine.items;

import engine.Constants;
import engine.Entity;
import engine.entities.Item;
import engine.utilities.UUID;

import java.util.HashMap;
import java.util.Map;

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
        Constants.CONTAINERS.add(this);
    }

    public Container(String name, HashMap<Entity, Integer> inventory){
        this.id = new UUID();
        this.name = name;
        this.inventory = inventory;
        Constants.CONTAINERS.add(this);
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
        for(Map.Entry<Entity, Integer> invItem : getInventory().entrySet()){
            if (invItem.getKey().getName().equals(item.getName())){
                if (((Item)invItem.getKey()).getItemClass() == ((Item)item).getItemClass()){
                    invItem.setValue(invItem.getValue() + amount);
                    return;
                }
            }
        }
        getInventory().put(item, amount);
    }

    public void addItems(Container container){
        for(Map.Entry<Entity, Integer> item: container.getInventory().entrySet()){
            getInventory().put(item.getKey(), item.getValue());
        }
    }

    public void removeItem(Entity item){
        getInventory().remove(item);
    }

    public void drawContainer(){

    }

    @Override
    public String toString() {
        String inventory = "";
        for(Map.Entry<Entity, Integer> item: getInventory().entrySet()){
            inventory += String.format("Item: %s %s, Amount: %d \n", ((Item)item.getKey()).getItemClass(), item.getKey().getName(), item.getValue());
        }
        return inventory;
    }
}
