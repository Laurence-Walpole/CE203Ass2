package engine.utilities;

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

        switch(type){
            case "WEAPON":

        }
    }

    public static void loadMap(){

    }

}
