import java.util.Arrays;

/**
 * Created by 38307220306 on 9.01.2016.
 */
//Sportlase punktisumma arvutatakse üksikkatsetest saadud punktide summana, millest on maha võetud kahe halvima katse tulemused
//        (üksikkatseid on rohkem kui kaks).
//        Kirjutada Java meetod, mis arvutab punktisumma üksikkatsete tulemuste massiivi põhjal.
//        Parameetriks olevat massiivi muuta ei tohi.

public class Answer2 {

    public static void main (String[] args) {
        System.out.println (score (new int[]{4, 1, 2, 3, 0})); // 9
        // Your tests here
    }


    public static int score (int[] points) {
        Arrays.sort(points);
        int sum = 0;
        for (int i = 2; i < points.length; i++) {
            sum += points[i];
        }
        return sum; // TODO!!! Your program here
    }

}
