package engine;

import engine.entities.Item;
import engine.utilities.UUID;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<UUID> UUID_LIST = new ArrayList<>();
    public static List<Entity> ENTITY_LIST = new ArrayList<>();
    public static List<Item> ITEM_LIST = new ArrayList<>();

    public static Map GAME_MAP = new Map();
    public static int maxX = 0, maxY = 0;

    public static final int TILE_SIZE = 20;

}
