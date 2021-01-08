package sample.MenuScreen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;

import java.awt.*;

public class PregameMenu {

    static Scene scene;
    static VBox menu;

    static final String titleURL = "images/premenu-title.png";

    public PregameMenu(int[] stagedims){
        menu = new VBox((double) stagedims[1]/20);
        menu.setAlignment(Pos.CENTER);
        menu.setId("menu");

        //Title
        ImageView title = new ImageView(new Image(titleURL));
        title.setFitWidth(600);
        title.setFitHeight(80);

        menu.getChildren().addAll(title, new SizeSlider(stagedims).visual(), new DiffSlider(stagedims).visual(), new StartButton().visual());
        scene = new Scene(menu, stagedims[0], stagedims[1]);
        scene.getStylesheets().add(this.getClass().getResource("../Styles.css").toExternalForm());
    }

    public Scene getScene() {
        return scene;
    }

}
