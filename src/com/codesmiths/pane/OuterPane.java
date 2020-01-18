package com.codesmiths.pane;

import com.codesmiths.structures.Email;
import com.codesmiths.Main;
import com.codesmiths.mongoDB.MongoDBConnector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class OuterPane {
    public static ScrollPane getPane() {
        List<Email> data = MongoDBConnector.getHackathonData();

        ScrollPane sPane = new ScrollPane();
        VBox outer = new VBox();
        VBox list = EmailPane.getPane(data, Main.LIMIT);
        FlowPane header = new FlowPane();
        FlowPane bar = new FlowPane();

        Text priority = new Text("Priority"), sender = new Text("Sender"), subject = new Text("Subject"), emailList = new Text("Email List"), date = new Text("Date");
        Button bRefresh = new Button("", new ImageView(new Image("com/codesmiths/resources/refresh.png")));

        priority.setWrappingWidth(100);
        sender.setWrappingWidth(280);
        subject.setWrappingWidth(250);
        header.setAlignment(Pos.CENTER);
        priority.setUnderline(true);
        sender.setUnderline(true);
        subject.setUnderline(true);
        date.setUnderline(true);
        emailList.setWrappingWidth(200);

        bRefresh.setBackground(Background.EMPTY);
        bRefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MongoDBConnector.updateHackathonData();
                resetListPane(list, outer, sPane);
            }
        });

        bar.getChildren().addAll(priority, sender, subject, date);
        bar.setPadding(new Insets(0,10,0,5));

        header.getChildren().addAll(emailList, bRefresh);
        header.setPadding(new Insets(0,10,0,15));
        header.setStyle("-fx-font-size: 20px");

        outer.getChildren().addAll(header, bar, list);
        sPane.setContent(outer);
        sPane.setFitToWidth(true);

        System.out.println("Email data retrieved");

        return sPane;
    }

    private static void resetListPane(Pane pane, Pane outer, ScrollPane sPane) {
        pane.getChildren().clear();
        MongoDBConnector.updateHackathonData();
        pane = EmailPane.getPane(MongoDBConnector.getHackathonData(), Main.LIMIT);
        outer.getChildren().remove(2);
        outer.getChildren().add(pane);
        sPane.setContent(outer);
        System.out.println("Email list refreshed");
    }
}