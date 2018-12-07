package engine;

import engine.entities.NPC;
import engine.entities.NPCType;
import engine.renderer.TileType;
import engine.utilities.Location;
import engine.utilities.Tile;

import java.util.ArrayList;
import java.util.List;

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

    public void dumpMap() {
        for(Tile tile : tileList){
            System.out.print(tile.getType().getIcon());
            if (tile.getTileLocation().getX() == Constants.maxX-1){
                System.out.println();
            }
        }
        System.out.println(Constants.maxX);
        System.out.println(Constants.maxY);
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

    public List<Tile> getTileList() {
        return tileList;
    }
}
