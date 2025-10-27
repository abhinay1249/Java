//  WAP to print the sum and average of elements in a list.

import java.util.*;

public class Sum {
    public static void main(String[] args) {
        
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(5);
        arr.add(0);
        arr.add(9);
        arr.add(8);
        arr.add(10);
        int sum=0;

        for(Integer ar : arr){
            sum+=ar;
            
        }
        System.out.println("Sums is: "+ sum);  //sum is calculated

        int avg=0;
        avg=sum/arr.size();
        System.out.println("Average is : "+avg);  //average is calculated


        }

    }