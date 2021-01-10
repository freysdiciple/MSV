package sample.GameScreen;

import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;

public class HexTile {

    private double sidelength;

    private int xpos;
    private int ypos;

    private Polygon tile;

    private static String tileUrl = "images/temp-tile.png";

    public HexTile(double sideLength, int[] pos) {
        sidelength = sideLength;

        xpos = pos[0];
        ypos = pos[1];

        tile = new Polygon();
        //Skaber sekskantens form
        tile.getPoints().addAll(
                0.0,0.0,
                sidelength,0.0,
                3*sidelength/2,Math.sqrt(3)*sidelength/2,
                sidelength,Math.sqrt(3)*sidelength,
                0.0,Math.sqrt(3)*sidelength,
                -1*sidelength/2,Math.sqrt(3)*sidelength/2
        );
        tile.setFill(new ImagePattern(new Image("images/hex-tile.png")));
        tile.setId("hextile");

        tile.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.SECONDARY){
                tile.setFill(new ImagePattern(new Image("images/hex-flag-tile.png")));
            }
        });

    }

    public Polygon visual(){return tile;}
}
