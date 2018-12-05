package engine.items;

public enum ItemType {

    UTILITY("Utility"),
    EQUIPMENT("Equipment"),
    CONSUMABLE("Consumable");

    String type;

    ItemType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
