package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import sample.GameScreen.GameScene;
import sample.MainMenuScreen.MainMenu;
import sample.MultiPlayerMenu.MultiPlayerMenu;
import sample.SinglePlayerMenu.SinglePlayerMenu;

public class Main extends Application {

    private static Stage window;
    private static Scene multipregame = null, singlepregame = null, game = null, mainmenu = null;

    static int stageWidth = (int)Screen.getPrimary().getVisualBounds().getWidth();
    static int stageHeight = (int)Screen.getPrimary().getVisualBounds().getHeight();

    static final int gap = 0;

    static int sizeX;
    static int sizeY;

    static int difficulty;


    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Hello World");

        mainmenu = new MainMenu(new int[]{stageWidth, stageHeight});

        window.setScene(mainmenu);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void collectGameScene(){
        game = new GameScene(new int[]{stageWidth,stageHeight}, sizeX, difficulty);
    }

    public static void collectSinglePregameScene() { singlepregame = new SinglePlayerMenu(new int[]{stageWidth, stageHeight});}

    public static void collectMultiPregameScene() { multipregame = new MultiPlayerMenu(new int[]{stageWidth, stageHeight});}

    public static void goToScene(String where){

        switch (where){
            case "main-menu":
                window.setScene(mainmenu);
                break;
            case "single-pregame":
                if(singlepregame == null) collectSinglePregameScene();
                window.setScene(singlepregame);
                break;
            case "multi-pregame":
                if(multipregame == null) collectMultiPregameScene();
                window.setScene(multipregame);
                break;
            case "game":
                collectGameScene();
                window.setScene(game);
                break;
        }

    }

    public static void setGamesize(int _sizeX){
        sizeX = _sizeX;
        sizeY = (stageHeight-100)*sizeX/stageWidth;
    }

    public static void setDifficulty(int _difficulty){
        difficulty = _difficulty;
    }
}
