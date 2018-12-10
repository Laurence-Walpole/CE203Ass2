package engine.utilities;

import engine.Constants;
import engine.Entity;
import engine.Skills;
import engine.entities.Item;
import engine.entities.NPC;
import engine.items.Container;
import engine.items.ItemClass;

import java.util.Random;

public class RNG {

    public static Item generateItemRarity(Item item){
        return item.setItemClass(getRandomItemClass());
    }

    public static int[] damageDealt(Entity entity){
        double playerAttack = Constants.PLAYER.calculateLevel(Skills.ATTACK);
        double playerDefence = Constants.PLAYER.calculateLevel(Skills.DEFENCE);

        double entityAttack = ((NPC) entity).getAttack();
        double entityDefence = ((NPC) entity).getDefence();

        Double playerMaxHit = Math.floor((playerAttack / entityDefence) * 10);
        Double entityMaxHit = Math.floor((entityAttack / playerDefence) * 10);

        return new int[] {randomNumberBetween(0,playerMaxHit.intValue()), randomNumberBetween(0, entityMaxHit.intValue())};
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
            int maxAmount;
            if (item.getItemClass() == ItemClass.NORMAL) maxAmount = 3;
            else if (item.getItemClass() == ItemClass.MEDIUM) maxAmount = 2;
            else maxAmount = 2;
            container.addItem(item, randomNumberBetween(1,maxAmount));
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
