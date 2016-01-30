package com.zetcode;
        import java.util.function.Supplier;

        import javafx.animation.Animation;
        import javafx.animation.FadeTransition;
        import javafx.animation.Interpolator;
        import javafx.animation.RotateTransition;
        import javafx.animation.ScaleTransition;
        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.input.KeyCode;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;
        import javafx.util.Duration;

public class AnimateNodeIn extends Application {

    private static final int STAGE_WIDTH = 800;
    private static final int STAGE_HEIGHT = 600;

    @Override
    public void start(final Stage primaryStage) {

        final Group root = new Group();
        final Scene scene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT, Color.DARKGRAY);


        scene.setOnMouseClicked(click -> {
            final Button randomButton = new Button("Click me to remove me, yo!");
            randomButton.relocate(Math.random() * STAGE_WIDTH, Math.random() * STAGE_HEIGHT);
            randomButton.setFocusTraversable(false);
            addFadingIn(randomButton, root);
            randomButton.setOnAction(action -> {
                removeFadingOut(randomButton, root);
            });
        });

        scene.setOnKeyPressed(keyPress -> {
            if (keyPress.getCode().equals(KeyCode.ENTER)) {
                final Rectangle rectangle =
                        new Rectangle(Math.random() * 400, Math.random() * 505, Color.rgb(
                                (int) (Math.random() * 255), (int) (Math.random() * 255),
                                (int) (Math.random() * 255)));
                rectangle.relocate(Math.random() * STAGE_WIDTH, Math.random() * STAGE_HEIGHT);
                addAnimating(rectangle, root, () -> {
                    final RotateTransition animation = new RotateTransition(Duration.millis(500), rectangle);
                    animation.setByAngle(Math.random() * 90);
                    return animation;
                });

                rectangle.setOnMouseClicked(click -> {
                    System.out.println(click.isConsumed());
                    click.consume();
                    System.out.println(click.isConsumed());
                    removeAnimating(rectangle, root, () -> {
                        final ScaleTransition scaleTransition =
                                new ScaleTransition(Duration.millis(550), rectangle);
                        scaleTransition.setToX(0);
                        scaleTransition.setToY(0);
                        return scaleTransition;
                    });
                });
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }

    public static void addFadingIn(final Node node, final Group parent) {
        final FadeTransition transition = new FadeTransition(Duration.millis(250), node);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.setInterpolator(Interpolator.EASE_IN);
        parent.getChildren().add(node);
        transition.play();
    }

    public static void removeFadingOut(final Node node, final Group parent) {
        if (parent.getChildren().contains(node)) {
            final FadeTransition transition = new FadeTransition(Duration.millis(250), node);
            transition.setFromValue(node.getOpacity());
            transition.setToValue(0);
            transition.setInterpolator(Interpolator.EASE_BOTH);
            transition.setOnFinished(finishHim -> {
                parent.getChildren().remove(node);
            });
            transition.play();
        }
    }

    public static void addAnimating(final Node node, final Group parent,
                                    final Supplier<Animation> animationCreator) {
        parent.getChildren().add(node);
        animationCreator.get().play();
    }

    public static void removeAnimating(final Node node, final Group parent,
                                       final Supplier<Animation> animationCreator) {
        if (parent.getChildren().contains(node)) {
            final Animation animation = animationCreator.get();
            animation.setOnFinished(finishHim -> {
                parent.getChildren().remove(node);
            });
            animation.play();

        }
    }
}
