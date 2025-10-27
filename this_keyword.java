class demo
{
    private String name;
    private int age;

    public int getage()
    {
        return age;
    }
    public void setage(int age)
    {
        this.age=age;
    }

    public String getname()
    {
        return name;
    }

    public void setname(String name)
    {
        this.name=name;
    }
}

class hello
{
    public static void main(String[] args) 
    {
        demo d = new demo();
        d.setname("Abhi");
        d.setage(35);
        System.out.println(d.getage() +":"+d.getname());                
    }
}