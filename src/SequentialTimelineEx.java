package com.zetcode;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * ZetCode JavaFX tutorial
 *
 * This program creates a sequential Timeline
 * animation.
 *
 * Author: Jan Bodnar
 * Website: zetcode.com
 * Last modified: June 2015
 */

public class SequentialTimelineEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        Pane root = new Pane();

        Circle c = new Circle(50, 100, 10);
        c.setFill(Color.CADETBLUE);

        KeyValue kv1 = new KeyValue(c.scaleXProperty(), 4);
        KeyValue kv2 = new KeyValue(c.scaleYProperty(), 4);
        KeyFrame kf1 = new KeyFrame(Duration.millis(3000), kv1, kv2);

        Timeline scale = new Timeline();
        scale.getKeyFrames().add(kf1);

        KeyValue kv3 = new KeyValue(c.centerXProperty(), 250);
        KeyFrame kf2 = new KeyFrame(Duration.millis(5000), kv3);

        Timeline move = new Timeline();
        move.getKeyFrames().add(kf2);

        KeyValue kv4 = new KeyValue(c.scaleXProperty(), 1);
        KeyValue kv5 = new KeyValue(c.scaleYProperty(), 1);
        KeyFrame kf3 = new KeyFrame(Duration.millis(3000), kv4, kv5);

        Timeline scale2 = new Timeline();
        scale2.getKeyFrames().add(kf3);

        SequentialTransition seqtr = new SequentialTransition(scale,
                move, scale2);
        seqtr.play();

        root.getChildren().add(c);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Sequential Timeline animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
