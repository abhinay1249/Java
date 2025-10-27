import java.util.Scanner;
class Reverse_a_String
{
    public static void main(String[] args) 
    {
       Scanner sc= new Scanner(System.in);
       String answer= sc.next();
        
        for(int j=5;j>-1;j--)
        {
           answer+=sc.nextLine();
        }    
        System.out.print(answer);
    }
}