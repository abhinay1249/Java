

class a
{
    public a()
    {
        //super();
        System.out.println("in a constructor");
    }
    public a(int n)
    {
       // super();
        System.out.println("in a parameter constructor");
    }    
}

class b extends a
{
    public b()
    {
        //super();
        System.out.println("in b constructor"); 
    }
    public b(int n)
    {
        this();
        // super();
        System.out.println("in b parameter constructor");
    }
}


class demo
{
    public static void main(String[] args) 
    {
        b d=new b(5);
    }
}   