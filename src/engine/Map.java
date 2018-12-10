package engine;

import engine.entities.NPC;
import engine.renderer.TileType;
import engine.utilities.Location;
import engine.utilities.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

    private List<Tile> tileList = new ArrayList<>();

    public void addTile(Location location, String icon){
        TileType tileType;

        switch(icon){
            case "W":
                tileType = TileType.WALL;
                break;
            case "F":
                tileType = TileType.FLOOR;
                break;
            case "D":
                tileType = TileType.DOOR;
                break;
            case "C":
                tileType = TileType.CHEST;
                break;
            case "I":
                tileType = TileType.FLOOR;
                break;
            default:
                tileType = TileType.FLOOR;
                Constants.ENTITIES_IN_GAME.add(new NPC(location, icon));
                break;
        }
        tileList.add(new Tile(location, tileType));
    }

    public boolean isTileAccessible(Location location){
        for(Tile tile : getTileList()){
            if (tile.getTileLocation().getX() == location.getX() && tile.getTileLocation().getY() == location.getY()){
                return tile.getType().isWalkable();
            }
        }
        return false;
    }

    public boolean isTileNPCAccessible(Location location){
        for(Tile tile : getTileList()){
            if (tile.getTileLocation().getX() == location.getX() && tile.getTileLocation().getY() == location.getY()){
                return tile.getType().isNpcWalkable();
            }
        }
        return false;
    }

    public static List<Entity> getEntityInRadius(Location location){
        List<Location> locations = Arrays.stream(Constants.MOVEMENT_OPTIONS)
                .map(c -> location.copyOf().addXandYandReturn(c)).collect(Collectors.toList());
        return Constants.ENTITIES_IN_GAME.stream()
                .filter(entity -> entity.getLocation().isLocationIn(locations)).collect(Collectors.toList());
    }

    public void removeTile(Tile tile){
       getTileList().remove(tile);
       addTile(tile.getTileLocation(), "F");
    }

    public List<Tile> getTileList() {
        return tileList;
    }
}
