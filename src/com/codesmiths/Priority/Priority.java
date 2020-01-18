package com.codesmiths.Priority;

import javafx.scene.image.Image;

public enum Priority {
    LOW(new Image("low.png")),
    MEDIUM(new Image("medium.png")),
    HIGH(new Image("high.png"));

    private Image img;

    private Priority(Image img) {
        this.img = img;
    }

    public Image getImage() {
        return img;
    }
}
