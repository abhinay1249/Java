// USAGE OF ABSTRACTION AND ENCAPSULATION IN A SINGLE PROGRAM

abstract class Sum{
    int a = 10;
    int b = 20;
   abstract void sum();
}
class Child extends Sum{
    private int c = a+b;
    
    int getNum(){
        return c;
    }
    void setNum(int n){
        c = n+a;
    }
    @Override
    void sum(){
        System.out.println("Abstraction + Encapsulation");
    }
}
class Main {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.setNum(90);
        System.out.println(ch.getNum());
        ch.sum();
    }
} 



    //abstract class Sum{
    //     int a = 10;
    //     int b = 20;
    //   abstract void sum();
    // }
    // class Child extends Sum{
    //     private int c = a+b;
        
    //     int getNum(){
    //         return c;
    //     }
    //     // void setNum(int n){
    //     //     c = n+a;
    //     // }
    //     @Override
    //     void sum(){
    //         System.out.println(c);
    //     }
    // }
    // class Main {
    //     public static void main(String[] args) {
    //         Child ch = new Child();
    //       // ch.setNum(90);
    //         //System.out.println(ch.getNum());
    //         ch.sum();
    //     }