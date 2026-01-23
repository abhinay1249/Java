
class Main {

    // Give me the Exact Value For the Row And Column Provided

    // ==================================== Brute Force Approach =======================================

        static int pascalValue(int row, int col){
            int num = 1, denom = 1, sub = 1, result = 1;

            for(int i = row-1 ; i > 0 ; i--){
                num *= i;
            }

            for(int i = col-1; i > 0 ; i--){
                denom *= i;
            }

            for(int i = row-col; i > 0 ; i--){
                sub*=i;
            }

            result = num/(denom*sub);
            return result;
        }

    // ==================================== Optimal Approach ==========================================
        
        static int pascalValue_1(int row, int col){
            int result = 1;

            for(int i = 0 ; i < col ; i++){
                result = result * (row-i-1);
                result= result / (i+1);
            }
            return result;
        }

    // Print the Entire Row of the Given Nth Row Of Pascal's Triangle

    // ==================================== Brute Force Approach ========================================

        static void NthRowOfTraingle(int n){
            for(int i = n-1 ; i >= 0 ; i--){
                for(int j = 0 ; j < i ; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }

    // ==================================== Optimal Approach ===========================================

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
        int row = 6;
        int col = 3;
        NthRowOfTraingle(n);
        NthRowOfTraingle_1(n);
        int result = pascalValue(row, col);
        int result_1 = pascalValue_1(row, col);
        System.out.println(result);
        System.out.println(result_1);
    }
}


class Main {
    
    public static void main(String[] args) {


    }
}