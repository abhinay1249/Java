class A
{
    public void show()
    {
        System.out.println("In  class A");

    }
}

class demo
{
    public static void main(String[] args) {
        A obj = new A()
        {
            public void show()
            { 
                System.out.println("In demo class");   // anonymous class, without using the class keyowrd it is created
            }
        };
        obj.show();
    }
}