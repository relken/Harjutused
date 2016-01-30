package com.zetcode;

import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main2 extends Application{
    @Override
    public void start(Stage stage) throws Exception
    {
        final Group group = new Group();
        final Scene scene = new Scene(group, 500, 400, Color.GHOSTWHITE);
        stage.setScene(scene);
        stage.setTitle("Animations");
        stage.show();
        final Path path = new Path();
        path.getElements().add(new MoveTo(70,20));
        path.getElements().add(new CubicCurveTo(30, 120, 30, 220, 520, 120));
        path.getElements().add(new CubicCurveTo(350, 20, 250, 240, 320, 240));
        path.setOpacity(0.0);

        group.getChildren().add(path);
        final Reflection reflection = new Reflection();
        reflection.setFraction(1.0);
        final Shape shape = TextBuilder.create()
                .text("javafx").x(20).y(20)
                .font(Font.font(java.awt.Font.SANS_SERIF, 25))
                .effect(reflection)
                .build();

        group.getChildren().add(shape);


        final PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(8.0));
        pathTransition.setDelay(Duration.seconds(.5));
        pathTransition.setPath(path);
        pathTransition.setNode(shape);
        pathTransition.setOrientation(OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);



        final ParallelTransition parallelTransition =
                new ParallelTransition(pathTransition);
        parallelTransition.play();

    }

    public static void main(final String[] arguments)
    {
        Application.launch(arguments);
    }
}
