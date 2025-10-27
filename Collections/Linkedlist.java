import java.util.*;

public class Linkedlist {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("23");
        arr.add("43");

        LinkedList<String> ll= new LinkedList<>();  //creation of linkedlist size=0
            ll.add("X1");   //addition of nodes   size=1
            ll.add("X2");                         //size=2
            ll.add("X3");                          //size=3
            ll.add("X4");                          //size=4
            ll.add(4,"X5");                          //size=5
           
            ll.addAll(arr);
            System.out.println(ll);

            System.out.println(ll.get(2)); //retrieval of nodes

            System.out.println(ll.contains("X5")); //verification of nodes
            System.out.println(ll.containsAll(arr));

            ll.remove();         //remove the first node from the linked list
            ll.remove(0);    //remove the node through the index and even through object 
            System.out.println(ll);

            ll.set(0,"X2"); //updation of elements
            ll.set(2,"X6");
            System.out.println(ll);

            System.out.println(Collections.synchronizedList(ll));   //synchronization is done explicitly

            for(String str:ll){
                System.out.print(str);
            }
    } 
}
