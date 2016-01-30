import java.util.Arrays;

/**
 * Created by 38307220306 on 12.01.2016.
 */
public class Answer5 {
//Sportlase esinemist hindab n>2 kohtunikku. Hinnete hulgast eemaldatakse kõige madalam ja kõige kõrgem ning leitakse ülejäänud n-2 hinde aritmeetiline keskmine.
//Kirjutada Java-meetod hinde arvutamiseks.
//Parameetriks olevat massiivi muuta ei tohi.
    public static void main (String[] args) {
     System.out.println (result (new double[]{0., 1., 2., 3., 4.}));
    // YOUR TESTS HERE
}

     public static double result (double[] marks) {
         Arrays.sort(marks);
         double sum = 0;
         for (int i = 1; i < marks.length-1; i++) {
             sum += marks[i];
         }
         return sum/(marks.length-2); // TODO!!! Your program here

        //return 0;  // TODO!!! YOUR PROGRAM HERE
    }

}

