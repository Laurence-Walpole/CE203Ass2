package engine.entities;

import engine.Constants;
import engine.Entity;
import engine.utilities.Location;

import java.awt.*;

public class NPC extends Entity {

    private NPCType type;
    private int attack = 0, defence = 0, hitpoints = 0, dropTable = -1;

    public NPC(){
        super();
    }

    public NPC(Location location, String tag){
        super();
        this.setLocation(location);
        this.setTag(tag);
        NPC n = isTagInNPCList(tag);
        if (n != null){
            this.type = n.type;
            this.attack = n.attack;
            this.defence = n.defence;
            this.hitpoints = n.hitpoints;
            this.dropTable = n.dropTable;
            this.setColour(n.getColour());
        }
    }

    public NPC(String type, String tag, int dropTable){
        super();
        this.type = NPCType.getType(type);
        this.setTag(tag);
        this.dropTable = dropTable;
    }

    public NPC(String name, Location location, String type, String tag, int dropTable){
        super(name, location);
        this.type = NPCType.getType(type);
        this.setTag(tag);
        this.dropTable = dropTable;
    }

    public NPC(String name, Location location, String type, String tag, int dropTable, int attack, int defence, int hitpoints){
        super(name, location);
        this.type = NPCType.getType(type);
        this.setTag(tag);
        this.dropTable = dropTable;
        this.attack = attack;
        this.defence = defence;
        this.hitpoints = hitpoints;
    }

    public NPCType getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int getDropTable() {
        return dropTable;
    }

    public void removeHitpoints(int amount){
        this.hitpoints -= amount;
    }


    public static NPC isTagInNPCList(String tag){
        for (Entity entity : Constants.ENTITY_LIST){
            if (entity.getClass() == NPC.class && (entity).getTag().equals(tag)){
                return (NPC)entity;
            }
        }
        return null;
    }
}
