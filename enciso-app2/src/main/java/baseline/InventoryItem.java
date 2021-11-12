package baseline;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InventoryItem {
    // make String properties for the controller
    private SimpleStringProperty itemName = new SimpleStringProperty();
    private SimpleStringProperty dollarAmount = new SimpleStringProperty();
    private SimpleStringProperty serialNumber = new SimpleStringProperty();

    // getters for the properties

    public StringProperty itemNameProperty() {
        return itemName;
    }
    public StringProperty dollarProperty() {
        return dollarAmount;
    }
    public StringProperty serialProperty() {
        return serialNumber;
    }

    // Constructors
    public InventoryItem() {
        // empty constructor
    }
    public InventoryItem(String name, String value, String serial) {
        this.itemName = new SimpleStringProperty(name);
        this.dollarAmount = new SimpleStringProperty(value);
        this.serialNumber = new SimpleStringProperty(serial);
    }

    // setters and getters

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public String getDollarAmount() {
        return dollarAmount.get();
    }

    public void setDollarAmount(String dollarAmount) {
        this.dollarAmount.set(dollarAmount);
    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }
}
