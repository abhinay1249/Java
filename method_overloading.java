class abhinay
{
    public int abhi(int n1, int n2)
    {
        return n1+n2;
    }
    public String abhi(int n1)
    {
        return"got it";
    }
    public double abhi(int n1, double n2, int n3)
    {
     return  n1+n2+n3;
    }
}
class varshini
{
    public static void main(String[] args) {
        abhinay munnu=new abhinay();
        String res=munnu.abhi(10);
        double result=munnu.abhi(10,0.1,1);
        System.out.println(res);
        System.out.println(result);

    }
}