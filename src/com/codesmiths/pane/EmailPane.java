package com.codesmiths.pane;

import com.codesmiths.structures.Email;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.List;

public class EmailPane extends Pane {
    public static Pane getPane(List<Email> data, int limit) {
        VBox pane = new VBox();

        if (limit > data.size())
            limit = data.size();

        for(int i = 0; i < limit; i++) {
            FlowPane fp = new FlowPane();
            Email e = data.get(i);
            ImageView iv = new ImageView(e.getPriority().getImage());
            Text sender = new Text("  " + e.getSender());
            Text subject = new Text(e.getSubject().length() > 50 ? e.getSubject().substring(0, 50) + "..." : e.getSubject());
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Text date = new Text(sdf.format(e.getSendDate()));
            Button btPopOut = new Button("", new ImageView(new Image("com/codesmiths/resources/popout.png")));
            btPopOut.setBackground(Background.EMPTY);

            btPopOut.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Stage stage = new Stage();
                    stage.setTitle(e.getSender());
                    stage.setResizable(false);
                    stage.setScene(new Scene(PopoutPane.getPane(e), 450, 375));
                    stage.getIcons().add(new Image("com/codesmiths/resources/icon.png"));
                    stage.show();
                }
            });

            fp.setHgap(15);
            sender.setWrappingWidth(250);
            subject.setWrappingWidth(300);
            fp.getChildren().addAll(iv, sender, subject, date, btPopOut);
            fp.setPadding(new Insets(10, 0, 10, 10));
            pane.getChildren().add(fp);
        }
        return pane;
    }
}
