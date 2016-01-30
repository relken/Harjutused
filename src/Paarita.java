import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 38307220306 on 30.01.2016.
 */
public class Paarita {

    public static void main (String[] args) {
        String[] poisid = new String[] {"Juku", "Kalle", "Oskar"};
        String[] tydrukud = new String[] {"Mari", "Liisi", "Kertu"};
        String[] vastus = paarita (poisid, tydrukud);
        for (int i=0; i < vastus.length; i++) {
            System.out.println (vastus[i]);
        } // for
    } // main

    public static String[] paarita (String[] p, String[] t) {
        List<String> tydList = Arrays.asList (t);
        Collections.shuffle (tydList);
        if (p.length > t.length)
            throw new RuntimeException ("Liiga v2he tydrukuid");
        String[] tulem = new String [p.length];
        for (int i=0; i < p.length; i++) {
            tulem[i] = p[i] + "+" + tydList.get(i);
        } // for
        return tulem;
    } // paarita

} // Paarid
