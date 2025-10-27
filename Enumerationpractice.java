import java.util.*;

public class Enumerationpractice {
    
    public static void main(String[] args) {
        
        Vector<Integer> v= new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);

        Enumeration<Integer> e= v.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

        Hashtable<Integer, String> ht= new Hashtable<>();
        ht.put(101,"Abhinay");            
        ht.put(102,"Varshini");
        ht.put(103,"Bharath");
        ht.put(104,"Pranav");
        ht.put(105,"Vamshi");
        ht.put(106,"Sandeep");

        Enumeration<String> en= ht.elements();
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        
        }
    }
}
