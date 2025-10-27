class Parent{
    Parent(String a){
        System.out.println("Parent Constructor:"+a);
    }
}

class Child extends Parent{
    Child(String b){
        super("in parent"); // even though it is not given explicilty it has inbuilt super method
        System.out.println("Child Constructor:"+b);
    }
}

class Main {
    public static void main(String[] args) {
       Child c = new Child("in child");
    }
}