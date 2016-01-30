package com.zetcode;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.Callable;
import java.util.function.Predicate;


/**
 *
 * @author Dub-Laptop
 */
public class CollisionTesting_rain extends Application {

    private TranslateTransition cAnim;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Collision Testing");
        primaryStage.setScene(scene);
        primaryStage.show();

        final Image LENNUK1 = new Image(CollisionTesting_rain.class.getResource("plane6.png").toString());
        final Image LENNUK2 = new Image(CollisionTesting_rain.class.getResource("plane4.png").toString());
        ImageView lennuk1 = new ImageView(LENNUK1);
        ImageView lennuk2 = new ImageView(LENNUK2);

        lennuk1.setLayoutX(10);
        lennuk1.setLayoutY(200);
        lennuk2.setLayoutX(800);
        lennuk2.setLayoutY(200);


        Rectangle r = new Rectangle(100, 50, Color.AQUA);
        r.setLayoutX(10);
        r.setLayoutY(200);

        Circle c = new Circle(50, Color.GREEN);
        c.setLayoutX(800);
        c.setLayoutY(200);

        /* can change this to anything you like
           I used translateXProperty for simplicity
        */
//        c.translateXProperty().addListener((Observable observable) -> {
//            c.checkCollision(c, r);
//        });

        root.getChildren().addAll(lennuk1, lennuk2);

        TranslateTransition rAnim = new TranslateTransition();

        rAnim.setToX(600);
        rAnim.setAutoReverse(true);
        rAnim.setCycleCount(Animation.INDEFINITE);
        rAnim.setDuration(Duration.seconds(15));
        rAnim.setNode(lennuk1);

        cAnim = new TranslateTransition();

        cAnim.setToX(-590);
        cAnim.setAutoReverse(true);
        cAnim.setCycleCount(Animation.INDEFINITE);
        cAnim.setDuration(Duration.seconds(15));
        cAnim.setNode(lennuk2);

        rAnim.play();
        cAnim.play();

        collision(lennuk1, lennuk2);
    }




        public void collision(ImageView lennuk1, ImageView lennuk2) {
            ObservableBooleanValue colliding = Bindings.createBooleanBinding(new Callable<Boolean>() {

                @Override
                public Boolean call() throws Exception {
                    return lennuk1.getBoundsInParent().intersects(lennuk2.getBoundsInParent());
                }

            }, lennuk1.boundsInParentProperty(), lennuk2.boundsInParentProperty());

            colliding.addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> obs,
                                    Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        System.out.println("Colliding");
                    }
                }
            });
        }



    private void checkCollisions() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

//    private class CollidableCircle extends Circle implements Collidable {
//
//        public CollidableCircle(double radius, Paint fill, Group root) {
//            super(radius, fill);
//            new AnimationTimer() {
//                @Override
//                public void handle(long now) {
//                    root.getChildren().filtered((Node n) -> {
//                        return !n.equals(CollidableCircle.this) && n instanceof Shape;
//                    }).forEach(other -> {
//                        checkCollision(CollidableCircle.this, (Shape) other);
//                    });
//                }
//            }.start();
//            // I added this for local property changes to this node
//            collisionStateProperty().addListener((ObservableValue<? extends CollisionState> observable, CollisionState oldValue, CollisionState newValue) -> {
//                if (newValue.equals(CollisionState.TOUCHING)) {
//                    setScaleX(1.25);
//                    setScaleY(1.25);
//                    setFill(Color.GREENYELLOW);
//                    cAnim.pause();
//                } else if (newValue.equals(CollisionState.WAITING)) {
//                    setScaleX(1.0);
//                    setScaleY(1.0);
//                    setFill(Color.GREEN);
//                    cAnim.play();
//                }
//            });
//        }
//
//        @Override
//        public void handleCollision(Shape other) {
//            // handle updates that affect other node here
//            System.out.println("Collided with : " + other.getClass().getSimpleName());
//        }
//
//    }
}
