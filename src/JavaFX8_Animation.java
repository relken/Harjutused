package com.zetcode;

        import javafx.animation.FadeTransition;
        import javafx.animation.FillTransition;
        import javafx.animation.ParallelTransition;
        import javafx.animation.PathTransition;
        import javafx.animation.PathTransition.OrientationType;
        import javafx.animation.RotateTransition;
        import javafx.animation.ScaleTransition;
        import javafx.animation.SequentialTransition;
        import javafx.animation.StrokeTransition;
        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.paint.Color;
        import javafx.scene.paint.CycleMethod;
        import javafx.scene.paint.LinearGradient;
        import javafx.scene.paint.Stop;
        import javafx.scene.shape.ArcTo;
        import javafx.scene.shape.ClosePath;
        import javafx.scene.shape.LineTo;
        import javafx.scene.shape.MoveTo;
        import javafx.scene.shape.Path;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;
        import javafx.util.Duration;

/**
 *
 * @web java-buddy.blogspot.com
 */
public class JavaFX8_Animation extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 350, Color.BLACK);
        scene.setFill(Color.WHITE);

        Rectangle rect1 = new Rectangle(50, 50, 50, 50);
        rect1.setFill(Color.BLUEVIOLET);
        rect1.setStroke(Color.RED);
        rect1.setStrokeWidth(3);

        Path path1 = new Path();
        path1.getElements().add (new MoveTo (75f, 75f));
        path1.getElements().add (new LineTo (75f, 175f));
        path1.getElements().add (new LineTo (175f, 175f));
        path1.getElements().add (new LineTo (175f, 75f));
        path1.getElements().add(new ClosePath());

        PathTransition pathTransition1 = new PathTransition();
        pathTransition1.setDuration(Duration.millis(4000));
        pathTransition1.setPath(path1);
        pathTransition1.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition1.setCycleCount(2);
        pathTransition1.setAutoReverse(true);

        StrokeTransition strokeTransition1 =
                new StrokeTransition(
                        Duration.millis(1000),
                        Color.RED,
                        Color.BLUEVIOLET);
        strokeTransition1.setCycleCount(8);
        strokeTransition1.setAutoReverse(true);

        ScaleTransition scaleTransition1 =
                new ScaleTransition(Duration.millis(2000));
        scaleTransition1.setByX(1.0f);
        scaleTransition1.setByY(1.0f);
        scaleTransition1.setCycleCount(6);
        scaleTransition1.setAutoReverse(true);

        ParallelTransition parallelTransition1 =
                new ParallelTransition (
                        rect1,
                        pathTransition1,
                        strokeTransition1,
                        scaleTransition1);

        rect1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            parallelTransition1.play();
        });

        Button btn = new Button();




        Stop[] stopsTransparence = new Stop[] {
                new Stop(0, Color.color(0.0, 1.0, 1.0 ,1.0)),
                new Stop(1, Color.color(0.0, 1.0, 1.0 ,0.0))};
        LinearGradient linearGradientTransparence =
                new LinearGradient(0, 0, 1, 0, true,
                        CycleMethod.NO_CYCLE, stopsTransparence);

        Rectangle rect2 = new Rectangle(150, 150, 50, 50);
        rect2.setFill(linearGradientTransparence);
        rect2.setStroke(Color.BLUE);
        rect2.setStrokeWidth(3);

        MoveTo moveTo = new MoveTo();
        moveTo.setX(175f);
        moveTo.setY(175f);

        ArcTo arcTo = new ArcTo();
        arcTo.setX(375f);
        arcTo.setY(175f);
        arcTo.setRadiusX(100f);
        arcTo.setRadiusY(50f);

        Path path2 = new Path();
        path2.getElements().add (moveTo);
        path2.getElements().add (arcTo);

        PathTransition pathTransition2 = new PathTransition();
        pathTransition2.setDuration(Duration.millis(2000));
        pathTransition2.setNode(rect2);
        pathTransition2.setPath(path2);
        pathTransition2.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition2.setCycleCount(2);
        pathTransition2.setAutoReverse(true);

        FillTransition fillTransition2 =
                new FillTransition(Duration.millis(2000),
                        Color.BLUEVIOLET,
                        Color.YELLOW);
        fillTransition2.setCycleCount(2);
        fillTransition2.setAutoReverse(true);

        FadeTransition fadeTransition2
                = new FadeTransition(Duration.millis(2000));
        fadeTransition2.setFromValue(1.0);
        fadeTransition2.setToValue(0.0);
        fadeTransition2.setCycleCount(2);
        fadeTransition2.setAutoReverse(true);

        RotateTransition rotateTransition2 =
                new RotateTransition(Duration.millis(2000));
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(2);
        rotateTransition2.setAutoReverse(true);

        SequentialTransition sequentialTransition2 =
                new SequentialTransition (
                        rect2,
                        pathTransition2,
                        fillTransition2,
                        fadeTransition2,
                        rotateTransition2);

        rect2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            sequentialTransition2.play();
        });

        root.getChildren().addAll(rect1, rect2, btn);

        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
