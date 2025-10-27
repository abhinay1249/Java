

class clas
{
    public static void main(String[] args)
    {
        int x=10;
        float y=10.0f;
        double z=10.00001;
        if(x<y && x==y)
        {
            System.out.println("Proved");
        }
        else if(y<z && x==y)        
        {
            System.out.println("Hence Proved");
        }
        else
        {
            System.out.println("No");
        }
    }
}