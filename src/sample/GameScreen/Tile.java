package sample.GameScreen;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tile {
    private double width;
    private double height;

    private int xpos;
    private int ypos;

    private Rectangle tile;

    private final String tileBasicURL = "images/tile-grass.jpg";
    private final String tileHoverURL = "images/tile-grass-hover.jpg";
    private final String tileClickedURL = "images/tile-dirt.jpg";

    private String value;
    private boolean clicked;

    public Tile(double[] dims, int[] pos, String value){
        this.width = dims[0];
        this.height = dims[1];

        this.xpos = pos[0];
        this.ypos = pos[1];

        this.value = value;

        tile = new Rectangle(width, height);
        GridPane.setConstraints(tile, pos[0], pos[1]);

        initialConfig();
    }

    public void initialConfig(){
        Image tileBasic = new Image(tileBasicURL);
        Image tileHover = new Image(tileHoverURL);
        tile.setFill(new ImagePattern(tileBasic));

        tile.setOnMouseEntered(e -> {if(!clicked) {tile.setFill(new ImagePattern(tileHover));}});
        tile.setOnMouseExited(e -> {if(!clicked) {tile.setFill(new ImagePattern(tileBasic));}});
        tile.setOnMouseClicked(e -> {clicked = true; tile.setFill(new ImagePattern(new Image(tileClickedURL)));});

        tile.setStyle("-fx-cursor: hand;");
    }

    public Rectangle visual(){
        return tile;
    }
}