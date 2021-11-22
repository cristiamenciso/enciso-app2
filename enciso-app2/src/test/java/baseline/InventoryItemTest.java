package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cristiam Enciso
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryItemTest {

    @Test
    void getItemName() {
        InventoryItem test = new InventoryItem("PS5", "299.99", "A-XXX-XXX-XXX" );
        String actual = test.getItemName();
        String expected = "PS5";
        assertEquals(expected, actual);
    }

    @Test
    void setItemName() {
        InventoryItem test = new InventoryItem();
        test.setItemName("XBOX");
        String actual = test.getItemName();
        String expected = "XBOX";
        assertEquals(expected, actual);
    }

    @Test
    void getDollarAmount() {
        InventoryItem test = new InventoryItem("PS5", "299.99", "A-XXX-XXX-XXX" );
        String actual = test.getDollarAmount();
        String expected = "$299.99";
        assertEquals(expected, actual);
    }

    @Test
    void setDollarAmount() {
        InventoryItem test = new InventoryItem();
        test.setDollarAmount("399.99");
        String actual = test.getDollarAmount();
        String expected = "399.99";
        assertEquals(expected, actual);
    }

    @Test
    void getSerialNumber() {
        InventoryItem test = new InventoryItem();
        test.setSerialNumber("A-XXX-XXX-XXX");
        String actual = test.getSerialNumber();
        String expected = "A-XXX-XXX-XXX";
        assertEquals(expected, actual);
    }

    @Test
    void setSerialNumber() {
        InventoryItem test = new InventoryItem();
        test.setSerialNumber("A-XXX-XXX-XXX");
        String actual = test.getSerialNumber();
        String expected = "A-XXX-XXX-XXX";
        assertEquals(expected, actual);

    }
}