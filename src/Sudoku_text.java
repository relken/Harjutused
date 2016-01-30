import java.util.Arrays;
import java.util.Collections;

/**
 * Created by 38307220306 on 29.01.2016.
 */
public class Sudoku_text {

    public static void main(String[] args) {
        String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "S", "z", "Z", "t", "u", "v", "O", "A", "Y"};
        Collections.shuffle(Arrays.asList(alphabet));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            stringBuilder.append(alphabet[i]);
        }
        System.out.println(stringBuilder.charAt(0));
        System.out.println(stringBuilder);
        char temp;
        char[][] sudoku = new char[27][27];
        for (int i = 0; i < 27; i++) {
            temp = stringBuilder.charAt(0);

            stringBuilder.deleteCharAt(0);
            stringBuilder.append(temp);
            for (int j = 0; j < 27; j++) {
                sudoku[i][j] = stringBuilder.charAt(j);
                System.out.print("\t"+sudoku[i][j]);
            }
            System.out.println();
        }
    }
}
