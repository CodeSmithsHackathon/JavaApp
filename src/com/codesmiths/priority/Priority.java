package com.codesmiths.priority;

import javafx.scene.image.Image;

public enum Priority {
    LOW(new Image("com/codesmiths/resources/priority/low.png")),
    MEDIUM(new Image("com/codesmiths/resources/priority/medium.png")),
    HIGH(new Image("com/codesmiths/resources/priority/high.png"));

    private Image img;

    private Priority(Image img) {
        this.img = img;
    }

    public Image getImage() {
        return img;
    }
}
