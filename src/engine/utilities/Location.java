package engine.utilities;

import java.util.List;

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

    public void addXandY(int[] coords){
        setLocation(new Location(this.getX() + coords[0], this.getY() + coords[1]));
    }

    public Location addXandYandReturn(int[] coords){
        Location l = this;
        l.addXandY(coords);
        return l;
    }

    public Location copyOf(){
        return new Location(this.getX(), this.getY());
    }

    public boolean equalTo(Location l){
        return (this.getX() == l.getX() && this.getY() == l.getY());
    }

    public boolean isLocationIn(List<Location> locations){
        for(Location l : locations){
            if (this.equalTo(l)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[x:"+getX()+",y"+getY()+"]";
    }
}
