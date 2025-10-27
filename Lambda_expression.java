@FunctionalInterface
interface Car
{
    public void drive(int gears, String model);
}

class Creta implements Car
{
   @Override
   public void drive(int gears, String model)
   {
    System.out.println("Driving creta at "+gears+"th gear of model "+model);
   }
}

public class Lambda_expression
{
    public static void main(String[] args) {
        Creta c=new Creta();
        c.drive(5,"2021");

    //anonymous class
        Car c1=new Car()
        {
            public void drive(int gears, String model)
            {
                System.out.println("Driving bmw at "+gears+"th gear of model "+model);
            }
        };
        c1.drive(6,"2024");

    //lambda expression with anonymous function
        Car c2= (gears,model) -> {
        System.out.println("Driving lambo at "+gears+"th gear of model "+model);
        int speed=100;
        if(speed>100)
           System.out.println("Overspeed");
        else
           System.out.println("In speed");
        };
        c2.drive(7,"2023");
    }
}