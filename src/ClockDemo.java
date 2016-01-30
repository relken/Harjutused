package com.zetcode;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.util.Date;

public class ClockDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Label label = new Label(new Date().toString());
        label.setFont(new Font("Arial", 18));
        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label.setText(new Date().toString());
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        Button button = new Button("Start");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timeline.play();
            }
        });

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                timeline.stop();
            }
        });
        HBox hBox = HBoxBuilder.create()
                .spacing(5.0)
                .padding(new Insets(5, 5, 5, 5))
                .children(label, button)
                .build();

        Scene scene = new Scene(hBox, 330, 30);
        stage.setScene(scene);
        stage.setTitle("Clock demo");
        stage.show();
    }
}
