public class Exception_handling
{
    public static void main(String[] args) 
    {
        int a=1000;
        int b=0;
        int c=0;

        try
        {
            c=a/b;
        }
        catch(ArithmeticException e)
        {
          System.out.println(e.toString());
        }
        finally
        {
            System.out.println("Finally exectued");
        }
        System.out.println(c);
        System.out.println("end");
    }
}
