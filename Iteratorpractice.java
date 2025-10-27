import java.util.*;

public class Iteratorpractice {
    public static void main(String[] args) {
        
        ArrayList<Integer> al= new ArrayList<>();
        al.add(12);
        al.add(14);
        al.add(16);
        al.add(18);
        al.add(20);

        Iterator<Integer> i= al.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
            i.remove();
        }
        System.out.println(al);
    } 
}
