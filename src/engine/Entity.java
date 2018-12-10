package engine;

import engine.entities.NPC;
import engine.shapes.Shape;
import engine.utilities.Location;
import engine.utilities.RNG;
import engine.utilities.UUID;

import java.awt.*;

public class Entity {

    private UUID id;
    private String name;
    private String tag;
    private Location location;
    private Shape shape;
    private Color colour;

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

    public Color getColour(){
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void drawEntity(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(getColour());
        graphics2D.setBackground(getColour());
        int offsetX = (location.getX() * Constants.TILE_SIZE) + 5;
        int offsetY = (location.getY() * Constants.TILE_SIZE) + 5;

        graphics2D.fillOval(offsetX, offsetY, Constants.TILE_SIZE, Constants.TILE_SIZE);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(tag, offsetX + (Constants.TILE_SIZE/2), offsetY + (Constants.TILE_SIZE/2));
    }

    public void doMove(){

        int[] option = Constants.MOVEMENT_OPTIONS[RNG.randomNumberBetween(0, Constants.MOVEMENT_OPTIONS.length)];
        int xMove = option[0] + getLocation().getX();
        int yMove = option[1] + getLocation().getY();
        Location l = new Location(xMove, yMove);
        if (this.getClass() == NPC.class) {
            if (Constants.GAME_MAP.isTileNPCAccessible(l)) {
                this.setLocation(l);
            }
        }
    }

    public void killEntity(){
        Constants.ENTITIES_IN_GAME.remove(this);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("UUID: %s, Name: %s, Location: %s, Shape: %s", getId().getUuid(), getName(), getLocation(), getShape());
    }
}
