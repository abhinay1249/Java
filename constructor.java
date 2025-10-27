class demo
{
    public demo()          //constructor method
    {
        System.out.println("in constructor");
    }
}

class hello
{
    public static void main(String[] args) 
    {
       demo d=new demo();   // constructor called
       demo e=new demo();   // constructor called           
       demo c=new demo();   // constructor called
    }
}