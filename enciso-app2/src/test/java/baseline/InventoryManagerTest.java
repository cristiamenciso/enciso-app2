package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cristiam Enciso
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    @Test
    void addToList() {
        ObservableList<InventoryItem> test = FXCollections.observableArrayList();
        InventoryManager man = new InventoryManager();
        InventoryItem item = new InventoryItem("PS5", "299.99", "A-XXX-XXX-XXX");
        man.addToList(item, test);
        assertFalse(test.isEmpty());

    }

    @Test
    void removeFromList() {
        ObservableList<InventoryItem> test = FXCollections.observableArrayList();
        InventoryManager man = new InventoryManager();
        InventoryItem item = new InventoryItem("PS5", "299.99", "A-XXX-XXX-XXX");
        man.addToList(item, test);
        man.removeFromList(test, item);
        assertTrue(test.isEmpty());
    }

    @Test
    void removeAllFromList() {
        ObservableList<InventoryItem> test = FXCollections.observableArrayList();
        InventoryManager man = new InventoryManager();
        InventoryItem item1 = new InventoryItem("PS5", "299.99", "A-XXX-XXX-XXX");
        InventoryItem item2 = new InventoryItem("XBOX", "399.99", "B-XXX-XXX-XXX");
        man.addToList(item1, test);
        man.addToList(item2, test);
        man.removeAllFromList(test);
        assertTrue(test.isEmpty());
    }

    @Test
    void validateNameTrue() {
        InventoryManager man = new InventoryManager();
        boolean result = man.validateName("PS5");
        assertTrue(result);
    }
    @Test
    void validateNameFalse() {
        InventoryManager man = new InventoryManager();
        boolean result = man.validateName("P");
        assertFalse(result);
    }

    @Test
    void validatePriceTrue() {
        InventoryManager man = new InventoryManager();
        boolean result = man.validatePrice("550.55");
        assertTrue(result);
    }
    @Test
    void validatePriceFalse() {
        InventoryManager man = new InventoryManager();
        boolean result = man.validatePrice("-5.00");
        assertFalse(result);
    }

    @Test
    void validateSerialFormatTrue() {
        InventoryManager man = new InventoryManager();
        String expected = "A-XXX-XXX-XXX";

        assertTrue(man.validateSerialFormat(expected));
    }
    @Test
    void validateSerialFormatFalse() {
        InventoryManager man = new InventoryManager();
        String expected = "Cristiam Enciso ";

        assertFalse(man.validateSerialFormat(expected));
    }

    @Test
    void validateSerialDuplicateFalse() {
        InventoryManager man = new InventoryManager();
        ObservableList<InventoryItem> testList = FXCollections.observableArrayList();
        InventoryItem testItem = new InventoryItem("Cristiam","25", "A-XXX-XXX-XXX" );
        testList.add(testItem);
        assertFalse(man.validateSerialDuplicate("A-XXX-XXX-XXX", testList));
    }
    @Test
    void validateSerialDuplicate() {
        InventoryManager man = new InventoryManager();
        ObservableList<InventoryItem> testList = FXCollections.observableArrayList();
        InventoryItem testItem = new InventoryItem("Cristiam","25", "A-XXX-XXX-XXX" );
        testList.add(testItem);
        assertTrue(man.validateSerialDuplicate("B-XXX-XXX-XXX", testList));
    }
}