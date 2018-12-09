package engine;

public enum Skills {

    ATTACK(0, "Attack"),
    DEFENCE(1, "Defence"),
    HITPOINTS(2, "Hitpoints");

    int id;
    String name;

    Skills(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static Skills getSkill(int id){
        if (id == ATTACK.id) return ATTACK;
        if (id == DEFENCE.id) return DEFENCE;
        if (id == HITPOINTS.id) return HITPOINTS;
        return null;
    }

    public String getName() {
        return name;
    }
}
