class A 
{
    public void show()
    {
        System.out.println("in A show method");
    }
}

class B extends A
{
    public void show1()
    {
        System.out.println("in B show method");
    }
}
 

public class upcasting_downcasting
{
    public static void main(String[] args) {
        
        A obj=new B();  //this is also same as dynamic method dispatch, here we had done "UpCasting"
        obj.show();   //objected created is of b and method called is of A which is called due to extends  keyword
        
        B obj1= (B) obj;  //this is called "DownCasting"
        obj1.show1();


    }
}