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
            fp.setPadding(new Insets(10, 10, 10, 10));
            Email e = data.get(i);
            fp.getChildren().add(new ImageView(e.getPriority().getImage()));
            fp.getChildren().add(new Text(e.getSender()));
            pane.getChildren().add(fp);
        }
        return pane;
    }
}
