package engine;

import engine.renderer.TileType;
import engine.utilities.Location;
import engine.utilities.Tile;

import javax.swing.*;
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
            default:
                tileType = TileType.NULL;
                break;

        }
        tileList.add(new Tile(location, tileType));
    }

    public void drawMap(GameWindow window){
        for (Tile t : tileList){
            JPanel p = new JPanel();
            p.setBackground(t.getType().getColour());
            p.setSize(t.getSquare().width, t.getSquare().height);
            p.setLocation(t.getTileLocation().getX(), t.getTileLocation().getY());
            window.add(p);
            System.out.println(t);
        }
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
}
