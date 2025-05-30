package dk.sdu.cbse.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane(new Label("AsteroidsFX - Core Module"));
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("AsteroidsFX");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
