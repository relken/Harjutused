import java.util.*;

/**
 * Created by 38307220306 on 30.01.2016.
 */
public class Collexample {

    /**
     * Main method.
     * @param parameters command line parameters.
     */
    public static void main (String[] parameters) {

        final int SIZE = 100;
        ArrayList randomNumbers = new ArrayList (SIZE);
        Random generator = new Random();
        for (int i=0; i < SIZE; i++) {
            randomNumbers.add (new Integer (generator.nextInt(1000)));
        }
        System.out.println (maximum (randomNumbers));

        HashMap courses = new HashMap();
        courses.put ("I200", "Java");
        courses.put ("I209", "Algorithms");
        courses.put ("K402", "Programming II");
        courses.put ("K022", "Applications: Internet");

        Iterator codes = courses.keySet().iterator();
        while (codes.hasNext()) {
            System.out.println (codes.next());
        }

        String course = (String)courses.remove ("K022");
        System.out.println (course);

        codes = courses.keySet().iterator();
        String code;
        while (codes.hasNext()) {
            code = (String)codes.next();
            System.out.println (code + " " + (String)courses.get (code));
        }

        System.out.println (randomNumbers);
        Object tmp;
        for (int i=0; i < randomNumbers.size()/2; i++) {
            tmp = randomNumbers.get (i);
            randomNumbers.set (i, randomNumbers.get (randomNumbers.size()-i-1));
            randomNumbers.set (randomNumbers.size()-i-1, tmp);
        }
        System.out.println (randomNumbers);

        System.out.println (maximum2 (randomNumbers));

    } // main

    /**
     * Finding a maximal element of a list.
     * @param a list
     * (satisfies interface java.util.List,
     * elements satisfy interface Comparable).
     * @return maximal element.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    static public Comparable maximum (List a) {
        Comparable maxelem;
        if (a == null)
            throw new IndexOutOfBoundsException (" maximum got a null list");
        if (a.size() < 1)
            throw new IndexOutOfBoundsException (" maximum got an empty list");
        maxelem = (Comparable)a.get (0);
        for (int i=0; i < a.size(); i++) {
            if (maxelem.compareTo ((Comparable)a.get (i)) < 0)
                maxelem = (Comparable)a.get (i);
        }
        return maxelem;
    } // maximum

    /**
     * Finding a maximal element of a collection.
     * @param a Collection, elements satisfy interface Comparable.
     * @return maximal element.
     * @throws NoSuchElementException if <code> a </code> is empty.
     */
    static public Comparable maximum2 (Collection a) {
        Comparable maxelem;
        if (a == null)
            throw new IndexOutOfBoundsException (" maximum2 got a null collection");
        Iterator iter = a.iterator();
        if (iter.hasNext())
            maxelem = (Comparable)iter.next();
        else throw new NoSuchElementException (" maximum2 got an empty collection");
        Comparable c;
        while (iter.hasNext()) {
            c = (Comparable)iter.next();
            if (maxelem.compareTo (c)<0)
                maxelem = c;
        }
        return maxelem;
    } // maximum2

} // Collexample
