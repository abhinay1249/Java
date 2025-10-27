public class Exception_throw
{
    public static void main(String[] args) throws ArithmeticException
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
          throw new ArithmeticException("divide by zero error");   // or can be used in this way -> 
        }            // after executing the above syntax the exception message is printed which is defined by the user
        finally
        {
            System.out.println("Finally exectued");
        }
        System.out.println(c);
        System.out.println("end");
    }
}