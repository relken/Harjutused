import java.util.Arrays;

/**
 * Created by 38307220306 on 9.01.2016.
 */
//Koostage Java meetod etteantud täisarvumaatriksi m veerusummade massiivi leidmiseks
//        (massiivi j-s element on maatriksi j-nda veeru summa). Arvestage, et m read võivad olla erineva pikkusega.
//        Write a method in Java to find the array of sums of columns of a given matrix of integers m
//        (j-th element of the answer is the sum of elements of the j-th column in the matrix). Rows of m might be of different length.

public class Answer3 {

    public static void main(String[] args) {
        int[][] massiiv = new int[][] { {1,2,3},
                                        {4,5,6} };

        int[] res = veeruSummad (massiiv); // {5, 7, 9}
        int[] res2 = reaSummad (massiiv); // {5, 7, 9}
        // YOUR TESTS HERE
    }


    public static int[] veeruSummad(int[][] m) {
        int sum[] = new int[m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                sum[j] += m[i][j];
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(sum));

        // TODO!!!    YOUR PROGRAM HERE
        return sum;
    }

    public static int[] reaSummad(int[][] m) {
        int sum[] = new int[m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                sum[i] += m[i][j];
                System.out.print(m[i][j]+" ");
                if (j == m[0].length-1) {
                    System.out.println("Reasumma on: " +sum[i]);
                }
            }
            //System.out.println();
        }
        System.out.println(Arrays.toString(sum));

        // TODO!!!    YOUR PROGRAM HERE
        return sum;
    }

}
