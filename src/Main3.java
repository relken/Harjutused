package com.zetcode;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 900, 900));

        Rectangle rect = new Rectangle(50, 50, 40, 40);

        // comment movePivot to get the default rotation
        movePivot(rect, -20, -20);

        RotateTransition rt = new RotateTransition(Duration.seconds(4),rect);
        rt.setToAngle(720);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setAutoReverse(true);
        rt.play();

        primaryStage.show();
    }

    // this is the function you want
    private void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

