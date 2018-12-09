package engine.renderer;

import engine.utilities.InventoryButtonAction;
import engine.utilities.InventoryMouseListener;

public class InventoryButton {

    private String buttonLabel;
    private InventoryButtonAction buttonAction;
    private InventoryMouseListener buttonActionListener;

    public InventoryButton(InventoryButtonAction buttonAction) {
        this.buttonAction = buttonAction;
        this.buttonLabel = buttonAction.getLabel();
    }

    public void setButtonActionListener(InventoryMouseListener buttonActionListener) {
        this.buttonActionListener = buttonActionListener;
    }

    public InventoryButtonAction getButtonAction() {
        return buttonAction;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    @Override
    public String toString() {
        return getButtonLabel();
    }
}
