class A
{
    public void show()
    {
        System.out.println("In A show");
    }
}

class B extends A
{
    public void show()
    {
        System.out.println("In B show");
    }
}
class Dynamic
{
    public static void main(String[] args)
    {
        // B b=new B();
        A b =new B();
        b.show();

        b=new A();
        b.show();

         
    }
}