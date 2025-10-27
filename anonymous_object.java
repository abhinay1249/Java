class demo
{
    public demo()
    {
        System.out.println("in constructor");
    }
}

public class anonymous_object
{
    public static void main(String[] args) 
    {
       new demo();      //anonymous object created without a reference variable
    }
}