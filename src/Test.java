/**
 * Created by 38307220306 on 30.01.2016.
 */
class A
{
    public int GetResult(int a, int b) { return 0; }
}
class B extends A
{
    public int GetResult(int a, int b) {return 1; }
}

public class Test
{
    public static void main(String args[])
    {
        B b = new B();
        System.out.println("x = " + b.GetResult(0, 1));
    }
}
