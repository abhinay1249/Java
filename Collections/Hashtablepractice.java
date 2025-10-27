import java.util.*;
import java.util.Map.Entry;

public class Hashtablepractice {
    public static void main(String[] args){

        Map<Integer, String> m= new Hashtable<>();     //Creation of map

        m.put(101,"Abhinay");               // addition of key value pairs into the map
        m.put(102,"Varshini");
        m.put(103,"Bharath");
        m.put(104,"Pranav");
        m.put(105,"Vamshi");
        m.put(106,"Sandeep");
        
        System.out.println(m);

        Set<Integer> num = m.keySet();   // retrieval of keys from the hash table
        for(Integer key: num){
            System.out.print(key+" ");
        }
        System.out.println();

        Collection<String> name= m.values();    // retrieval of values from the hash table
        for(String names: name){
            System.out.print(names+" ");
        }
        System.out.println();
 
        System.out.println(m.get(102));       // ** retrieval of the values from map based on key **

        m.remove(101);                        // deletion of value from map by using key
        m.remove(106, "Sandeep");      // deletion of value from map by using key and value
        System.out.println(m);

        System.out.println(m.containsKey(102));   //verification of keys in the hash table
        System.out.println(m.containsValue("Abhinay"));  //verification of values in the hash table
        
        m.put(101, "Abhi");           // updation of the value through the key in the hash table
        m.putIfAbsent(106,"Sandeep");    // updation of the value through the key in the hash table if the key is not present
        m.replace(105,"Vamsh");     // updation of the value through the key in the hash table 
        System.out.println(m);

        System.out.println(m.size());       // to know the elements present in the hash table

        Set<Entry<Integer, String>> entries = m.entrySet();   // retrieval of keys and values using entry set
        for(Entry<Integer, String> nums: entries){
            System.out.println(nums.getKey()+ ">>>"+nums.getValue());
        }
        
        m.clear();  //it is used to clear the entire values of the hash table
        System.out.println(m);
    } 
}
