package engine.entities;

import engine.items.EquipmentType;
import engine.items.ItemType;

public class Equipment extends Item {

    private EquipmentType equipmentType;
    private int attackBonus, defenceBonus, hitpointsBonus;

    public Equipment(){
        super();
    }

    public Equipment(String name, EquipmentType equipmentType){
        super(name, ItemType.EQUIPMENT);
        this.equipmentType = equipmentType;
    }

    public Equipment(String name, EquipmentType equipmentType, int attackBonus, int defenceBonus, int hitpointsBonus, int itemWorth){
        super(name, ItemType.EQUIPMENT);
        this.equipmentType = equipmentType;
        this.attackBonus = attackBonus;
        this.defenceBonus = defenceBonus;
        this.hitpointsBonus = hitpointsBonus;
        setItemWorth(itemWorth);
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public int getAttackBonus() {
        return attackBonus * getItemClass().getMultiplier();
    }

    public int getDefenceBonus() {
        return defenceBonus * getItemClass().getMultiplier();
    }

    public int getHitpointsBonus() {
        return hitpointsBonus * getItemClass().getMultiplier();
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s, Item Type: %s, Item Worth: %d, Equipment Type: %s, Bonuses: A:%d | D:%d | H:%d",
                getItemClass(), getName(), getItemType(), getItemWorth(), getEquipmentType(), getAttackBonus(), getDefenceBonus(), getHitpointsBonus());
    }
}
