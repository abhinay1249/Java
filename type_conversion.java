class abhinay
{
    public static void main(String[] args) 
    {
        // int b=12; we cannot convert from int to byte as the size of int is large than byte.
        byte a= 123;
        int b=(byte)a;             // type casting

        float f=3.093f;     
        int v=(int)f;

      byte z=10;
      byte y=100; int result=z*y;   //type promotion takes place over here.

        System.out.println(result);
    }
    
}