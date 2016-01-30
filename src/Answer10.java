/**
 * Created by 38307220306 on 12.01.2016.
 */
public class Answer10 {
    //Koostada Java meetod, mis asendab parameetrina etteantud sõnes s kõik väiketähed märgiga '-'.
   // Lahendus peab kasutama tsüklit.
    public static void main (String[] args) {
        String s = "Tere, TUDENG, tore ARVUTI sul!";
        String t = asenda (s); // "T---, TUDENG, ---- ARVUTI ---!"
        System.out.println (s + " > " + t);
    }

    public static String asenda (String s) {
        char[] charArray = s.toCharArray();
        for(int i = 0; i<s.length(); i ++) {
            if (Character.isLowerCase(charArray[i])) {
                charArray[i] = '-';}
        }
        s = String.valueOf(charArray);
        return s; // TODO!!! Your code here
    }

}
