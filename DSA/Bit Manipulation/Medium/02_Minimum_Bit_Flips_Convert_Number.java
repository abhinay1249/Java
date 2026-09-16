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

    // =================================== Approach - 1 ============================================

        public static int minimumBitFlips(int start, int goal){

            int number = start ^ goal;

            int minimumFlips = 0;

            while(number >= 1){
                
                if((number & 1)==1){                                                  // T.C = O(log N), S.C = O(1)
                    minimumFlips+=1;
                }

                number = number >> 1;

            }

            return minimumFlips;

        }

    // =================================== Approach - 2 ============================================

        public static int minimumBitFlips_1(int start, int goal){

            int number = start ^ goal;

            int minimumFlips = 0;

            while(number != 0){
                
                number = (number & number - 1);                                        // T.C = O(log N), S.C = O(1)
                minimumFlips+=1;

            }

            return minimumFlips;

        }

    public static void main(String[] args) {
        
        int start = 3;
        int goal = 4;
        
        int result = minimumBitFlips(start, goal);

        System.out.println(result);

        int result_1 = minimumBitFlips_1(start, goal);

        System.out.println(result_1);
        
    }
}