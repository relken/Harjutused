/**
 * Created by 38307220306 on 9.01.2016.
 */
public class Answer {

    public static void main (String[] args) {
        String s = "Tere, 1234 ja 5678";
        String t = asenda (s); // "Tere, #### ja ####"
        System.out.println (s + " --> " + t);
    }

    public static String asenda (String s) {
        char[] charArray = s.toCharArray();
        for(int i = 0; i<s.length(); i ++) {
            if (Character.isDigit(charArray[i])) {
                charArray[i] = '#';}
            }
        s = String.valueOf(charArray);
        return s; // TODO!!! Your code here
    }


}
