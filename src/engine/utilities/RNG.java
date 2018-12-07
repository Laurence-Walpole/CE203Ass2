package engine.utilities;

import engine.Constants;
import engine.Entity;
import engine.entities.Item;
import engine.items.Container;
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

    public static Container generatePopulatedContainer(String containerName, int itemCount){
        Container container = new Container(containerName);
        for (int i = 0; i < itemCount; i++){
            Item item = getRandomItem();
            System.out.println(item);
            container.addItem(item, randomNumberBetween(1,3));
        }
        return container;
    }

    public static Item getRandomItem(){
        Item e = Constants.ITEM_LIST.get(randomNumberBetween(0, Constants.ITEM_LIST.size()));
        return generateItemRarity(e);
    }

    public static int randomNumberBetween(int low, int high){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }
}
