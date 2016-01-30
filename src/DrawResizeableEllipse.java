import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * Created by 38307220306 on 30.01.2016.
 */
public class DrawResizeableEllipse extends Application {

    /** Typical main method for applications. */
    public static void main (String[] args) {
        launch (args);
    }

    /** Compulsory method for Application.
     * @param myStage JavaFX main stage for this application
     */
    @Override
    public void start (Stage myStage) {
        Pane myPane = new Pane();
        Scene myScene = new Scene (myPane, 100., 100.);
        myStage.setScene (myScene);
        myStage.setTitle ("My own ellipse");
        ObservableList<Node> nodes = myPane.getChildren();
        drawEllipse (myScene.getWidth(), myScene.getHeight(), nodes);
        myScene.widthProperty().addListener (
                (obsv, oldv, newv) -> {
                    drawEllipse (myScene.getWidth(), myScene.getHeight(), nodes);
                });
        myScene.heightProperty().addListener (
                (obsv, oldv, newv) -> {
                    drawEllipse (myScene.getWidth(), myScene.getHeight(), nodes);
                });
        myStage.show();
    }

    /** Local helper method to draw an ellipse. */
    protected static void drawEllipse (double w, double h, ObservableList<Node> nl) {
        Ellipse myShape = new Ellipse (w/2., h/2., w/2., h/2.);
        myShape.setStroke (Color.BLACK);
        myShape.setFill (Color.WHITE);
        nl.clear();
        nl.add (myShape);
    }
}
