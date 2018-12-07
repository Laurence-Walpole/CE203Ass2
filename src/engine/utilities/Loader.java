package engine.utilities;

import engine.Constants;
import engine.Entity;
import engine.entities.Equipment;
import engine.entities.Item;
import engine.entities.NPC;
import engine.items.EquipmentType;
import engine.items.ItemType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loader {

    public static void loadEntities(){
        File file = new File("entities.conf");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "";
            while((line = reader.readLine()) != null){
                if (!line.startsWith("#")) handleInput(line.split(","));
            }
            reader.close();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public static void loadMap(){
        File file = new File("Map.csv");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            int currentRow = 0;
            while((line = reader.readLine()) != null){
                doMapLine(line.split(","), currentRow++);
            }
            Constants.maxY = currentRow;
            reader.close();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private static void doMapLine(String[] tiles, int currentRow){
        int currentColumn = 0;
        for(String tile : tiles){
            Location l = new Location(currentColumn++, currentRow);
            Constants.GAME_MAP.addTile(l, tile);
        }
        Constants.maxX = currentColumn;
    }

    private static void handleInput(String[] components){
        String type = components[0];

        Entity entity;

        if (type.equals("NPC")){
            //#TYPE,TAG,NAME,SHOP_TABLE
            String tag = components[1];
            String name = components[2];
            int shopID = Integer.valueOf(components[3]);
            entity = new NPC(name, new Location(5,5), type, tag, shopID);

        }else if(type.equals("CNPC")){
            //#TYPE,TAG,NAME,ATK,DEF,HP,DROP_TABLE
            String tag = components[1];
            String name = components[2];
            int a = Integer.valueOf(components[3]);
            int d = Integer.valueOf(components[4]);
            int h = Integer.valueOf(components[5]);
            int dr = Integer.valueOf(components[6]);
            entity = new NPC(name, new Location(0,0), type, tag, a, d, h, dr);
        }else {
            String name = components[1];
            int attack = Integer.valueOf(components[2]);
            int defence = Integer.valueOf(components[3]);
            int hitpoints = Integer.valueOf(components[4]);
            int worth = Integer.valueOf(components[5]);
            entity = new Item();

            switch (type) {
                case "WEAPON":
                    entity = new Equipment(name, EquipmentType.WEAPON, attack, defence, hitpoints, worth);
                    break;
                case "SHIELD":
                    entity = new Equipment(name, EquipmentType.SHIELD, attack, defence, hitpoints, worth);
                    break;
                case "ARMOUR":
                    entity = new Equipment(name, EquipmentType.ARMOUR, attack, defence, hitpoints, worth);
                    break;
                case "RING":
                    entity = new Equipment(name, EquipmentType.RING, attack, defence, hitpoints, worth);
                    break;
                case "CONSUMABLE":
                    entity = new Item(name, ItemType.CONSUMABLE, worth, hitpoints, new int[]{attack, defence});
                    break;
                case "UTILITY":
                    entity = new Item(name, ItemType.UTILITY, worth);
                    break;
            }
        }
        if (entity.getClass() == Item.class || entity.getClass() == Equipment.class) Constants.ITEM_LIST.add((Item)entity);
        else Constants.ENTITY_LIST.add(entity);
    }

}
