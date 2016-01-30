import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 38307220306 on 30.01.2016.
 */
public class J8Example_2 {

    public static void main (String[] args) {

        List<Integer> myList = Arrays.asList (1, 0, 2, 3, -1);
        myList.forEach (System.out::println);  // Java 8 simple pass through

        // multply each element of the list by 2 and find the first element
        //    that is bigger than 3 (null, if there is no such element)
        System.out.println ("This element is: "
                + myList.stream()
                .map(e->e*2)
                .filter(e->(e>3))
                .findFirst()
                .orElse (null) );

        // old style comparator (Java 2)
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare (Integer n1, Integer n2) {
                return (n1>n2?1:(n1<n2?-1:0));
            }
        };
        Collections.sort (myList, cmp);
        System.out.println (myList);
        Collections.shuffle (myList);
        System.out.println (myList);

        // Java 8 comparator as lambda expression
        Collections.sort (myList, (n1, n2) -> n1>n2?1:(n1<n2?-1:0));
        System.out.println (myList);

    }
}
