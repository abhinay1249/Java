// WAP to split a list into two lists

import java.util.*;

public class Splitlists {
    public static void main(String[] args) {

        ArrayList<Integer> s=new ArrayList<>();
        s.add(4);
        s.add(9);
        s.add(8);
        s.add(5);
        s.add(0);
        s.add(10);
        
        int mid= s.size()/2;
        
        System.out.println("Input is: "+s);

        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        for(int i=0; i<mid;i++){
           s1.push(s.get(i));
        }

        for(int i=mid;i<s.size();i++){
            s2.push(s.get(i));
        }
      System.out.println(s1);
      System.out.println(s2);
       
    }
}
