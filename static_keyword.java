class mobile
{
    String name;
    int price;
    static String type;

    public void show()
    {
        System.out.println(name +":"+price+":"+type);
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

//    obj1.show();
//    obj2.show();
  
    mobile.type="Phone";
     obj1.show();
     obj2.show();
}
}