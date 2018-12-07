package engine.entities;

import engine.Constants;
import engine.Entity;
import engine.utilities.Location;

public class NPC extends Entity {

    private NPCType type;
    private String tag;
    private int attack = 0, defence = 0, hitpoints = 0, dropTable = -1;

    public NPC(){
        super();
    }

    public NPC(String type, String tag, int dropTable){
        super();
        this.type = NPCType.getType(type);
        this.tag = tag;
        this.dropTable = dropTable;
    }

    public NPC(String name, Location location, String type, String tag, int dropTable){
        super(name, location);
        this.type = NPCType.getType(type);
        this.tag = tag;
        this.dropTable = dropTable;
    }

    public NPC(String name, Location location, String type, String tag, int dropTable, int attack, int defence, int hitpoints){
        super(name, location);
        this.type = NPCType.getType(type);
        this.tag = tag;
        this.dropTable = dropTable;
        this.attack = attack;
        this.defence = defence;
        this.hitpoints = hitpoints;
    }

    public NPCType getType() {
        return type;
    }

    public String getTag() {
        return tag;
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

    public static boolean isTagInNPCList(String tag){
        for (Entity entity : Constants.ENTITY_LIST){
            if (entity.getClass() == NPC.class) return ((NPC)entity).tag.equals(tag);
        }
        return false;
    }
}
