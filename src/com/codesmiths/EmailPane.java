package com.codesmiths;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
            Text subject = new Text(e.getSubject().length() > 100 ? e.getSubject().substring(0, 100) + "..." : e.getSubject());

            fp.setHgap(15);
            sender.setWrappingWidth(250);
            subject.setWrappingWidth(350);
            fp.getChildren().addAll(iv, sender, subject);
            fp.setPadding(new Insets(10, 0, 10, 10));
            pane.getChildren().add(fp);
        }
        return pane;
    }
}
