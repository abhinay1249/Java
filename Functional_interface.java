@FunctionalInterface

interface Car  //All methods in an interface are implicitly public
{
    void drive();
     
    default void type(){
        System.out.println("Vehicle");
    }

    static void speed(){
        System.out.println("highest is 300");
    }
}

public class Functional_interface{

    public static void main(String[] args){

        Car obj= new Car(){
            
            public void drive()
            {
                System.out.println("Audi is being drove");
            }

        }; 
        
        Car.speed();
        obj.drive();
        obj.type(); //non static method should be called by an object

    }
}