class b
{
    public int add(int n1 ,int n2)
    {
        int result= n1+n2;
        return result;
    }
}


class demo
{
    public static void main(String a[]) 
    {
    int num1=8;
    int num2=1;

    b p=new b();
    int r=p.add(num1,num2);
    System.out.println(r);
    }
    
}