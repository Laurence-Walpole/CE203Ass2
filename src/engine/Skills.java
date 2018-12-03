package engine;

public enum Skills {

    ATTACK(0),
    DEFENCE(1),
    HITPOINTS(2);

    int id;

    Skills(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
