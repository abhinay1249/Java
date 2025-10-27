package tools;
                                       


class Launch
{
    public void abc()
    {
        B obj=new B();
        System.out.println(obj.marks);
    }
}




public class B         // access modifier termed protected
{
    protected int marks=50;
    public void show()
    {
          System.out.println(marks);
    }
}