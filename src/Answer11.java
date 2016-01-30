/**
 * Created by 38307220306 on 12.01.2016.
 */
public class Answer11 {
//Koostage Java meetod, mis genereerib parameetrina etteantud n järgi n korda n täisarvumaatriksi,
// mille peadiagonaalil on ühed ning kõik ülejäänud elemendid on nullid.

    public static void main(String[] args) {
        int[][] res = yhik(9);
    }

    public static int[][] yhik(int n) {
        int[][] vaartus = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) {
                    vaartus[i][j] =1;
                } else {vaartus[i][j] = 0;}
                System.out.print(vaartus[i][j]+" ");
            }
            System.out.println();
        }
        // System.out.println(vaartus[5][5]);

        return vaartus; // TODO!!! Your code here
    }
}
