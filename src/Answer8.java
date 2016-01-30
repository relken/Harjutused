/**
 * Created by 38307220306 on 12.01.2016.
 */
public class Answer8 {
//Koostada Java meetod, mis asendab parameetrina etteantud sõnes s kõik tähed märgiga 'x'.
//Lahendus peab kasutama tsüklit.
    public static void main (String[] args) {
        String s = "Tere, TUDENG, 1234!";
        String t = asenda (s); // "xxxx, xxxxxx, 1234!"
        System.out.println (s + " > " + t);
    }

    public static String asenda (String s) {
        char[] charArray = s.toCharArray();
        for(int i = 0; i<s.length(); i ++) {
            if (Character.isLetter(charArray[i])) {
                charArray[i] = 'x';}
        }
        s = String.valueOf(charArray);
        return s; // TODO!!! Your code here
    }

}
