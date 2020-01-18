package com.codesmiths.pane;

import com.codesmiths.mongoDB.MongoDBConnector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPane {
    public static Pane getPane(Stage stage) {
        VBox pane = new VBox();
        Text tUsername = new Text("Username:"), tPassword = new Text("Password:");
        TextField tfUsername = new TextField(), tfPassword = new TextField();
        Button btSubmit = new Button("Submit");
        FlowPane username = new FlowPane(), password = new FlowPane(), submit = new FlowPane(), failed = new FlowPane();
        Text tFailed = new Text("Invalid username or password.");

        tUsername.setWrappingWidth(75);
        tPassword.setWrappingWidth(75);
        tFailed.setFill(Color.RED);

        btSubmit.setOnAction(e -> attemptLogin(stage, failed, tfUsername.getText(), tfPassword.getText()));
        tfUsername.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER)
                    attemptLogin(stage, failed, tfUsername.getText(), tfPassword.getText());
            }
        });
        tfPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER)
                    attemptLogin(stage, failed, tfUsername.getText(), tfPassword.getText());
            }
        });

        submit.setAlignment(Pos.CENTER);
        failed.setAlignment(Pos.CENTER);
        failed.setVisible(false);
        username.setPadding(new Insets(10, 10, 0, 10));
        password.setPadding(new Insets(10, 10, 10, 10));

        username.getChildren().addAll(tUsername, tfUsername);
        password.getChildren().addAll(tPassword, tfPassword);
        submit.getChildren().addAll(btSubmit);
        failed.getChildren().add(tFailed);
        pane.getChildren().addAll(username, password, submit, failed);

        return pane;
    }

    private static void attemptLogin(Stage stage, Pane failedPane, String username, String password) {
        if (MongoDBConnector.authenticateUser(username, password)) {
            stage.setTitle("Possibly Malicious Emails");
            stage.setScene(new Scene(OuterPane.getPane(), 750, 575));
            System.out.println("Login successful");
        } else {
            failedPane.setVisible(true);
            System.out.println("Login unsuccessful");
        }
    }
}
