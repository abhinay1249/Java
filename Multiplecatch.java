public class Multiplecatch{
    public static void main(String[] args){
        
        int arr[]={1,2};
        

        try{
            System.out.println(arr[1]/0);
            System.out.println(arr[2]);
        }
        catch(ArrayIndexOutOfBoundsException ai)
        {
            System.err.println("Out of Index");
        }
        catch(ArithmeticException ae)
        {
            System.err.println("no zero");
        }
    }
}