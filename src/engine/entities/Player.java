package engine.entities;

import engine.Entity;
import engine.Skills;
import engine.items.Container;
import engine.utilities.Location;

public class Player extends Entity {

    private Container inventory;
    private int[] xpInSkills = new int[] {0, 0, 0};

    public Player(){
        super();
        this.inventory = new Container();
    }

    public Player(String name, Location location){
        super(name, location);
        this.inventory = new Container("player-inv");
    }

    public Container getInventory() {
        return inventory;
    }

    public int[] getXpInSkills() {
        return xpInSkills;
    }

    public int getXpInSkill(Skills skill){
        return getXpInSkills()[skill.getId()];
    }

    public void addXpInSkill(Skills skill, int xp){
        xpInSkills[skill.getId()] += xp;
    }
}
