package com.codesmiths;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class EmailPane extends Pane {
    public static Pane getPane(List<Email> data, int limit) {
        VBox pane = new VBox();
        pane.getChildren().add(new Text("Email List"));

        if (limit > data.size())
            limit = data.size();

        for(int i = 0; i < limit; i++) {
            Email e = data.get(i);

        }
        return pane;
    }
}
