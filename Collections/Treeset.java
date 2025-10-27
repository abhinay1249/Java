import java.util.*;

public class Treeset {
        public static void main(String[] args) {
            
            TreeSet<String> ts = new TreeSet<>();       //creation of treeset

            ts.add("Apple");                    // addition of elements in treeset
            ts.add("Tomato");
            ts.add("Cherry");
            ts.add("Grapes");
            ts.add("Banana");
            ts.add("Jackfruit");
            ts.add("Melon");

            System.out.println(ts);

            ts.forEach((t) -> System.out.print(t+" "));       // retrieval of elements from treeset

            System.out.println();

            System.out.println(ts.contains("Orange"));      //verification of elements from treeset

            ts.removeLast();                    //deletion of elements from treeset
            ts.pollFirst();
            System.out.println(ts);

        }    
}
