package engine.entities;

import engine.Constants;
import engine.Entity;
import engine.Skills;
import engine.items.Container;
import engine.renderer.TileType;
import engine.utilities.Location;
import engine.utilities.Tile;

import java.awt.*;

public class Player extends Entity {

    private Container inventory;
    private int[] xpInSkills = new int[] {0, 0, 0};

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

    public boolean isPlayerOnChest(){
        for(Tile tile : Constants.GAME_MAP.getTileList()){
            if (tile.getType() == TileType.CHEST){
                if (tile.getTileLocation().getX() == getLocation().getX() &&
                        tile.getTileLocation().getY() == getLocation().getY()){
                    return true;
                }
            }
        }
        return false;
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
