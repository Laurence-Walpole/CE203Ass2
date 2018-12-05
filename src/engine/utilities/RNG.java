package engine.utilities;

import engine.entities.Item;
import engine.items.ItemClass;

import java.util.Random;

public class RNG {

    public static Item generateItemRarity(Item item){
        return item.setItemClass(getRandomItemClass());
    }

    public static ItemClass getRandomItemClass(){
        Random r = new Random();
        double roll = r.nextDouble();

        if (roll > ItemClass.NORMAL.getRarity()){
            return ItemClass.NORMAL;
        }else if(roll > ItemClass.MEDIUM.getRarity() && roll < ItemClass.NORMAL.getRarity()){
            return ItemClass.MEDIUM;
        }else if(roll > ItemClass.RARE.getRarity() && roll < ItemClass.MEDIUM.getRarity()){
            return ItemClass.RARE;
        }else{
            return ItemClass.VERY_RARE;
        }
    }
}
