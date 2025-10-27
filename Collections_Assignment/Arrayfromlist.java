//  WAP to convert a list into array

import java.util.*;

public class Arrayfromlist {
    public static void main(String[] args) {
        
        Integer[] num =new Integer[]{4,9,8,5,0,10};

        Vector<Integer> v= new Vector<>(Arrays.asList(num));
        System.out.println(Arrays.toString(v.toArray()));


    }
}
