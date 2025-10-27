abstract class Sum{
    int a = 10;
    int b = 20;
    abstract void sum();
}
class Child extends Sum{
    @Override
    void sum(){
       int c = a+b;
        System.out.println(c);
    }
}
class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.sum();
    }
}