package engine.utilities;

import engine.Constants;
import engine.Entity;
import engine.Skills;
import engine.entities.NPC;

public class Combat {

    public static void performAttack(Entity entity){
        int[] hits = RNG.damageDealt(entity);
        int newPlayerHP = Constants.PLAYER.calculateLevel(Skills.HITPOINTS) - hits[1];
        if (newPlayerHP <= 0){
            Log.gameLog.add("Oh dear you're dead...");
            Constants.PLAYER.respawn();
            return;
        }
        Log.gameLog.add(String.format("Player was hit for %d", hits[1]));
        Log.gameLog.add(String.format("Entity was hit for %d", hits[0]));
        int newEntityHP = ((NPC)entity).getHitpoints() - hits[0];
        if (newEntityHP <= 0){
            Log.gameLog.add("You killed the monster!");
            entity.killEntity();
            Constants.PLAYER.getInventory().addItems(RNG.generatePopulatedContainer("NPC Loot", 1));
        }

        Constants.PLAYER.removePlayerHPXP(newPlayerHP);
        ((NPC)entity).removeHitpoints(newEntityHP);
        Constants.inventoryPanel.repaint();
    }

}
