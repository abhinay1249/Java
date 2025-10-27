class ChaiShop{
    static int c = 8;
      static int square(int n){
        return n*n;
        }
    static void sum(){
        int a = 10;
        int b = 2;
        System.out.println(a+b+a);
    }
}
class Main {
    public static void main(String[] args) {
        ChaiShop.sum();
        System.out.println(ChaiShop.square(10));
    }
}
