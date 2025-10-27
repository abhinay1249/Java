import java.util.*;

public class Linkedlistinqueue {
    public static void main(String[] args) {
        
        Deque<String> llq= new LinkedList<>();               //creating a linkedlist object//
        llq.add("Nike");                           // additional method to add element in the llq
        llq.addLast("Puma");
        llq.addFirst("Skechers");
        llq.add("New Balance");
        llq.add("UA");
        llq.offer("Asics");
        llq.add("Adidas");
        llq.add("Redtape");
        llq.offerLast(null);
        llq.offer(null);

        System.out.println(llq);

        System.out.println(llq.peek());      // retrieval of element in the llq
        System.out.println(llq.peekFirst());
        
        System.out.println(llq.contains("UA"));   // verification of element in the llq

        llq.pollLast();                              //deletion of element in the llq
        System.out.println(llq);     

        System.out.println(llq.size());
    }
    
}
