// Problem Statement: Given two integers start and goal. Flip the minimum number of bits of start integer to convert it into Integer.
// A bits flip in the number val is to choose any bit in binary representation of val and flipping it from either 0 to 1 or 1 to 0.

// Example 1:

// Input : start = 10 , goal = 7
// Output : 3
// Explanation : The binary representation of 10 is "1010". The binary representation of 7 is "111".
// If we flip the underlined bits in binary representation of 10 then we will obtain our goal.

// Example 2 :

// Input : start = 3 , goal = 4
// Output : 3
// Explanation : The binary representation of 3 is "011". The binary representation of 4 is "100".
// So if we flip all the three bits of 3 then we will reach our goal number.

class Main {

    // =================================== Approach ============================================

        public static int minimumBitFlips(int start, int goal){

            int result = 0;



            return result;

        }

    public static void main(String[] args) {
        
        int start = 3;
        int goal = 4;
        
        int result = minimumBitFlips(start, goal);

        System.out.println(result);
    }
}