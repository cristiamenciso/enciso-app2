package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cristiam Enciso
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InventoryManagerController {

    @FXML
    private TableColumn<InventoryItem, String> dollarCol;

    @FXML
    private TextField dollarField;

    @FXML
    private TextField searchField;

    @FXML
    private TextField statusField;

    @FXML
    private TableColumn<InventoryItem, String> nameCol;

    @FXML
    private TextField serialField;

    @FXML
    private TextField nameField;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<InventoryItem, String> serialCol;

    // main list that is displayed
    private ObservableList<InventoryItem> masterList = FXCollections.observableArrayList();

    // Override initialize method to initialize GUI elements

    // Event methods
    @FXML
    void saveButtonClicked(ActionEvent event) {
        // open a new window
        // use filechooser

    }

    @FXML
    void loadButtonClicked(ActionEvent event) {
        // Open a new window
        // use filechooser
        // open file onto table view

    }

    @FXML
    void addItemButtonClicked(ActionEvent event) {
        // grab input from text fields
        // initialize Inventory item
        // call addToList method
        // clear text fields
    }

    @FXML
    void removeItemButtonClicked(ActionEvent event) {
        // call selectedMethod
        // Call removeItem method
    }

    @FXML
    void removeAllButtonClicked(ActionEvent event) {
        // Call removeAll method

    }

    @FXML
    void helpButtonClicked(ActionEvent event) {
        // Display file in new window

    }




}
