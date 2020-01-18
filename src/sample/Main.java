package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ArrayList<Email> data = MongoDBConnector.getHackathonData();
        data.add(new Email("test", "test", "test", "test", "test.txt", new Date()));
        data.add(new Email("test1", "test1", "test1", "test1", "test1.txt", new Date()));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(new Pane(), 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
