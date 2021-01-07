package sample.MenuScreen;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Main;

public class StartButton {

    static final String startUrl = "images/startgame-button.png";
    static final String startHoverUrl = "images/startgame-button-hover.png";
    static Rectangle startbutton;

    public StartButton() {
        startbutton = new Rectangle(200, 50);
        startbutton.setFill(new ImagePattern(new Image(startUrl)));
        startbutton.setOnMouseEntered(e -> startbutton.setFill(new ImagePattern(new Image(startHoverUrl))));
        startbutton.setOnMouseExited(e -> startbutton.setFill(new ImagePattern(new Image(startUrl))));
        startbutton.setOnMouseClicked(e -> {
            Main.collectGameScene();
            Main.goToScene("game");
        });
    }

    public Rectangle visual() {
        return startbutton;
    }
}
