package engine.utilities;

import engine.Constants;
import engine.entities.Equipment;
import engine.entities.Item;
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
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
        Constants.GAME_MAP.dumpMap();
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

        if (type.equals("NPC") || type.equals("CNPC")){
            return;
        }
        String name = components[1];
        int attack = Integer.valueOf(components[2]);
        int defence = Integer.valueOf(components[3]);
        int hitpoints = Integer.valueOf(components[4]);
        int worth = Integer.valueOf(components[5]);
        Item e = new Item();

        switch(type){
            case "WEAPON":
                e = new Equipment(name, EquipmentType.WEAPON, attack, defence, hitpoints, worth);
                break;
            case "SHIELD":
                e = new Equipment(name, EquipmentType.SHIELD, attack, defence, hitpoints, worth);
                break;
            case "ARMOUR":
                e = new Equipment(name, EquipmentType.ARMOUR, attack, defence, hitpoints, worth);
                break;
            case "RING":
                e = new Equipment(name, EquipmentType.RING, attack, defence, hitpoints, worth);
                break;
            case "CONSUMABLE":
                e = new Item(name, ItemType.CONSUMABLE, worth, hitpoints, new int[] {attack, defence});
                break;
            case "UTILITY":
                e = new Item(name, ItemType.UTILITY, worth);
                break;
        }
        if (e.getClass() == Item.class || e.getClass() == Equipment.class) Constants.ITEM_LIST.add(e);
        else Constants.ENTITY_LIST.add(e);
    }

}
