public class Exception{
    public static void main(String[] args) {
        
    System.err.println("Start");                      //** Stack trace**//
        int a =10;                                    // Exception name -  java.lang.ArithmeticException
        int b = 0;                                    // Exception message - / by zero
        int c = a/b;                                  // which line number - (Exception.java:7)
    System.out.println(c);                            // method - at Exception.main
    System.out.println("End");
    }
}