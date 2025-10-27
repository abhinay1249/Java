class demo
{
    public demo()
    {
        int age=12;
        String name="Abhi";
        System.out.println(age+":"+name);
    }
     
    public demo(int a, String s)
    {
        System.out.println(a+":"+s);
    }
}

class hello
{
    public static void main(String[] args) 
    {
        demo d1=new demo();
        demo d=new demo(21,"Abhinay"); 
      
    }
}