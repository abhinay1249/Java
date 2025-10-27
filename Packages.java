//import java.util.*; importing the in built packages
import tools.*;

public class Packages
{
    public static void main(String[] args) 
    {
       // ArrayList n=new ArrayList();   When using in built functions the import statement has to be mentioned
        Calc obj=new Calc();
        Advcalc obj1=new Advcalc();
        int r=obj.add(20,25);
        int s=obj1.div(24,6);
        System.out.println(r);
        System.out.println(s);
    }
}