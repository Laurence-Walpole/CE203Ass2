package engine.entities;

import engine.items.EquipmentType;
import engine.items.ItemType;

public class Equipment extends Item {

    private EquipmentType equipmentType;
    private double attackBonus, defenceBonus, hitpointsBonus;

    public Equipment(){
        super();
    }

    public Equipment(String name, EquipmentType equipmentType){
        super(name, ItemType.EQUIPMENT);
        this.equipmentType = equipmentType;
    }

    public Equipment(String name, EquipmentType equipmentType, double attackBonus, double defenceBonus, double hitpointsBonus, double itemWorth){
        super(name, ItemType.EQUIPMENT);
        this.equipmentType = equipmentType;
        this.attackBonus = attackBonus;
        this.defenceBonus = defenceBonus;
        this.hitpointsBonus = hitpointsBonus;
        setItemWorth(itemWorth);
    }
}
