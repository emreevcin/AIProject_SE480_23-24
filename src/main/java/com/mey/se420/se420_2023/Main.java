package com.mey.se420.se420_2023;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/mey/se420/se420_2023/main-view.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Navigation System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}