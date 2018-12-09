package engine.utilities;

public enum InventoryButtonAction {

    USE(0, "Use"),
    EQUIP(1, "Equip"),
    DROP(2, "Drop");

    int id;
    String label;

    InventoryButtonAction(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
