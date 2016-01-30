import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Joonista ring, mille suurust saab kasutaja Slideriga muuta
 */
public class JavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Slider slider = new Slider(5, 200, 50);
        Circle ring = new Circle(slider.getValue());
        slider.valueProperty().addListener(
                (observable, oldvalue, newvalue) ->
                {
                    Double raadius = newvalue.doubleValue();
                    ring.setRadius(raadius);
                } );

        root.setCenter(ring);
        root.setRight(slider);

        Scene scene = new Scene(root, 1000, 800);

            primaryStage.setTitle("Ring");
            primaryStage.setScene(scene);
            primaryStage.show();
    }



    }

