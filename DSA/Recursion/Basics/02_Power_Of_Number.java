// Problem Statement: Implement the power function pow(x, n) , which calculates the x raised to n i.e. xn.

// Example 1:

// Input: x = 2.0000, n = 10  
// Output: 1024.0000  
// Explanation: The answer is calculated as 2^10, which equals 1024.

// Example 2:

// Input: x = 2.0000, n = -2  
// Output: 0.2500  
// Explanation: The answer is calculated as 2^(-2), which is equal to 1/4 = 0.25.


class Main{

    // ============================== Brute Force Approach ========================================
    
        public static double pow(double x, int n) {
            if (n == 0) {
                return 1.0;
            }

            long range = n;

            if (n < 0) {
                range = -1 * range;
            }

            double result = 1;                                          // T.C = O(N), S.C = O(1)

            for(int index = 0 ; index < range; index++) {
                result *= x;
            }

            if(n < 0) {
                result = 1 / result;
            }

            return result;
        }

    // ================================== Optimal Approach ============================================
    
        public static double pow_1(double x, int n) {
            if (n == 0) {
                return 1.0;
            }
            
            double ans = 1;
            long range = n;
            double number = x;

            if (n < 0) {
                range = -1 * range;
            }


            while(range > 0) {
                if(range % 2 == 1) {
                    ans *= number;                                              // T.C = O(log N), S.C = O(1)
                    range--;
                } else {
                    number *= number;
                    range /= 2;
                }
            }

            if(n < 0) {
                ans = 1 / ans;
            }

            return ans;
        }

    // ============================== Recursive Approach ============================================

        private static double power(double x, int pow, double ans){
            if(pow == 0){
                return ans;
            }

            if(pow%2 != 0){
                ans *= x;
                pow -= 1;
            }else{  
                x *= x;
                pow/=2;
            }

            return power(x, pow, ans);
        }

        public static double pow_2(double x, int n){
            double ans = 1;

            int pow = n;

            if(pow<0){
                x = 1/x;                                        // T.C = O(N), S.C = O(N), due to recursive stack space
                pow = -pow;
            }

            return power(x,pow,ans);
        }
        
    public static void main(String[] args) {

        double x = 2.0000;
        int n = 10;
        System.out.println(pow_2(x, n));

    }
}