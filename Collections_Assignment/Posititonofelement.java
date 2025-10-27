//  WAP to print the position of the element from the list

import java.util.*;
public class Posititonofelement {
    public static void main(String[] args) {
        
        Integer[] num = new Integer[]{1,8,0,5,1,6};
        Vector<Integer> v= new Vector<>(Arrays.asList(num));


       int target=0;
       for(int i=0;i<v.size();i++){
        if(v.get(i)==target)
           System.out.println(i+1);
       }
    }
}
