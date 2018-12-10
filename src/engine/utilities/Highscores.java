package engine.utilities;

import engine.Constants;

import javax.swing.*;

public class Highscores {

    public static void saveHighscores(){
        String winMessage = "Congratulations, you have won! You finished with a score of: " + Constants.CURRENT_SCORE;
        JOptionPane.showMessageDialog(null, winMessage);
    }

    public static void loadHighscores(){

    }

}
