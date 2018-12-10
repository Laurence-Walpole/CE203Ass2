package engine.entities;

import engine.Constants;
import engine.Entity;
import engine.Skills;
import engine.items.Container;
import engine.items.EquipmentType;
import engine.items.ItemType;
import engine.renderer.InventoryButton;
import engine.renderer.InventoryPanel;
import engine.renderer.TileType;
import engine.utilities.InventoryButtonAction;
import engine.utilities.Location;
import engine.utilities.Log;
import engine.utilities.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player extends Entity {

    private Container inventory;
    private List<Equipment> equipmentList = new ArrayList<>();
    private int[] xpInSkills = new int[] {1154, 1154, 1154};
    private final int[] xpReset = xpInSkills;

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
        return getLevelAtExperience(getXpInSkill(skill));
    }

    public void useItem(Item itemToUse, InventoryButtonAction buttonAction, InventoryButton button){
        if (buttonAction == InventoryButtonAction.DROP){
            if (getInventory().removeItem(itemToUse)){
                InventoryPanel.inventoryButtons.remove(button);
            }
        } else if (buttonAction == InventoryButtonAction.USE){
            if (itemToUse.getItemType() == ItemType.CONSUMABLE){
                int attackXP = calculateXpToGain(itemToUse, 0);
                int defenceXP = calculateXpToGain(itemToUse, 1);
                int hpXP = addHPXP(itemToUse);

                addXpInSkill(Skills.ATTACK, attackXP);
                addXpInSkill(Skills.DEFENCE, defenceXP);
                addXpInSkill(Skills.HITPOINTS, hpXP);
                if (getInventory().removeItem(itemToUse)){
                    InventoryPanel.inventoryButtons.remove(button);
                }
            }
        } else if(buttonAction == InventoryButtonAction.EQUIP){
            if (!isItemTypeInEquipment((Equipment)itemToUse)) {
                equipItem(itemToUse, button);
            }else{
                Equipment equipmentToRemove = getEquipmentOfType(((Equipment) itemToUse).getEquipmentType());
                Log.gameLog.add("You removed your old " + equipmentToRemove.getName());
                removeXPInSkill(Skills.ATTACK, getExperienceAtLevel(equipmentToRemove.getAttackBonus()));
                removeXPInSkill(Skills.DEFENCE, getExperienceAtLevel(equipmentToRemove.getDefenceBonus()));
                removeXPInSkill(Skills.HITPOINTS, getExperienceAtLevel(equipmentToRemove.getHitpointsBonus()));
                getInventory().addItem(equipmentToRemove, 1);
                equipmentList.remove(equipmentToRemove);
                equipItem(itemToUse, button);
            }
        }
        Constants.inventoryPanel.repaint();
    }

    private void equipItem(Item itemToUse, InventoryButton button){
        Log.gameLog.add("You equiped the " + itemToUse.getName());
        addXpInSkill(Skills.ATTACK, getExperienceAtLevel(((Equipment) itemToUse).getAttackBonus()));
        addXpInSkill(Skills.DEFENCE, getExperienceAtLevel(((Equipment) itemToUse).getDefenceBonus()));
        addXpInSkill(Skills.HITPOINTS, getExperienceAtLevel(((Equipment) itemToUse).getHitpointsBonus()));
        equipmentList.add((Equipment) itemToUse);
        if (getInventory().removeItem(itemToUse)) {
            InventoryPanel.inventoryButtons.remove(button);
        }
    }

    private int getExperienceAtLevel(int level){
        return (int)Math.floor(IntStream.range(1, level).mapToDouble(i -> Math.floor(i + 300 * Math.pow(2, i / 7.0))).sum() / 4);
    }

    private boolean isItemTypeInEquipment(Equipment item){
        return equipmentList.stream().anyMatch(i -> i.getEquipmentType() == item.getEquipmentType());
    }

    private int getLevelAtExperience(int experience) {
        return (IntStream.rangeClosed(0, 99).filter(i -> getExperienceAtLevel(i + 1) > experience).findFirst()).orElse(0);
    }

    private Equipment getEquipmentOfType(EquipmentType type){
        return equipmentList.stream().filter(e -> e.getEquipmentType() == type).findFirst().get();
    }

    private int calculateXpToGain(Item itemToUse, int statToGain){
        return itemToUse.getExtraStats()[statToGain] * itemToUse.getItemClass().getMultiplier() * 100;
    }

    private int addHPXP(Item itemToUse){
        return (int)itemToUse.getItemModifier() * itemToUse.getItemClass().getMultiplier() * 50;
    }

    public void setScore(){
        int score = Arrays.stream(xpInSkills).sum();
        score += getInventory().getWorth();
        Constants.CURRENT_SCORE = score;
        System.out.println(score);
    }

    public void respawn(){
        setScore();
        setLocation(new Location (1, 1));
        getInventory().getContainer().clear();
        xpInSkills = xpReset;
    }

    public void removePlayerHPXP(int newHP){
        xpInSkills[2] = getExperienceAtLevel(newHP);
    }

    public void removeXPInSkill(Skills skill, int xp){
        xpInSkills[skill.getId()] -= xp;
    }
}
