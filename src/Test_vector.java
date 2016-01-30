import java.util.HashSet;
import java.util.Vector;

/**
 * Created by 38307220306 on 30.01.2016.
 */
class Test_vector
{
    public static void main(String [] args) throws Exception
    {
        Vector data = new Vector();
        data.add("apple");
        data.add("mango");
        data.add("papaya");
        data.add("cherry");
        data.add("banana");
        data.add("apple");
        System.out.println(getData(data));
    }
    public static Vector getData(Vector v)
    {
        return new Vector(new HashSet(v));
    }
}
