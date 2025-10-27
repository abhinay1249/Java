//  WAP to delete the duplicates from the list

import java.util.*;
public class Delete_duplicates {
    public static void main(String[] args) {

        Integer[] arr= new Integer[]{4,1,9,4,8,0,5,1,8,6};
        LinkedList<Integer> l1= new LinkedList<>(Arrays.asList(arr));
        System.out.println(l1);
  
        LinkedList<Integer> ar= new LinkedList<>();
        ArrayList<Integer> dup= new ArrayList<>();

        for(Integer num :l1){
            if(ar.contains(num)){
                dup.add(num);
            }
            else{
                ar.add(num);
            }
       }
           ar.removeAll(dup);
           System.out.println(ar);
       
    }
}
