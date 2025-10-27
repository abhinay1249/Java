import java.util.*;
import java.util.Map.Entry;

public class Treemap {
    public static void main(String[] args) {
        
        TreeMap<String, String> tm=new TreeMap<>();         //creation of TreeMap
        tm.put("U","0");                        //addition of key-value pair in a tree map
        tm.put("a","10");
        tm.put("A","20");
        tm.put("D","30");
        tm.put("E","40");
        tm.put("F","50");
        tm.put("O","60");

        System.out.println(tm);

        Set<String>key=tm.keySet();             // retrieval of keys from a tree map
        for(String keys:key){
            System.out.print(keys+" ");
        }
        System.out.println();

        Collection<String> value=tm.values();       // retrieval of values from a tree map
        for(String values:value){
            System.out.print(values+" ");
        }
        System.out.println();

        //Advancedversion of foreach loop
        tm.forEach((u,v) -> System.out.print(u+"-->>"+v+"  "));  // retrieval of key-value pairs from a tree map

        System.out.println();

        System.out.println(tm.get("a"));  // retrieval of value through key in a tree map

        tm.entrySet();                  // retrieval of keys and values using entry set
        for(Entry<String,String> entry:tm.entrySet()){
            System.out.println(entry);
        }

        tm.remove("E");             //deletion of key value pairs in a tree map
        tm.remove("F","50");
        System.out.println(tm);

        System.out.println(tm.containsKey("X"));            //verification of key in a tree map
        System.out.println(tm.containsValue("0"));

        tm.put("C","70");               //updation of key value pairs in a tree map
        tm.putIfAbsent("z", null);
        tm.replace("a", null);

        System.out.println(tm);

        System.out.println(tm.size());          // to know the size of the tree map
    }
    
}
