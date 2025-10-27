import java.util.*;

public class Listiterator {
    public static void main(String[] args) {
        
        LinkedList<Integer> ll= new LinkedList<Integer>();
        ll.add(12);
        ll.add(14);
        ll.add(16);
        ll.add(18);
        ll.add(20);

        ListIterator<Integer> li = ll.listIterator();
        while(li.hasNext()){
            System.out.println(li.next());
        }
        li.add(22);
        System.out.println();
        while(li.hasPrevious()){
            System.out.println(li.previous());
        }
        li.remove();
        System.out.println(ll);

    }
}
