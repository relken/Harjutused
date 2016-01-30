import javafx.scene.shape.Circle;

/**
 * Created by 38307220306 on 29.01.2016.
 */
public class Pall extends Circle {
    private Integer id, x, y;
    private Integer raadius;
    static int JUHUSLIK(int max, int min){ return ((int) (Math.random()*(max - min))) + min; }
    Pall() {
        raadius = JUHUSLIK(60, 10);
        setRadius(raadius);
        setLayoutX(JUHUSLIK(1000, 100));
        setLayoutY(JUHUSLIK(700, 200));
        id = JUHUSLIK(65, 10);
    }
    public int getNumber() {
        return id;
    }
    public int getRaadius() {
        raadius = (int) getRadius();
        return raadius;
    }

}
