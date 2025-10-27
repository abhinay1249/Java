class a
{
    public int add(int n1, int n2)
    {
        return n1+n2;
    }
}
class b extends a  // even though it has same(name, returntype, parameter) its implementation is different
{
    public int add(int n1, int n2)    // it overrides the super class by subclass and implements it.
    {
        return n1+n2+1;
    }
}    


class demo
{
    public static void main(String[] args) 
    {
        b d=new b();
         int r=d.add(8,1);
         System.out.println(r);    
    }
}