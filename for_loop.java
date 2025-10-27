class demo
{
    public static void main(String[] args)
    {
        int n=1;
        for(n=1;n<=5;n++)
        {
            System.out.println("Day"+n);
            for(int j=1;j<=4;j++)
            {
                System.out.println(" "+(j+8)+"-"+(j+9));
            }
        }
    }
}