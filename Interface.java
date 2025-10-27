interface laptop                  // define what to do untill java 7 version later we can define how to in it
{
    int a=10;   //final and static
    String b="fi";
    void mouse();                 //what to do method implementation andnpublic is used when they are in other packages

    void keyboard();
    
    void camera();

    default void cpu()            //how to do method implementation
    {
        System.out.println("310g cpu");
    }

    static void ram()
    {
        price();
        System.out.println("32gb");
    }

    private static void price()      // can be used within class but through this we can use it when required
    {
        System.out.println("Rs.90000");
    }
     
}

class Hp implements laptop
{
    public void mouse()
    {
        System.out.println("Hp 3100 m");
    }
    public void keyboard()
    {
        System.out.println("Hp 200 k");
    }
    public void camera()
    {
        System.out.println("Hp 20 c");
    }
}

class dell implements laptop
{ 
    public void mouse()
    {
        System.out.println("dell 3100 m");
    }
    public void keyboard()
    {
        System.out.println("dell 200 k");
    }
    public void  camera()
    {
        System.out.println("dell S 20 c");
    }
}

public class Interface
{
    public static void main(String[] args)
    {
        Hp obj=new Hp();
        obj.mouse();
        obj.cpu();
        laptop.ram(); // static method called

        laptop obj1=new dell();
        obj1.mouse();
        obj1.keyboard();
        obj1.camera();
        System.out.println(laptop.a);
        System.out.println(laptop.b);
    }
}