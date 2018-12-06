package engine;

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

        }
        if (icon.equals(TileType.WALL.getIcon())){
            tileType = TileType.WALL;
        }else if(icon.equals(TileType.FLOOR.getIcon())){
            tileType = TileType.FLOOR;
        }else if(icon.equals(TileType.DOOR.getIcon())){
            tileType = TileType.DOOR;
        }else if(icon.equals(TileType.CHEST.getIcon())){
            tileType = TileType.CHEST;
        }else{
            tileType = null;
        }
        Tile t = new Tile(location, tileType);
    }


}
