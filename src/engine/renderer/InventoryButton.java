package engine.renderer;

import engine.entities.Item;
import engine.utilities.InventoryButtonAction;
import engine.utilities.Location;

public class InventoryButton {

    private String buttonLabel;
    private InventoryButtonAction buttonAction;
    private Location buttonLocation;
    private Item relatedItem;

    public InventoryButton(InventoryButtonAction buttonAction, Location buttonLocation, Item relatedItem) {
        this.buttonAction = buttonAction;
        this.buttonLabel = buttonAction.getLabel();
        this.buttonLocation = buttonLocation;
        this.relatedItem = relatedItem;
        System.out.println(String.format("Label: %s, Item: %s", buttonLabel, relatedItem.getName()));
    }
    public InventoryButtonAction getButtonAction() {
        return buttonAction;
    }

    public Location getButtonLocation() {
        return buttonLocation;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public Item getRelatedItem() {
        return relatedItem;
    }

    @Override
    public String toString() {
        return getButtonLabel();
    }
}
