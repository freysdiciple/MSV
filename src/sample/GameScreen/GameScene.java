package sample.GameScreen;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class GameScene {

    Scene gamescene;

    int inset = 30;

    public GameScene(int stageWidth, int size){
        BorderPane gameView = new BorderPane();
        gameView.setTop(new TopMenu(stageWidth, inset).visual());
        gameView.setCenter(new HexagonalBoard(stageWidth, inset, size).visual());
        gameView.setId("gameback");

        gamescene = new Scene(gameView);
        gamescene.getStylesheets().add(this.getClass().getResource("./GameStyles.css").toExternalForm());
    }

    public Scene visual(){
        return gamescene;
    }
}
