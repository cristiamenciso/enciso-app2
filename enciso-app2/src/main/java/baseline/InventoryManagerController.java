package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cristiam Enciso
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryManagerController implements Initializable {

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
    private TableView<InventoryItem> table;

    @FXML
    private TableColumn<InventoryItem, String> serialCol;

    // main list that is displayed
    private ObservableList<InventoryItem> masterList = FXCollections.observableArrayList();

    // Initiate inventory item for table selection
    private InventoryItem selectedItem;


    // Override initialize method to initialize GUI elements
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        // set up table columns
        nameCol.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dollarCol.setCellValueFactory(cellData -> cellData.getValue().dollarProperty());
        dollarCol.setCellFactory(TextFieldTableCell.forTableColumn());
        serialCol.setCellValueFactory(cellData -> cellData.getValue().serialProperty());
        serialCol.setCellFactory(TextFieldTableCell.forTableColumn());
        // set up table
        table.setItems(masterList);


    }


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
        InventoryItem item = new InventoryItem(nameField.getText(), dollarField.getText(), serialField.getText());
        // call addToList method
        InventoryManager man = new InventoryManager();
        man.addToList(item, masterList);
        // clear text fields
        nameField.clear();
        dollarField.clear();
        serialField.clear();
    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
        selectedItem = table.getSelectionModel().getSelectedItem();
    }

    @FXML
    void removeItemButtonClicked(ActionEvent event) {
        // Call removeItem method
        InventoryManager man = new InventoryManager();
        man.removeFromList(masterList, selectedItem);
    }

    @FXML
    void removeAllButtonClicked(ActionEvent event) {
        // Call removeAll method
        InventoryManager man = new InventoryManager();
        man.removeAllFromList(masterList);
    }

    @FXML
    void helpButtonClicked(ActionEvent event) {
        // Display file in new window

    }




}
