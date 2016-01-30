import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Created by 38307220306 on 9.01.2016.
 */

//Koostage Java meetod, mis genereerib parameetrina etteantud n järgi niisuguse n korda n täisarvumaatriksi,
//        mille iga elemendi väärtuseks on minimaalne selle elemendi reaindeksist ja veeruindeksist (indeksid algavad nullist)
//        Write a method in Java to generate an integer matrix of size n x n (n is a parameter of the method)
//        elements of which are calculated by finding a minimum of the row index and the column index of the element (indices start from zero).
public class KT_test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        int[][] res = muster (9);
        //muster(9);
        int a = 9;
        int b = a++ / 5;
        System.out.println(b);
        //String s = String.valueOf(1234);
        //System.out.println(s);

    }

    public static int[][] muster (int n) {
        int[][] vaartus = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    vaartus[i][j] = i;
                } else {
                    vaartus[i][j] = j;
                }
                System.out.print(vaartus[i][j]+" ");
            }
            System.out.println();
        }
        return vaartus;
    }




}
