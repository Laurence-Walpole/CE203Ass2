package engine;

import engine.entities.Item;
import engine.items.Container;
import engine.utilities.UUID;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<UUID> UUID_LIST = new ArrayList<>();
    public static List<Entity> ENTITY_LIST = new ArrayList<>();
    public static List<Entity> ENTITIES_IN_GAME = new ArrayList<>();
    public static List<Item> ITEM_LIST = new ArrayList<>();
    public static List<Container> CONTAINERS = new ArrayList<>();

    public static Map GAME_MAP = new Map();
    public static int maxX = 0, maxY = 0;

    public static final int TILE_SIZE = 40;

    public static final int WINDOW_SIZE = (TILE_SIZE * 20) + 5;

    public static final int[][] MOVEMENT_OPTIONS = new int[][] {
            {0, 1}, {1, 0},
            {0, -1}, {-1, 0}
    };

    public static boolean GAME_RUNNING = false;

}
