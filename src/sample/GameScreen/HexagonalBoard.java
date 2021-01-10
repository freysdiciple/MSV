package sample.GameScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HexagonalBoard {
    private int size = 10;

    private double sideLength;

    static private HBox board;
    static private VBox boat;
    static private StackPane whole;

    public HexagonalBoard(int stagewidth, int inset, int _size){
        size = _size;

        board = new HBox();
        board.setPadding(new Insets(inset,inset,inset,inset));
        board.setAlignment(Pos.CENTER);

        sideLength = (stagewidth/2 - 2*inset)/(4*size + 2);

        HBox verticalAxis = new HBox(0);

        for(int col = -size; col<=size; col++){

            //Afstanden mellem alle hexagonerne er halvdelen af sidelaengden
            VBox currCol = new VBox(sideLength/2);

            //Dette for-loop skaber pladsen der forskyder kolonnerne fra hinanden
            for(int row = 0; row<Math.abs(col); row++){
                currCol.getChildren().add(new Rectangle(0,Math.sqrt(3)*sideLength/2 - sideLength/4));
            }

            //Dette for-loop skaber HexTilesne
            for(int row = 0; row<=2*size-Math.abs(col); row++ ){
                //Skaber ny hextile og tilfoejer dens visual til kolonnen
                HexTile currTile = new HexTile(sideLength, new int[]{col + size, row});
                currCol.getChildren().add(currTile.visual());
            }

            //Hver gang en kolonne er skabt blir den tilfoejet til raekkerne
            verticalAxis.getChildren().add(currCol);
        }

        board.getChildren().add(verticalAxis);

        boat = new VBox(10);
        boat.setPadding(new Insets(0,0,0,50));
        boat.setAlignment(Pos.CENTER_LEFT);

        Text boattext = new Text("Help me get through!\nFind all the mines!");
        Font pixelfont = Font.loadFont(this.getClass().getResource("../PressStart2P-Regular.ttf").toExternalForm(), 10);
        boattext.setLineSpacing(5);
        boattext.setFont(pixelfont);
        boattext.setFill(Color.WHITE);

        ImageView boatimage = new ImageView(new Image("images/image_submarine.gif"));
        boatimage.setFitWidth(160);
        boatimage.setFitHeight(75);

        boat.getChildren().addAll(boattext, boatimage);


        whole = new StackPane();
        whole.getChildren().addAll(boat, board);

    }

    public StackPane visual(){
        return whole;
    }
}
