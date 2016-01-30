import java.util.Arrays;

/**
 * Created by 38307220306 on 12.01.2016.
 */
public class Answer6 {
//Koostage Java meetod etteantud täisarvumaatriksi m veerumiinimumide massiivi leidmiseks
// (massiivi j-ndaks elemendiks on maatriksi j-nda veeru vähima elemendi väärtus).
// Arvestage, et m read võivad olla erineva pikkusega.


    public static void main (String[] args) {
        int[] res = veeruMinid (new int[][] { {1,2,6}, {4,5,3} }); // {1, 2, 3}
        // YOUR TESTS HERE
    }

    public static int[] veeruMinid (int[][] m) {
        int result[] = new int[m[0].length];
        for (int i = 0; i < m[0].length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m.length; j++) {
                if(min>m[j][i]) {
                    min = m[j][i];
                }
                System.out.println(m[j][i]);
            }
            result[i] = min;
        }
        System.out.println(Arrays.toString(result));
        // TODO!!!    YOUR PROGRAM HERE
        return result;
    }

}
