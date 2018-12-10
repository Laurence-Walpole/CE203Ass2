package engine.utilities;

import engine.Constants;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Highscores {

    public static void saveHighscores(){
        Constants.PLAYER.setScore();
        String winMessage = "Congratulations, you have won! You finished with a score of: " + Constants.CURRENT_SCORE;
        String winTimeDate = (new SimpleDateFormat("yyyy-MM-dd|HH.mm.ss")).format(new Date());
        JOptionPane.showMessageDialog(null, winMessage);

        File file = new File("RPG_HS.save");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.newLine();
            writer.write(winTimeDate + ":" +Constants.CURRENT_SCORE);
            writer.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void loadHighscores(){
        File file = new File("RPG_HS.save");
        String line = "";
        String messageBox = "Current Highscores: \n";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                messageBox += line + "\n";
            }
            JOptionPane.showMessageDialog(null, messageBox);

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
