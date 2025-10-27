import java.util.*;
import java.util.Map.Entry;

public class Hashmap {
    public static void main(String[] args) {

        Map<Integer, String> hm=new HashMap<>();             // creation of a hashmap
        hm.put(null,"O");                   //**addition of only one null key in a hashmap */
        hm.put(134,"A");                          // addition of key-value pairs in a hash map
        hm.put(201,"B");
        hm.put(3,"C");
        hm.put(104,"D");
        hm.put(53,"E");
        hm.put(622,"F");

        System.out.println(hm);
        
     //  System.out.println(hm.keySet());         retrieval of keys from the hashmap , " if we write like this it will print in list"
     //  System.out.println(hm.values());        retrieval of values from the hashmap, " if we write like this it will print in list"
 
        Set<Integer> keys=hm.keySet();                  // retrieval of keys from the hashmap
        for(Integer key: keys){
            System.out.print(key +" ");
        }
        System.out.println();

        Collection<String> value=hm.values();           // retrieval of values from the hashmap
        for(String val:value){
                System.out.print(val+" ");     
        }
        System.out.println();

        System.out.println(hm.get(622));            /*retrieval of values from the hashmap using key */

        Set<Entry<Integer, String>> entries=hm.entrySet();      /* retrieval of values from the hashmap using entry set */
        for(Entry<Integer, String> entry:entries){
            System.out.print(entry+" ");
        }
        System.out.println();

        hm.remove(53);                  //deletion of elements from the hashmap
        hm.remove(201,"B");        // deletion of elements from the hashmap using key and value
        System.out.println(hm);

        System.out.println(hm.containsKey(300));    // verification of key in the hashmap
        System.out.println(hm.containsValue("A"));  //verification of value in the hashmap

        hm.put(1000,"End");             //updation of values in the hashmap
        hm.putIfAbsent(3,"B");
        hm.replace(622,"No");
        System.out.println(hm);

        s
    }
    
}
