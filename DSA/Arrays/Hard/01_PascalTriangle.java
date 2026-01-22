
class Main {

    // Give me the Eaxct Value For the Row And Column Proivded













    // Print the Entire Row of the Given Nth Row Of Pascal's Triangle

    // ==================================== Brute Force Approach ===========================================

        static void NthRowOfTraingle(int n){
            for(int i = n-1 ; i >= 0 ; i--){
                for(int j = 0 ; j < i ; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }

    // ==================================== Brute Force Approach ===========================================

        static void NthRowOfTraingle_1(int n){
            int res = 1;
            System.out.print(res+" ");
            for(int i = n-1 ; i > 0 ; i--){
                res = res * i;
                res= res / (n-i);
                System.out.print(res+" ");
            }
        }
    public static void main(String[] args) {
        int n = 6;
        NthRowOfTraingle(n);
        NthRowOfTraingle_1(n);
    }
}