package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cristiam Enciso
 */

import javafx.collections.ObservableList;

public class InventoryManager {
    // Helper methods to perform work. Makes methods testable
    public void addToList(InventoryItem item, ObservableList<InventoryItem> list) {
        // add item to observable list
        list.add(item);
    }
    public void removeFromList(ObservableList<InventoryItem> list, InventoryItem item) {
        // remove item from list
        list.remove(item);
    }
    public void removeAllFromList(ObservableList<InventoryItem> list) {
        // clear the list
        list.clear();
    }
    // method to validate name
    public boolean validateName(String itemName) {
        if(itemName.length() < 2 || itemName.length() > 256) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean validatePrice(String dollarAmount) {
        if(Double.parseDouble(dollarAmount) >= 0) {
            return true;
        }
        else {
            return false;
        }

    }
}
