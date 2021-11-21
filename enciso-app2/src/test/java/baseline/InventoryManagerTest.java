package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    @Test
    void addToList() {
    }

    @Test
    void removeFromList() {
    }

    @Test
    void removeAllFromList() {
    }

    @Test
    void validateName() {
    }

    @Test
    void validatePrice() {
    }

    @Test
    void validateSerialFormat() {
        InventoryManager man = new InventoryManager();
        String expected = "A-XXX-XXX-XXX";

        assertTrue(man.validateSerialFormat(expected));
    }

    @Test
    void validateSerialDuplicate() {
        InventoryManager man = new InventoryManager();
        ObservableList<InventoryItem> testList = FXCollections.observableArrayList();
        InventoryItem testItem = new InventoryItem("Cristiam","25", "A-XXX-XXX-XXX" );
        testList.add(testItem);
        assertFalse(man.validateSerialDuplicate("A-XXX-XXX-XXX", testList));
    }
}