class A
{
    public void statement()
    {
        System.out.println("In A");
    }
}

class B extends A
{ 
    @Override
    public void statement()
    {
        System.out.println("In B");
    }
}

public class Annotation
{
    public static void main(String[] args)
    {
        B a =new B();
        a.statement();
    }
}