import java.util.*;

public class Priorityqueue {
    public static void main(String[] args) {
        
        Queue<Integer> q= new PriorityQueue<>();            // creation of priority queue

        q.add(20);                      // addition of elemens in the priority queue
        q.add(6);  
        q.offer(5);
        q.offer(6);
        q.add(-1);
        q.add(3);
        q.offer(0);
        q.offer(1);
        
        System.out.println(q);
        //q.clear();                    to clear the complete elements from the priority queue

        System.out.println(q.peek());           // retrieval of elements from the priority queue

        System.out.println(q.poll());           //deletion of elements from the priority queue
        System.out.println(q.poll());
        //System.out.println(q.remove());
        System.out.println(q);

        System.out.println(q.contains(100));        // verification of the presence of elements in the priority queue
 
        System.out.println(q.size());

        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
