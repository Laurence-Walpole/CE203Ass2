package engine.entities;

import engine.Constants;
import engine.Entity;
import engine.Skills;
import engine.items.Container;
import engine.renderer.TileType;
import engine.utilities.Location;
import engine.utilities.Tile;

import java.awt.*;
import java.util.Map;

public class Player extends Entity {

    private Container inventory;
    private int[] xpInSkills = new int[] {0, 0, 1154};

    public Player(){
        super();
        this.inventory = new Container();
    }

    public Player(String name, Location location){
        super(name, location);
        setTag(name);
        setColour(Color.BLACK);
        this.inventory = new Container("Player");
    }

    public Tile isPlayerOnChest(){
        for(Tile tile : Constants.GAME_MAP.getTileList()){
            if (tile.getType() == TileType.CHEST){
                if (tile.getTileLocation().getX() == getLocation().getX() &&
                        tile.getTileLocation().getY() == getLocation().getY()){
                    return tile;
                }
            }
        }
        return null;
    }

    public Container getInventory() {
        return inventory;
    }

    public Map<Entity, Integer> getItems(){
        return getInventory().getContainer();
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

    public int calculateLevel(Skills skill){
        int currentXP = getXpInSkill(skill);
        return getLevelAtExperience(currentXP);
    }

    private int getExperienceAtLevel(int level){
        double total = 0;
        for (int i = 1; i < level; i++)
        {
            total += Math.floor(i + 300 * Math.pow(2, i / 7.0));
        }

        return (int) Math.floor(total / 4);
    }

    private int getLevelAtExperience(int experience) {
        int index;

        for (index = 0; index < 120; index++) {
            if (getExperienceAtLevel(index + 1) > experience)
                break;
        }

        return index;
    }
}
