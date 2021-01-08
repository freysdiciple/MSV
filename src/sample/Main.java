package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import sample.GameScreen.BoardGenerator;
import sample.GameScreen.TopMenu;
import sample.MenuScreen.PregameMenu;

public class Main extends Application {

    private static Stage window;
    private static Scene pregame, game;

    static final int stageWidth = 1000;
    static final int stageHeight = 600;

    static final int inset = 20;
    static final int gap = 0;

    static int sizeX;
    static int sizeY;

    static int difficulty;


    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Hello World");

        pregame = new PregameMenu(new int[]{stageWidth, stageHeight}).getScene();

        window.setScene(pregame);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void collectGameScene(){
        BorderPane gameView = new BorderPane();
        gameView.setTop(new TopMenu(stageWidth, window, pregame).visual());
        gameView.setCenter(new BoardGenerator(new int[]{sizeX, sizeY, stageWidth}, new int[]{gap,inset}).visual());
        game = new Scene(gameView);
    }

    public static void goToScene(String where){
        window.setScene(where == "pre" ? pregame : game);
    }

    public static void setGamesize(int _sizeX){
        sizeX = _sizeX;
        sizeY = (stageHeight-100)*sizeX/stageWidth;
    }

    public static void setDifficulty(int _difficulty){
        difficulty = _difficulty;
    }
}
