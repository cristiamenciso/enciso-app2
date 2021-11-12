package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cristiam Enciso
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InventoryManagementApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainStage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InventoryManager.fxml")));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Inventory Manager");
            mainStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
