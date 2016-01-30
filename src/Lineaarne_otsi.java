/**
 * Created by 38307220306 on 30.01.2016.
 */
public class Lineaarne_otsi {

    public static void main (String[] sss) {
        int [] bbb = new int[] {1, 5, 8, 9};
        System.out.println (otsi (bbb, 8));
    } // main

    public static int otsi (int[] a, int otsitav) {
        int tulemus = -1;
        for (int i=0; i<a.length; i++) {
            if (otsitav == a[i]) {
                tulemus = i;
                System.out.println("Leitud");
                break;
            }
        }
        return tulemus;
    } // otsi

} // Lineaarne
