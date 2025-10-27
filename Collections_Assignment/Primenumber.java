// WAP to create a list of prime numbers untill 50

import java.util.*;

public class Primenumber {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        int n=50;
        for(int i=2;i<=n;i++){
            int count =0;
            for(int j=2;j<i;j++){
                if(i%j==0)
                  count++;
            }
            if(count==0)
                arr.add(i);
        }
            System.out.println(arr);

    }
    
}
