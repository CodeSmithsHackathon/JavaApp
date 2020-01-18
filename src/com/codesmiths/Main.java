package com.codesmiths;

import com.codesmiths.pane.LoginPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int LIMIT = 25;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(LoginPane.getPane(primaryStage), 250, 125));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("com/codesmiths/resources/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
