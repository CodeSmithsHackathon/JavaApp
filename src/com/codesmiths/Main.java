package com.codesmiths;

import com.codesmiths.MongoDB.MongoDBConnector;
import com.codesmiths.Priority.Priority;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        FlowPane header = new FlowPane();
        header.getChildren().add(new Text("Email List"));

        ArrayList<Email> data = MongoDBConnector.getHackathonData();
        data.add(new Email("test", "test", "test", "test", "test.txt", new Date(), Priority.HIGH));
        data.add(new Email("test1", "test1", "test1", "test1", "test1.txt", new Date(), Priority.HIGH));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(EmailPane.getPane(data, 25), 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
