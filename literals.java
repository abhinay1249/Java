class a
{
    public static void main(String a[]) 
    {
        int m=32769;  //int size is 2,147,483,647 incase it crosses that number then it gives error
        char b='!';
        m++;
        b++;
        System.out.println(m);
        System.out.println(b);
    }
}