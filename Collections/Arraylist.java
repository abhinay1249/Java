import java.util.ArrayList;
import java.util.Collections;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> ar1=new ArrayList<>();  //creation of an arraylist
        ar1.add(10);  //addition of elements
        ar1.add(20);
        ar1.add(30);
        ar1.add(40);
        ar1.add(50);
        ar1.add(60);
        System.out.println(ar1);

        ar1.remove(5);  //deletion of elements
        System.out.println(ar1);

        System.out.println(ar1.get(4));  //retrieval of elements

        System.out.println(ar1.contains(9)); //verfication of elements

        ar1.set(4,100);  //updation of elements
        System.out.println(ar1);

        //iterate the array elements
        for(int i=0;i<ar1.size();i++){
            System.out.print(ar1.get(i)+" ");
        }
        System.out.println();
        //using foreach
        for(Integer arr: ar1){
            System.out.print(arr+" ");
        }

        //synchronization is done explicity using Collections in arraylist
        Collections.synchronizedList(ar1);
        
    }
    
}

/**
 * doubt one :- if the intial capacity is 5, after the size of elements is more than 5 than the capacity will increase or will throw an exception
 * incase if it increases then with the same percent as 50% will be done or in some other way?
 * doubt 2 :- the default capacity is 0 for arraylist and by adding an element only the capacity is 10, the element added is null does the intial capacity will be 10?
 */