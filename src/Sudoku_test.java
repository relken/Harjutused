import java.util.*;

/**
 * Created by 38307220306 on 28.01.2016.
 */
public class Sudoku_test
{
    public static Map<String, Integer> pseudoCounter = new HashMap<>();

    public static void main(String[] args)
    {
        String[] letters = new String[]{"a","b","d","e","f","g","h","i","j","k","l","m","n","o","p","r","s","š","z","ž","t","u","v","õ","ä","ö","ü"};
        //String[] letters = new String[]{"a","b","d","e","f","g","h","i","j"};

        // initialization of pseudoCounter
        for (int r = 0; r < letters.length; r++) {
            pseudoCounter.put(letters[r], letters.length);
        }

        String[][] result = new String[letters.length][letters.length];

        OUTER: for (int i = 0; i < letters.length; i++)
        {
            for (int j = 0; j < letters.length; j++) {
                String[] possibleValues = getPossibleValues(j, i, result, letters);
                if (possibleValues.length > 0) {
                    result[i][j] = getRandomFromArray(possibleValues);
                } else {
                    //System.out.println("Could not generate the matrix, please try again");
                    result = new String[letters.length][letters.length];
                    for (int r = 0; r < letters.length; r++) {
                        pseudoCounter.put(letters[r], letters.length);
                    }
                    i = -1;
                    continue OUTER;
                }
            }

        }

        System.out.println("Sudoku");
        for (int m = 0; m < result.length; m++) {
            for (int p = 0; p < result[m].length; p++) {
                System.out.print(result[m][p] + " ");
            }
            System.out.println();
        }

        System.out.println("PseudoSet usage");
        for (int m = 0; m < letters.length; m++) {
            System.out.println(letters[m] + ": " + pseudoCounter.get(letters[m]));
        }

    }

    public static String[] getPossibleValues (int x, int y, String[][] result, String[] letters)
    {
        // getting x axis array from result matrix
        String[] arrayX = new String[x];
        for (int i = 0; i < x; i++) {
            arrayX[i] = result[y][i];
        }

        // getting y axis array from result matrix
        String[] arrayY = new String[y];
        for (int j = 0; j < y; j++) {
            arrayY[j] = result[j][x];
        }

        // converting from arrays to sets
        Set<String> set  = new HashSet<>(Arrays.asList(letters));
        Set<String> setX = new HashSet<>(Arrays.asList(arrayX));
        Set<String> setY = new HashSet<>(Arrays.asList(arrayY));

        // finding difference
        set.removeAll(setX);
        set.removeAll(setY);

        //
        Set<String> pseudoSet = new HashSet<>();
        for (int g = 0; g < pseudoCounter.size(); g++) {
            if (pseudoCounter.get(letters[g]) > pseudoCounter.size() - y) {
                //System.out.println("Adding to pseudoSet: "+letters[g]);
                pseudoSet.add(letters[g]);
            }
        }

        //pseudoSet.removeAll(set);
        set.addAll(pseudoSet);

        // converting result set back to array
        String[] possibleValues = new String[set.size()];
        possibleValues = set.toArray(possibleValues);

        //System.out.println("x: "+x+"; y: "+y);
        //for (int p = 0; p < possibleValues.length; p++) {
        //    System.out.print(possibleValues[p]+" ");
        //}
        //System.out.println();

        return possibleValues;
    }

    public static String getRandomFromArray(String[] arr)
    {
        //System.out.println("Length: "+arr.length);

        Random random = new Random();
        int index = random.nextInt(arr.length);

        // updating pseudoCounter value
        pseudoCounter.put(arr[index], pseudoCounter.get(arr[index]) - 1);
        return arr[index];
    }
}
