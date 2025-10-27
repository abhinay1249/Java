//Abstract and Anonymous inner class

abstract class Abstract
{
    public abstract void display();
    public abstract void show();
}

public class aanda_class
{
    public static void main(String[] args) 
    {
        Abstract obj = new Abstract()
        {
            public void display()
            {
                System.out.println("in display");
            }
           public void show()
            {
                System.out.println("in show");
            }
        };
            obj.show();
            obj.display();
    }
}
