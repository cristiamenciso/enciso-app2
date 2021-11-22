package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cristiam Enciso
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

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

    FileChooser fileChooser = new FileChooser();

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
        fileChooser.setInitialDirectory(new File("C:\\temp"));
        // set up table
        table.setItems(masterList);

        // filtered list for search
        FilteredList<InventoryItem> filteredData = new FilteredList<>(masterList, b -> true);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(inventoryItem -> {
            // no search value
            if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                return true;
            }
            String searchWord = newValue.toLowerCase();

            if(inventoryItem.getItemName().toLowerCase().contains(searchWord)) {
                return true; // match found
            }
            else if(inventoryItem.getSerialNumber().toLowerCase().contains(searchWord)) {
                return true;
            }
            else {
                return false;
            }
        }));

        SortedList<InventoryItem> sortedData = new SortedList<>(filteredData);

        // Bind results to table
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedData);
    }


    // Incomplete Save and Load Methods
    @FXML
    void saveButtonClicked(ActionEvent event) {
        // open a new window
        // use filechooser
    }

    @FXML
    void loadButtonClicked(ActionEvent event) throws IOException {
        // Open a new window
        // File file = fileChooser.showOpenDialog(new Stage());
        // use filechooser
        // open file onto table view
        

    }

    @FXML
    void addItemButtonClicked(ActionEvent event) {
        statusField.clear();
        InventoryManager man = new InventoryManager();
        // grab input from text fields
        //validate input
        if(!man.validateName(nameField.getText())) {
            statusField.clear();
            statusField.setText("Item name must bet between 2 and 256 characters");
            nameField.clear();
        }
        if(!man.validatePrice(dollarField.getText())) {
            statusField.clear();
            statusField.setText("Dollar amount must be a number greater or equal to 0");
            dollarField.clear();
        }
        if(!man.validateSerialFormat(serialField.getText())) {
            statusField.clear();
            statusField.setText("Invalid Serial Number Format");
            serialField.clear();
        }
        if(!man.validateSerialDuplicate(serialField.getText(), masterList)) {
            statusField.clear();
            statusField.setText("Serial Number exists");
            serialField.clear();
        }

        if(man.validateName(nameField.getText()) && man.validatePrice(dollarField.getText()) && man.validateSerialFormat(serialField.getText()) && man.validateSerialDuplicate(serialField.getText(), masterList)) {
            // initialize Inventory item
            InventoryItem item = new InventoryItem(nameField.getText(), dollarField.getText(), serialField.getText());
            // call addToList method
            man.addToList(item, masterList);
            // clear text fields
            nameField.clear();
            dollarField.clear();
            serialField.clear();
        }
    }

    // Method to handle when the user tries to edit the name column of the table
    @FXML
    void editButtonClicked(ActionEvent event) {
        String dollarSign = "S";
        statusField.clear();
        InventoryManager man = new InventoryManager();
        // when only editing the name
        if(!nameField.getText().isBlank() && dollarField.getText().isBlank() && serialField.getText().isBlank()) {
            if (man.validateName(nameField.getText())) {
                selectedItem.setItemName(nameField.getText());
                nameField.clear();
            } else {
                statusField.setText("Item name must bet between 2 and 256 characters");
                nameField.clear();
            }
        }
            // when only editing the dollar amount
        if(nameField.getText().isBlank() && !dollarField.getText().isBlank() && serialField.getText().isBlank()) {
            if(man.validatePrice(dollarField.getText())) {
                selectedItem.setDollarAmount(dollarSign + dollarField.getText());
                dollarField.clear();
            }
            else {
                statusField.setText("Dollar amount must be a number greater or equal to 0");
                dollarField.clear();
            }
        }
        // editing the serial number
        if(nameField.getText().isBlank() && dollarField.getText().isBlank() && !serialField.getText().isBlank()) {
            if(man.validateSerialFormat(serialField.getText()) && man.validateSerialDuplicate(serialField.getText(), masterList)) {
                selectedItem.setSerialNumber(serialField.getText());
                serialField.clear();
            }
            else {
                statusField.setText("Invalid Serial Number");
                serialField.clear();

            }
        }
        // editing both name and price
        if(!nameField.getText().isBlank() && !dollarField.getText().isBlank() && serialField.getText().isBlank()) {
            if (man.validateName(nameField.getText()) && man.validatePrice(dollarField.getText())) {
                selectedItem.setItemName(nameField.getText());
                nameField.clear();
                selectedItem.setDollarAmount(dollarSign + dollarField.getText());
                dollarField.clear();
            }
            else {
                statusField.setText("Invalid name and dollar amount");
                nameField.clear();
                dollarField.clear();
            }
        }
        // when editing the name and serial number
        if(!nameField.getText().isBlank() && dollarField.getText().isBlank() && !serialField.getText().isBlank()) {
            if (man.validateName(nameField.getText()) && man.validateSerialFormat(serialField.getText()) && man.validateSerialDuplicate(serialField.getText(), masterList)) {
                selectedItem.setItemName(nameField.getText());
                nameField.clear();
                selectedItem.setSerialNumber(serialField.getText());
                serialField.clear();
            }
            else {
                statusField.setText("Invalid name and Serial Number");
                nameField.clear();
                serialField.clear();
            }
        }
        // when editing the dollar amount and serialNumber
        if(nameField.getText().isBlank() && !dollarField.getText().isBlank() && !serialField.getText().isBlank()) {
            if(man.validatePrice(dollarField.getText()) && man.validateSerialFormat(serialField.getText()) && man.validateSerialDuplicate(serialField.getText(), masterList)) {
                selectedItem.setDollarAmount(dollarSign + dollarField.getText());
                dollarField.clear();
                selectedItem.setSerialNumber(serialField.getText());
                serialField.clear();
            }
            else {
                statusField.setText("Invalid dollar amount and serial number");
                dollarField.clear();
                serialField.clear();
            }
        }
        // when editing all fields
        if(!nameField.getText().isBlank() && !dollarField.getText().isBlank() && !serialField.getText().isBlank()) {
            if(man.validateName(nameField.getText()) && man.validatePrice(dollarField.getText()) && man.validateSerialFormat(serialField.getText()) && man.validateSerialDuplicate(serialField.getText(), masterList)) {
                selectedItem.setItemName(nameField.getText());
                nameField.clear();
                selectedItem.setDollarAmount(dollarSign + dollarField.getText());
                dollarField.clear();
                selectedItem.setSerialNumber(serialField.getText());
                serialField.clear();
            }
            else {
                statusField.setText("Invalid item name, dollar amount, and serial number");
                nameField.clear();
                dollarField.clear();
                serialField.clear();
            }

        }
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

}
