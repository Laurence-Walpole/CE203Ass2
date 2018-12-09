package engine.utilities;

import engine.Constants;
import engine.renderer.TileType;
import engine.shapes.Square;

import java.awt.*;

public class Tile{

    private UUID uuid;
    private Location location;
    private TileType type;
    private Square square;

    public Tile(Location location, TileType type){
        uuid = new UUID();
        this.location = location;
        this.type = type;
        this.square = new Square(Constants.TILE_SIZE, Constants.TILE_SIZE, location.getX(), location.getY());
    }

    public void drawTile(Graphics g){
        square.drawTile(g, type, location);
    }

    public UUID getId() {
        return uuid;
    }

    public Location getTileLocation() {
        return location;
    }

    public TileType getType() {
        return type;
    }

    public Square getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return location.toString();
    }
}
