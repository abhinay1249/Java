class hello
{
    public static void main(String[] args)
    {
        int arr[][]=new int[4][3];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j]= (int)(Math.random() *100);  //Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
        for(int n[]: arr)
        {
            for(int x: n)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        // for(int i=0;i<4;i++)
        // {
        //     for(int j=0;j<3;j++)
        //     {
        //         System.out.print(arr[i][j] +" ");
        //     }
        //     System.out.println();
        // }
    
    }
}