package engine.utilities;

import engine.Constants;
import engine.Entity;
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
        File file = new File("C:\\Users\\isair\\IdeaProjects\\CE203Ass2\\entities.conf");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "";
            while((line = reader.readLine()) != null){
                if (line.startsWith("#")) continue;

                handleInput(line.split(","));

            }

        }catch(IOException e){
            System.err.println(e);
        }
    }

    private static void handleInput(String[] components){
        String type = components[0];
        String name = components[1];
        double attack = Integer.valueOf(components[2]);
        double defence = Integer.valueOf(components[3]);
        double hitpoints = Integer.valueOf(components[4]);
        double worth = Double.valueOf(components[5]);
        Entity e;

        switch(type){
            case "WEAPON":
                e = new Equipment(name, EquipmentType.WEAPON, attack, defence, hitpoints, worth);
        }
        Constants.ENTITY_LIST.add(e);
    }

    public static void loadMap(){

    }

}
