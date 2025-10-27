class baby
{
    public String music(float cost) // void is not present return statement is included
    {                               // void is present then return statement is not included

        return "love";
    }
}




class hi
{
    public int add(int n1,int n2)
    {
        int n3=n1+n2;
        return n3;
    }
}

class hello
{
    public static void main(String[] args) {
        int num1=8;
        int num2=2;
        hi b=new hi();
        int s=b.add(num1,num2);
        baby lo=new baby();
        String abhi=lo.music(1.0f);
        System.out.println(s);
        System.out.println(abhi);
    }
}