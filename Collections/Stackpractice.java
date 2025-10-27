import java.util.Stack;

public class Stackpractice {
    public static void main(String[] args) {
        Stack<String> books=new Stack<>();   //creation of elements
        books.push("orange");    //addition of elements and push opearion
        books.push("blue");
        books.push("red");
        books.push("white");
        books.push("brown");
        System.out.println(books);

        System.out.println(books.get(2));  //retrieval of elements

        books.remove("orange");      //deletion of elements
        System.out.println(books);

        System.out.println(books.contains("orange"));   //verification of elements

        books.set(0,"purple");  //updation of elements
        System.out.println(books);
        
        System.out.println(books.pop());  //pop an element from the top

        System.out.println(books.peek()); //peek an element

        System.out.println(books.search("white")); //search an element
    }
}