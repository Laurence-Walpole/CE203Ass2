package engine.utilities;

public class Location {

    private int x, y;
    private boolean accessible;

    public Location(){}

    public Location(int x, int y){
        this.x = x;
        this.y = y;
        this.accessible = true;
    }

    public Location(int x, int y, boolean accessible){
        this.x = x;
        this.y = y;
        this.accessible = accessible;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public Location getLocation(){
        return this;
    }

    public void setLocation(Location l){
         this.x = l.getX();
         this.y = l.getY();
         this.accessible = l.isAccessible();
    }

    @Override
    public String toString() {
        return "[x:"+getX()+",y"+getY()+"]";
    }
}
