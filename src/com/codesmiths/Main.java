package com.codesmiths;

import com.codesmiths.mongoDB.MongoDBConnector;
import com.codesmiths.priority.Priority;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ArrayList<Email> data = MongoDBConnector.getHackathonData();

        VBox outer = new VBox();
        Pane list = EmailPane.getPane(data, 25);
        FlowPane header = new FlowPane();
        FlowPane bar = new FlowPane();

        Text priority = new Text("Priority"), sender = new Text("Sender"), subject = new Text("Subject"), emailList = new Text("Email List");

        priority.setWrappingWidth(90);
        sender.setWrappingWidth(300);
        header.setAlignment(Pos.CENTER);
        priority.setUnderline(true);
        sender.setUnderline(true);
        subject.setUnderline(true);

        bar.getChildren().addAll(priority, sender, subject);
        bar.setPadding(new Insets(0,10,0,5));

        header.getChildren().add(emailList);
        header.setPadding(new Insets(0,10,0,15));
        header.setStyle("-fx-font-size: 20px");

        outer.getChildren().addAll(header, bar, list);

        primaryStage.setTitle("Possibly Malicious Emails");
        primaryStage.setScene(new Scene(outer, 800, 775));
        primaryStage.setResizable(false);
        //primaryStage.getIcons().add(new Image("com/codesmiths/resources/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
