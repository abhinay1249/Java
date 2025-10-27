//  WAP to delete the elements of one list from another list


import java.util.*;
public class Delete_elements {
    public static void main(String[] args) {
        
        Integer[] num =new Integer[]{4,9,8};

        LinkedList<Integer> l = new LinkedList<>(Arrays.asList(num));

        Integer[] num1 =new Integer[]{4,1,9,4,8,0,5,1,8,6};
        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(num1));

            l1.removeAll(l);
            System.out.println(l1);

    }
}
