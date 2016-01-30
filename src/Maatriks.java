/**
 * Created by 38307220306 on 30.01.2016.
 */
public class Maatriks {

    /** Peameetod muude testimiseks.  */
    public static void main (String[] a) {
        Maatriks m1 = new Maatriks (new int [][] { {4, 9, 2}, {0, 7, 4} } );
        Maatriks m2 = new Maatriks (3, 4);
        m2.set (0, 0, 1);
        m2.set (1, 1, 1);
        m2.set (2, 2, 1);
        Maatriks m3 = null;
        System.out.println (m1);
        System.out.println (m2);
        System.out.println (m1.korda (m2));
        try {
            m3 = (Maatriks)m1.clone();
        } catch (CloneNotSupportedException e) {};
        m1.set (0, 0, 1);
        System.out.println (m1.pluss (m3));

        // v6rdsuse ja identsuse testid
        Maatriks p1 = new Maatriks (new int[][]{ {1, 2}, {3, 4}});
        Maatriks p2 = p1;
        System.out.println (p2.equals (p1));          // true
        System.out.println (p2 == p1);                // true
        p2.set (0, 0, 7);
        System.out.println (p2.equals (p1));          // true
        System.out.println (p2 == p1);                // true
        try {
            p2 = (Maatriks)p1.clone();
        } catch (CloneNotSupportedException e) {};
        System.out.println (p2.equals (p1));          // true
        System.out.println (p2 == p1);                // false
        p2.set (0, 0, 5);
        System.out.println (p2.equals (p1));          // false
        System.out.println (p2 == p1);                // false

    } // main

    /** maatriksi sisu */
    private int[][] massiiv;

    /** Nullmaatriksi konstruktor.  */
    Maatriks (int ridu, int veerge) {
        if (ridu<1)
            massiiv = null;
        else if (veerge<1)
            massiiv = null;
        else {
            // m2lu eraldamine
            massiiv = new int [ridu] [veerge];
            // massiivi nullimine
            for (int i=0; i<massiiv.length; i++) {
                for (int j=0; j<massiiv[i].length; j++) {
                    massiiv [i][j] = 0;
                }
            }
        } // else
    } // konstruktor

    /** Maatriksi konstruktor etteantud massiivist. */
    Maatriks (int[][] mat) {
        if (mat == null)
            massiiv = null;
        else if (mat.length<1)
            massiiv = null;
        else if (mat[0].length<1)
            massiiv = null;
        else {
            massiiv = new int [mat.length][mat[0].length];
            for (int i=0; i<mat.length; i++) {
                for (int j=0; j<mat[0].length; j++) {
                    massiiv [i][j] = mat [i][j];
                }
            }
        } // else
    }

    /** Elemendi kirjutamine maatriksisse. */
    public int set (int i, int j, int element) {
        int res = massiiv [i][j];
        massiiv [i][j] = element;
        return res;
    } // set

    /** Elemendi lugemine maatriksist. */
    public int get (int i, int j) {
        return massiiv [i][j];
    } // get

    /** Teisendus s6neks. */
    public String toString() {
        StringBuffer res = new StringBuffer();
        String nl = System.getProperty ("line.separator");
        for (int i=0; i<massiiv.length; i++) {
            for (int j=0; j<massiiv[0].length; j++) {
                res.append (String.valueOf (massiiv [i][j]) + "\t");
            }
            res.append (nl);
        }
        return res.toString();
    } // toString

    /** Koopia loomine. */
    public Object clone() throws CloneNotSupportedException {
        return new Maatriks (massiiv);
    } // clone

    /** Kahe maatriksi v6rdsuse tuvastamine. */
    public boolean equals (Object o) {
        if (o == null)
            return false;
        int[][] om = ((Maatriks)o).massiiv;
        if (massiiv.length != om.length)
            return false;
        for (int i=0; i<massiiv.length; i++) {
            if (massiiv[i].length != om[i].length)
                return false;
            for (int j=0; j<massiiv[i].length; j++) {
                if (massiiv [i][j] != om[i][j])
                    return false;
            }
        }
        return true;
    } // equals

    /** Maatriksite korrutamine. */
    public Maatriks korda (Maatriks mat) {
        if (mat == null)
            return null;
        if (massiiv[0].length != mat.massiiv.length)
            throw new RuntimeException ("valed m66tmed korrutamisel");
        Maatriks res = new Maatriks (massiiv.length, mat.massiiv[0].length);
        for (int i=0; i<massiiv.length; i++) {
            for (int j=0; j<mat.massiiv[0].length; j++) {
                res.massiiv [i][j] = 0;
                for (int k=0; k<mat.massiiv.length; k++) {
                    res.massiiv [i][j] += massiiv [i][k]*mat.massiiv [k][j];
                }
            }
        }
        return res;
    } // korda

    /** Maatriksite liitmine (vajadusel t2iendatud nullidega). */
    public Maatriks pluss (Maatriks mat) {
        if (mat == null)
            return new Maatriks (massiiv);
        Maatriks res = new Maatriks
                (Math.max (massiiv.length, mat.massiiv.length),
                        Math.max (massiiv[0].length, mat.massiiv[0].length));
        for (int i=0; i<massiiv.length; i++) {
            for (int j=0; j<massiiv[i].length; j++) {
                res.massiiv [i][j] = massiiv [i][j];
            }
        }
        for (int i=0; i<mat.massiiv.length; i++) {
            for (int j=0; j<mat.massiiv[i].length; j++) {
                res.massiiv [i][j] += mat.massiiv [i][j];
            }
        }
        return res;
    } // pluss

} // Maatriks
