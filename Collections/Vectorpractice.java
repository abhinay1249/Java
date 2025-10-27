import java.util.*;

public class Vectorpractice{

    public static void main(String[] args){
        
        //Vector Creation
        Vector<String> v1 = new Vector<>();  //Creation of elements in a vector
        v1.add("A");
        v1.add("B");
        v1.add(2,"C");
        System.out.println("Vector 1 is: "+v1);
        
        
        Vector<String> v2= new Vector<>();
        v2.add("D");
        v2.add("E");
        v2.add("F");
        System.out.println("Vector 2 is: "+v2); 

        v1.addAll(3,v2);   //addition of elements in a vector 
        System.out.println("After addition of elements:"+v1);

        System.out.println("Retreiving a number "+v1.get(2));  //retrieval of elements in a vector

        v1.remove("E");
        System.out.println("After removing a specific element"+v1);
        v1.removeAll(v2);
        System.out.println("After removing an entire vector"+v1); //to remove v2 from v1 vector only
        //v1.clear();  to delete an entire vector completely making it empty vector

        System.out.println(v1.contains("A"));   // verfication of elements in a vector
        System.out.println(v1.containsAll(v2));

       v1.set(0,"C");  //updation of elements
       v1.set(1,"A");
       v1.set(2,"B");
       System.out.println(v1);
    }
}