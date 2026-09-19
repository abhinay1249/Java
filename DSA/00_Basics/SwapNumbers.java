class Main {
    
    public static void swapUsingTemp(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        
        System.out.println(a);
        System.out.println(b);
    }
    
    public static void swapWithoutTemp(int a, int b){
        
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        
        System.out.println(a);
        System.out.println(b);
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        swapWithoutTemp(a,b);
    }
}