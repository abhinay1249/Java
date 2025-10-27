import java.util.*;

public class Arraydequeue {
    public static void main(String[] args) {
        
        Deque<String> aq= new ArrayDeque<>();               //creating a deque object//
        aq.add("Banana");                           // additional method to add element in the arraydeque
        aq.addLast("Cherry");
        aq.addFirst("Apple");
        aq.add("Kiwi");
        aq.add("Melon");
        aq.offer("Mango");
        aq.add("Sitaphal");
        aq.add("Mango");

        System.out.println(aq);

        System.out.println(aq.peekLast());      // retrieval of element in the arraydeque
        System.out.println(aq.peekFirst());
        
        System.out.println(aq.contains("Berry"));   // verification of element in the arraydeque

        aq.pollLast();                              //deletion of element in the arraydeque
        System.out.println(aq);     

        System.out.println(aq.size());
    }
    
}
