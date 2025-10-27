class AbhinayException extends Throwable{
    public AbhinayException(String message){
            super(message);
          
    }
}

public class Customexception{
    public static void main(String a[]){
        int i=10;
        int j=0;
        try{
            if(j==0){
              throw new AbhinayException("Custom exception success");
            }System.out.println(i/j);
        }
        catch(AbhinayException e){
            System.out.println("Exception caught  " +e);
        }
        catch(ArithmeticException ae)
        {
            System.out.println("Arithmetic exception caught");
        }
            
    }
}
