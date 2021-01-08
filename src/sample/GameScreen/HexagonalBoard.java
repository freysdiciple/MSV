package sample.GameScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class HexagonalBoard {
    private int size = 4;

    private double sideLength;

    static private HBox board;

    public HexagonalBoard(int stagewidth, int inset){

        board = new HBox();
        board.setPadding(new Insets(inset,inset,inset,inset));
        board.setAlignment(Pos.CENTER);

        sideLength = (stagewidth/1.5 - 2*inset)/(4*size + 2);

        HBox verticalAxis = new HBox(0);

        for(int col = -size; col<=size; col++){

            VBox currCol = new VBox(sideLength/2);


            for(int row = 0; row<Math.abs(col); row++){
                currCol.getChildren().add(new Rectangle(0,Math.sqrt(3)*sideLength/2 - sideLength/4));
            }


            for(int row = 0; row<=2*size-Math.abs(col); row++ ){
                HexTile currTile = new HexTile(sideLength, new int[]{col + size, row});
                currCol.getChildren().add(currTile.visual());
            }

            verticalAxis.getChildren().add(currCol);
        }

        board.getChildren().add(verticalAxis);

    }

    public HBox visual(){
        return board;
    }
}
