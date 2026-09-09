// Problem Statement: Given a non-negative integer n, determine whether it is odd. 
// Return true if the number is odd, otherwise return false. A number is odd if it is not divisible by 2 (i.e., n % 2 != 0).

// Example 1:

// Input : n = 7
// Output : true
// Explanation : 7 is not divisible by 2. Hence, it is odd.

// Example 2:

// Input : n = 10
// Output : false
// Explanation : 10 is divisible by 2. Hence, it is not odd.

class Main {

    // ============================ Brute Force Approach ====================================

        public static String checkOddEven(int number){

            String ans = "";

            if(number % 2 == 0){
                ans = "even";                                           // T.C = O(1), S.C = O(1)  
            }else{                                                     // where this execution takes little more than below.
                ans = "odd";
            }

            return ans;

        }

    // =================================== Optimal Approach ==================================

        public static String checkOddEven_1(int number){

            return (number & 1) == 0 ? "even" : "odd";                  // T.C = O(1), S.C = O(1), fast execution due to bits.

        }

    public static void main(String[] args){

        int number = 5;

        int number1 = 124;

        String result = checkOddEven(number);

        System.out.println(result);

        String result_1 = checkOddEven_1(number1);

        System.out.println(result_1);

    }
}