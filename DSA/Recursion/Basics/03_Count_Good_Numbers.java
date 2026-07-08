// Problem Statement: A digit string is considered good if the digits at even indices (0-based) are even digits (0, 2, 4, 6, 8) 
// and the digits at odd indices are prime digits (2, 3, 5, 7).

// Given an integer n, return the total number of good digit strings of length n.
// As the result may be large, return it modulo 109 + 7.

// A digit string is a string consisting only of the digits '0' through '9'. It may contain leading zeros.

// Example 1: 

// Input: n = 1
// Output: 5
// Explanation:Only one index (0) → must be even. Valid strings: "0", "2", "4", "6", "8"

// Example 2:

// Input: n = 2
// Output: 20
// Explanation: Index 0: 5 options (even digits).Index 1: 4 options (prime digits). Total: 5 * 4 = 20


class Main{

    // ============================== Brute Force Approach ========================================
    
        public static int countGoodNumbers(long n){

            int modulus = 1_000_000_007;

            long ans = 1;

            for(int i = 0 ; i < n ; i++){
                if(i % 2 == 0){
                    ans *= 5;                                   // T.C = O(N), S.C = O(1), TLE occurs due to N ranges around (1,10^15)
                }else{
                    ans *= 4;
                }
                ans %= modulus;
            }
            return (int) ans;
        }

    // ============================== Optimal Approach ========================================

        private static long power(long number, long pow, long ans, int modulus){

            if(pow == 0){
                return ans;
            }

            if(pow%2 != 0){
                ans = (ans * number) % modulus;
                pow-=1;
            }else{
                number = (number * number) % modulus;
                pow /=2;                                                 // T.C = O(log N), s.c = O(N), due to recursive stack space
            }

            return power(number, pow, ans, modulus);
        }

        public static int countGoodNumbers_1(long n){
            
            int modulus = 1_000_000_007;

            long result = (power(5,((n+1)/2),1,modulus) * power(4,(n/2),1,modulus)) % modulus;


            return (int) result;
        }
    
    public static void main(String[] args) {

        long n = 2147483647;

        int result = countGoodNumbers_1(n);

        System.out.println(result);
    }
}