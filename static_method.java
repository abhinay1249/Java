class mobile
{
    String name;
    int price;
    static String type;

    // public void show()
    // {
    //    System.out.println(name +":"+price+":"+type);
    // }
    public static void show1(mobile obj)
    {
        System.out.println(obj.name+":"+obj.price+":"+type);
    }
}
class demo
{
    public static void main(String[] args)
    {
    mobile obj1=new mobile();
    obj1.name="Samsung";
    obj1.price=70000;
    mobile.type="Phone";

    mobile obj2=new mobile();
    obj2.name="Apple";
    obj2.price=10000;
    mobile.type="SmartPhone";
  
    mobile.type="Phone";
    //  obj1.show();
    //  obj2.show();

     mobile.show1(obj1);
     mobile.show1(obj2);
}
}

class Calculator
 {
    int instanceVariable; // instance variable

    public void nonStaticMethod() 
    {
        System.out.println("Non-static method called");
        System.out.println("Instance variable: " + instanceVariable);
    }

    public static void staticMethod() 
    {
        // System.out.println("Instance variable: " + instanceVariable); // This would cause a compilation error
        System.out.println("Static method called");
    }

    public static void main(String[] args) 
    {
        // Calling the static method without creating an object
        Calculator.staticMethod();

        // Calling the non-static method requires creating an object
        Calculator calculator = new Calculator();
        calculator.nonStaticMethod();
    }
}