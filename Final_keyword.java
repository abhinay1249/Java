// final keyowrd for variable, method, class

class A
{
    public  final void show()
    {
        System.out.println("Hi");
    }
}

class B extends A
{
    public void shows()
    {
        System.out.println("Hello");
    }
}

class demo
{
    public static void main(String[] args) 
    {
        final int a=10;
        // a=12;
        System.out.println(a);

        A aInstance=new A();
        aInstance.show();


    }
}