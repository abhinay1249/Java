//  WAP to create a list of common elements betweem two lists


import java.util.*;
public class Commonelements {
    public static void main(String[] args) {
        Integer[] num= new Integer[]{4,9,8,5};
        Integer[] num1= new Integer[]{1,8,0,5,1,6};

        Vector<Integer> v= new Vector<>(Arrays.asList(num));
        Vector<Integer> v1= new Vector<>(Arrays.asList(num1));

        ArrayList<Integer> arr= new ArrayList<>();

        for(int i=0;i<v.size();i++){
            for(int j=0;j<v1.size();j++){

                if((v.get(i)) == v1.get(j)){
                    arr.add(v.get(i));
                }
            }
        }
            System.out.println(arr);
    }
 
}
