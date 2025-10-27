abstract class Animal{
    abstract void sound();  //abstract method
    void display(){ //concrete method
        System.out.println("There are vast no of animals");
    }
}
class Dog extends Animal{   
    @Override
    void sound(){
         System.out.println("Dog Barks");
    }
    
}

class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
        d.display();
        
    }
}