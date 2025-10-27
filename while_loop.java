class demo
{
    public static void main(String[] args) {
        int i=0;
        while(i<5)
        {
            System.out.println("Loop"+i);
            int j=10;
            while(j<14)
            {
                System.out.println("Inner Loop"+j);
                j++;
            }
            i++;
        }
    }
}