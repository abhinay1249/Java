enum Status
{
    Running, Failed, Success;

}

public class Enum
{
    public static void main(String a[]) 
    {
        
         Status obj =Status.Failed;
         System.out.println(obj.ordinal());

        Status[] obj1 =Status.values();   //display all the constants
        
        for(Status s: obj1)
        {
            System.out.println(s+" :"+ s.ordinal());
        }

    }
}