package engine.utilities;

import engine.renderer.TileType;
import engine.shapes.Square;

public class Tile extends Square {

    private UUID uuid;
    private Location location;
    private TileType type;

    public Tile(Location location, TileType type){
        uuid = new UUID();
        this.location = location;
        this.type = type;
    }

    public UUID getId() {
        return uuid;
    }

    public Location getLocation() {
        return location;
    }

    public TileType getType() {
        return type;
    }
}
