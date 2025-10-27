import java.util.*;

public class Linkedhashset {
    public static void main(String[] args) {
        Set<Integer> lhs=new LinkedHashSet<>();        //creation of linkedHashSet

        lhs.add(10);                             // adding elements to linkedHashSet
        lhs.add(15);
        lhs.add(20);
        lhs.add(8);
        lhs.add(0);
        lhs.add(null);
        lhs.add(null);
        lhs.add(10);

        System.out.println(lhs);

        lhs.forEach((v) -> System.out.print(v+" "));  //printing elements of linkedHashSet

        System.out.println();

        lhs.remove(null);            // deletion of element from linkedHashSet
        System.out.println(lhs);

        System.out.println(lhs.contains(54));        //verification of element in linkedhashset

        System.out.println(lhs.size());
    }  
}
