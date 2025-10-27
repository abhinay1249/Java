//  WAP to merge two lists into a single list

import java.util.*;

public class Mergelists {
       public static void main(String[] args) {
           LinkedList<Integer> l1= new LinkedList<>();
           l1.add(4);
           l1.add(9);
           l1.add(8); 
           System.out.println("First List is : "+l1);

           Stack<Integer> s1= new Stack<>();
           s1.push(5);
           s1.push(0);
           s1.push(10);

           System.out.println("Second list is: "+s1);

           l1.addAll(3,s1);
           System.out.println("Merged list is: "+l1);
       }    
}
