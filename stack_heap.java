class abc
{
    int num=2;
    public int add(int n1,int n2)
    {
        System.out.println(num);
        return n1+n2;
    }
}
class demo
{
    public static void main(String[] args)
     {
        int data=9;
        abc obj=new abc();
        abc obj1=new abc();
        int r=obj.add(5,5);
        obj.num=5;
        System.out.println(obj1.num);
        System.out.println(obj.num);
        System.out.println(r);
    }
}