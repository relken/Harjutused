import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Created by 38307220306 on 12.01.2016.
 */
public class Answer7 {
// Koostage Java meetod, mis genereerib parameetrina etteantud n järgi niisuguse n korda n täisarvumaatriksi,
// mille iga elemendi väärtuseks on selle elemendi reaindeksi ja veeruindeksi summa (indeksid algavad nullist).


    public static void main (String[] args) {
    int[][] res = liitmisTabel(9);

}

    public static int[][] liitmisTabel (int n) {
        int[][] vaartus = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vaartus[i][j] = i+j;
                //System.out.print(vaartus[i][j]+" ");
            }
            //System.out.println();
        }
       // System.out.println(vaartus[5][5]);

        return vaartus; // TODO!!! Your code here
    }


}
