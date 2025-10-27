import java.util.*;
import java.util.Map.Entry;

public class Linkedhashmap {
    public static void main(String[] args) {

        Map<String, Integer> lhm = new LinkedHashMap<>();           // creation of linkedhashmap
        lhm.put(null,10000);
        lhm.put("Abhi",20);                             // addition of keyvalue pair in the linked hash map  
        lhm.put("Varsh",30);
        lhm.put("Honey",40);
        lhm.put("Abhinay",50);
        lhm.put("Srivalli",60);
        lhm.put("BujjiThalli",70);

        System.out.println(lhm);

        lhm.remove("Abhinay");          // deletion of elements in the lhm

        Set<String> key= lhm.keySet();          // retrieval of the keys of the lhm
        for(String keys: key){
            System.out.print(keys+" ");
        }
        System.out.println();
        Collection<Integer> value=lhm.values();           // retrieval of values from the hashmap
        for(Integer val:value){
                System.out.print(val+" ");     
        }
        System.out.println();

        Set<Entry<String, Integer>> entry=lhm.entrySet();         // retrieval of entry set from the lhm
        for(Entry<String, Integer> entries:  entry){
            System.out.print(entries+" ");
        }
        System.out.println();
        System.out.println(lhm.containsKey("Abhi"));   //verification of key in the lhm
        System.out.println(lhm.containsValue(40));   //verification of value in the lhm

        lhm.put("Star",1);                          ////updation of values in the lhm
        lhm.putIfAbsent("Abh", 20);
        lhm.replace("Srivalli",20);

        System.out.println(lhm);

        System.out.println(lhm.size());          // to know the size of the lhm
   
    }
}
