import java.util.*;

public class Hashset {
    public static void main(String[] args) {
        
        Set<Integer> hs=new HashSet<>();        //creation of HashSet

        hs.add(10);                             // adding elements to HashSet
        hs.add(15);
        hs.add(20);
        hs.add(8);
        hs.add(0);
        hs.add(null);
        hs.add(null);
        hs.add(10);

        System.out.println(hs);

        hs.forEach((v) -> System.out.print(v+" "));  //printing elements of HashSet

        System.out.println();

        hs.remove(null);            // deletion of element from HashSet
        System.out.println(hs);

        System.out.println(hs.contains(54));        //verification of element in hashset

        System.out.println(hs.size());



    }
    
}
