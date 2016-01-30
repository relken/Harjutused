package Rain_test1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by 38307220306 on 11.01.2016.
 */
public class Ball extends Circle {
    public static double dx = 1, dy = 1;

    Ball(double x, double y, double radius, Color color) {
        super(x, y, radius);
        setFill(color); // Set ball color
    }
}
