package engine.utilities;

import engine.renderer.TileType;

public class Tile {

    private UUID uuid;
    private Location location;
    private TileType type;

    public Tile(Location location, String icon){
        uuid = new UUID();
        this.location = location;

        if (icon.equals(TileType.WALL.getIcon())){
            this.type = TileType.WALL;
        }else if(icon.equals(TileType.FLOOR.getIcon())){
            this.type = TileType.FLOOR;
        }else if(icon.equals(TileType.DOOR.getIcon())){
            this.type = TileType.DOOR;
        }else if(icon.equals(TileType.CHEST.getIcon())){
            this.type = TileType.CHEST;
        }else{
            this.type = null;
        }
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
