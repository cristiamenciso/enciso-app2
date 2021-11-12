package baseline;

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
    private TableColumn<InventoryItem, String> SerialCol;

    @FXML
    void saveButtonClicked(ActionEvent event) {

    }

    @FXML
    void loadButtonClicked(ActionEvent event) {

    }

    @FXML
    void addItemButtonClicked(ActionEvent event) {

    }

    @FXML
    void RemoveItemButtonClicked(ActionEvent event) {

    }

    @FXML
    void removeAllButtonClicked(ActionEvent event) {

    }

    @FXML
    void helpButtonClicked(ActionEvent event) {

    }
}
