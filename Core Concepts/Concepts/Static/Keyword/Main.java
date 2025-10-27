class ChaiShop{
    int a = 10;
    static int b = 100;
}
class Main {
    public static void main(String[] args) {
        ChaiShop c = new ChaiShop();
        ChaiShop c1 = new ChaiShop();
        for(int i = 0; i<5;i++){
             ChaiShop.b++; // static usage directly from class
        }
        c.a++;
        c1.a++;
        // c.b++; it is static so need to access through the object
        // c1.b++;
        System.out.println(c.a);
        System.out.println(ChaiShop.b);
    }
}