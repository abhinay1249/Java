//  WAP to print the repeated values along with the repetition count

import java.util.*;

public class Repeatedvalue {
    public static void main(String[] args) {
        String[] arr= new String[]{"baby","ball","soap","baby","shampoo","chalk","soap","makeup","baby","lotion"};
        Vector<String> v= new Vector<>(Arrays.asList(arr));
        System.out.println(v);

        ArrayList<String> ar= new ArrayList<>();
        

        for(int i=0;i<v.size();i++){
            int count=0;
            for(int j=0;j<v.size();j++){
                
                if((v.get(i)).equals(v.get(j))){
                   count++;
                }
            }
            if(!ar.contains(v.get(i)) && count>1){
                System.out.println(v.get(i)+"-"+count);
                ar.add(v.get(i));
            }
        }
    }
}
        
    
