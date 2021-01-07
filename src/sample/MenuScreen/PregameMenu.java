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
import javafx.stage.Stage;
import sample.Main;

import java.awt.*;

public class PregameMenu {

    static Scene scene;
    static VBox menu;

    static final String titleURL = "images/title.png";

    public PregameMenu(int[] stagedims){
        menu = new VBox(stagedims[1]/12);
        menu.setAlignment(Pos.CENTER);

        //Title
        ImageView title = new ImageView(new Image(titleURL));
        title.setFitWidth(400);
        title.setFitHeight(100);

        menu.getChildren().addAll(title, new SizeSlider(stagedims).visual(), new DiffSlider(stagedims).visual(), new StartButton().visual());
        scene = new Scene(menu, stagedims[0], stagedims[1]);
    }

    public Scene getScene() {
        return scene;
    }

}
