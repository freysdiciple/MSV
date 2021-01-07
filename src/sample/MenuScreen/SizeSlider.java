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

public class SizeSlider {

    static VBox sizeElement;

    static final String sizeUrl = "images/size-icon.png";

    public SizeSlider(int[] stagedims){
        //Size
        Slider sizeSlider = new Slider();
        sizeSlider.setMin(10);
        sizeSlider.setMax(50);
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setMaxWidth(stagedims[0]/4);

        sizeSlider.setMajorTickUnit(20);
        sizeSlider.setValue(30);
        Main.setGamesize(30);

        Label sizeValueText = new Label("" + sizeSlider.getValue());
        sizeValueText.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");

        sizeSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(
                    ObservableValue<? extends Number> observableValue,
                    Number oldValue,
                    Number newValue) {
                sizeValueText.setText("" + newValue.intValue());
                Main.setGamesize(newValue.intValue());
            }
        });

        ImageView sizePic = new ImageView(new Image(sizeUrl));
        sizePic.setFitWidth(50);
        sizePic.setFitHeight(25);

        HBox sizeTitle = new HBox(0);
        sizeTitle.setAlignment(Pos.CENTER);
        sizeTitle.getChildren().addAll(sizePic,sizeValueText);

        sizeElement = new VBox(12);
        sizeElement.setAlignment(Pos.CENTER);
        sizeElement.getChildren().addAll(sizeTitle, sizeSlider);

    }

    public VBox visual(){
        return sizeElement;
    }
}
