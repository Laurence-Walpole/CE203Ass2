package engine;

import engine.utilities.Location;
import engine.utilities.UUID;

public class Entity {

    private UUID id;
    private String name;
    private Location location;

    public Entity(){
        this.id = new UUID();
    }

    public Entity(String name){
        this.id = new UUID();
        this.name = name;
    }

    public Entity(String name, Location location){
        this.id = new UUID();
        this.name = name;
        this.location = location;
    }

    public Entity(String name, int x, int y){
        this.id = new UUID();
        this.name = name;
        this.location = new Location(x, y);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void updateLocation(int x, int y){
        this.location.setLocation(new Location(x, y));
    }
}
