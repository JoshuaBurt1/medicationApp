package com.example.assignment2a;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    /**
     * This method creates the initial stage
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Medication organizer and alert");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("blisterpack-view.fxml")); //this creates an instance of a preset stage (blisterpack-view.fxml)
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * This method launches the student-view application
     */
    public static void main(String[] args) {
        launch();
    }
}

