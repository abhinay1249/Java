//  WAP to identify the highest number of duplicate elements from the list

import java.util.*;

public class Highestnumber {
    public static void main(String[] args) {
        Integer[] arr= new Integer[]{4,1,9,4,8,0,5,8,1,8,6};
        Vector<Integer> v= new Vector<>(Arrays.asList(arr));
        System.out.println(v);
        int max=0, repeat=0;

        Vector<Integer> v1= new Vector<>();

        for(int i=0;i<v.size();i++){
            int count =0;
            for(int j=0;j<v.size();j++){
            if((v.get(i)) == (v.get(j))){
                count++;
            }       
        }
        if(count>repeat){
            max=v.get(i);
            repeat=count;
        }
    }
        System.out.println("Highest repeated number is: "+max + " and it is repeated "+repeat+" times");
    }
}


