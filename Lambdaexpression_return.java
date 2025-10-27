@FunctionalInterface
interface Car
{
    public int drive();
}

class Lambo implements Car
{
    @Override
    public int drive()
    {
        System.out.println("Driving lambo");
        return 80;
    } 
}

public class Lambdaexpression_return
{
    public static void main(String[] args) {
        Lambo l=new Lambo();
        System.out.println(l.drive());
            
        //anonymous function
        Car c1=new Car(){
            public int drive()
            {
                System.out.println("Driving audi");
                return 120;
            }
        };
        System.out.println(c1.drive());

        //lambda expression with anonymous function

        Car c2=() -> 100;{
            System.out.println("Driving bmw");
            // int speed=100;
            // if(speed>100)
            //    System.out.println("Overspeed");
            // else  
            //     System.out.println("Inspeed");
            //return  
        };
        System.out.println(c2.drive());
    }
}