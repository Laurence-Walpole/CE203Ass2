package engine;

import engine.shapes.Shape;
import engine.utilities.Location;
import engine.utilities.UUID;

import java.awt.*;

public class Entity {

    private UUID id;
    private String name;
    private Location location;
    private Shape shape;

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

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void updateLocation(int x, int y){
        this.location.setLocation(new Location(x, y));
    }

    public void drawEntity(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(Color.CYAN);
        graphics2D.setBackground(Color.CYAN);
        int offsetX = (location.getX() * Constants.TILE_SIZE) + 5;
        int offsetY = (location.getY() * Constants.TILE_SIZE) + 5;

        graphics2D.fillOval(offsetX, offsetY, Constants.TILE_SIZE, Constants.TILE_SIZE);
    }

    @Override
    public String toString() {
        return String.format("UUID: %s, Name: %s, Location: %s, Shape: %s", getId().getUuid(), getName(), getLocation(), getShape());
    }
}
