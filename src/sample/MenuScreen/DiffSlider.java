package sample.MenuScreen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Main;

public class DiffSlider {

    static VBox diffElement;

    static final String diffUrl = "images/diff-icon.png";

    public DiffSlider(int[] stagedims){
        //Difficulty
        Slider diffSlider = new Slider();
        diffSlider.setMin(0);
        diffSlider.setMax(10);
        diffSlider.setShowTickLabels(true);
        diffSlider.setMaxWidth(stagedims[0]/4);

        diffSlider.setMajorTickUnit(5);
        diffSlider.setValue(5);
        Main.setDifficulty(5);

        Label diffValueText = new Label("" + diffSlider.getValue());
        diffValueText.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");

        diffSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(
                    ObservableValue<? extends Number> observableValue,
                    Number oldValue,
                    Number newValue) {
                diffValueText.setText("" + newValue.intValue());
                Main.setDifficulty(newValue.intValue());
            }
        });

        ImageView diffPic = new ImageView(new Image(diffUrl));
        diffPic.setFitWidth(100);
        diffPic.setFitHeight(25);

        HBox diffTitle = new HBox(0);
        diffTitle.setAlignment(Pos.CENTER);
        diffTitle.getChildren().addAll(diffPic,diffValueText);

        diffElement = new VBox(12);
        diffElement.setAlignment(Pos.CENTER);
        diffElement.getChildren().addAll(diffTitle, diffSlider);
    }

    public VBox visual(){
        return diffElement;
    }
}
