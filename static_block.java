class mobile
{
    String name;
    int price;
    static String type;

    mobile()   //constructor
    {
        name=" ";
        price=0;
        System.out.println("in constructor");
    }

    public void show()
    {
       System.out.println(name +":"+price+":"+type);
    }
    
    static
    {
        System.out.println("in static block");
    }
}  
class demo
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("mobile");
        mobile obj1=new mobile(); //constructor called
        obj1.name="Samsung";
        obj1.price=70000;
        mobile.type="Phone";
    }
}
