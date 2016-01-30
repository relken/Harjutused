/**
 * Created by 38307220306 on 30.01.2016.
 */
import java.util.*;

public class Tagurpidi {

    public static void main (String[] args) {
        String tekst = "";
        if (args.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String sona: args) {
                sb.append (sona);
                sb.append (" ");
            }
            tekst = sb.toString();
        } else {
            tekst = "aias sadas saia aga leiba mitte";
        }
        System.out.println (tekst);
        System.out.println (tagurpidi (tekst));
        reverseStringByWords("aias sadas saia aga leiba mitte");
    }

    public static String tagurpidi (String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer (s);
        while (stk.hasMoreTokens()) {
            String w = stk.nextToken();
            sb.append (new StringBuilder(w).reverse());
            sb.append (" ");
        }
        return sb.toString();
    }

    public static void reverseStringByWords(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = string.split(" ");

        for (int j = words.length-1; j >= 0; j--) {
            stringBuilder.append(words[j]).append(' ');
        }
        System.out.println("Reverse words: " + stringBuilder);
    }


}

