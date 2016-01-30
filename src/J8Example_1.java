/**
 * Created by 38307220306 on 30.01.2016.
 */
import java.util.*;
import java.util.function.*;

/** Iteration.
 * @author Jaanus Poeial
 * @since 1.8
 */
public class J8Example_1 {

    static int sum = 0;  // hack to make sum final for bad examples

    public static void main (String[] args) {

        // find sum of positive elements in the list
        List<Integer> myList = Arrays.asList (1, -1, 0, 2, -4, -5);


        // old way (Java 1)
        sum = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) > 0) {
                sum += myList.get (i);
            }
        }
        System.out.println ("SumPos is: " + sum);


        // little better old way (Java 5)
        sum = 0;
        for (int elem : myList) {
            if (elem > 0) {
                sum += elem;
            }
        }
        System.out.println ("SumPos is: " + sum);


        // Java 8 forEach and anonymous Consumer (ugly)
        sum = 0;
        myList.forEach (new Consumer<Integer>() {
            public void accept (Integer elem) {
                if (elem > 0) {
                    sum += elem;
                }
            }
        });
        System.out.println ("SumPos is: " + sum);


        // Java 8 forEach and lambda expression
        sum = 0;
        myList.forEach (elem -> {
            if (elem > 0) {
                sum += elem;
            }
        });
        System.out.println ("SumPos is: " + sum);


        // Java 8 stream, filter, reduce (with lambda expression) - the best
        sum = myList.stream()
                .filter (elem -> (elem > 0))
                .reduce (0, (s, e) -> s + e);
        System.out.println ("SumPos is: " + sum);

    }
}

