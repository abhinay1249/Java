class Laptop
{
    String name;
    int price;
    public String toString()    //if we use concatentation then the int is converted into string
    {
        return "Name is :"+name+", price is :"+price; 
    }

    public boolean equals(Laptop that)
    {
        return this.name.equals(that.name) && this.price==that.price;
    }
}
class Demo
{
    public static void main(String[] args)
    {
        Laptop obj=new Laptop();
        obj.name="Dell";
        obj.price=90000;
        System.out.println(obj);

        Laptop obj1=new Laptop();
        obj1.name="Dell";
        obj1.price=90000;
         
         boolean result=obj.equals(obj1);
         System.out.println(result);
    }
}