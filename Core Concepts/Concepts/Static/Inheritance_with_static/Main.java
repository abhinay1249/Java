class Parent{
    static int a = 10;
    static int b = 20;
    static void display(){
        System.out.println("in parent");
    }
}
class Child extends Parent{
 static int a = 11;
 static
 int b = 21;
static void display(){
        System.out.println("in child");
}
}
class Main {
public static void main(String[] args) {
    Parent pc = new Child(); 
    // when created in this manner only the variables and static methods are considered from left side reference class even though the right side class extends the left side class.
    
    //on the right side of the class it is used to retrieve the methods.
    System.out.println(pc.a);
    pc.display();
}
}