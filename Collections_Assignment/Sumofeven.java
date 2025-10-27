//  WAP to print the even numbers in a list

import java.util.*;

public class Sumofeven {
    public static void main(String[] args) {
        Vector<Integer> v1= new Vector<>();
        v1.add(4);
        v1.add(5);
        v1.add(0);
        v1.add(9);
        v1.add(8);
        v1.add(10);
        int sum =0;
        System.out.println("Input is : "+v1);

        for(int i=0;i<v1.size();i++){     //for(Integer ar:v1){
            if(v1.get(i)%2==0)            // if(ar%2==0){
                sum+=v1.get(i);            // sum+=ar;
        }                                  //}} 
        System.out.println("Sum of even numbers: "+sum);
    }
    
}
