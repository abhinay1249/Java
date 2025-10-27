import tools.*;


class C extends B
{
    public void method()
    {
        System.out.println(marks);
    }
}



public class Access_modifier
{
    public static void main(String[] args) 
    {
        B obj=new B();
        //System.out.println(obj.marks);
        obj.show();
        C obj1=new C();
        //int s=obj1.abc();
        //System.out.println(s);
    }
}