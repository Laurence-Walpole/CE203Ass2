package engine.utilities;

import java.util.ArrayList;
import java.util.List;

public class Log {
    public static List<String> gameLog = new ArrayList<>();

    public static List<String> getRecentFive(){
        if (gameLog.size() <= 5) return gameLog;
        return gameLog.subList(gameLog.size() - 5, gameLog.size());
    }
}
