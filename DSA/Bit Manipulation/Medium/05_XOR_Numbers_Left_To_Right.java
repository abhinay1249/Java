// Problem Statement: Given two integers L and R. Find the XOR of the elements in the range [L , R].

// Example 1:

// Input : L = 3 , R = 5
// Output : 2
// Explanation :  answer = (3 ^ 4 ^ 5) = 2.

// Example 2:

// Input : L = 1, R = 3
// Output : 0
// Explanation : answer = (1 ^ 2 ^ 3) = 0.

class Main {

    // ================================= Brute Force Approach =================================

        public static int xorNumbers(int left, int right){

            int xor = 0;

            for(int value = left ; value <= right ; value++){               // T.C = O((R-L)+1), S.C = O(1) 
                xor ^= value;
            }

            return xor;

        }

    // ============================== Optimal Approach ===============================================

        private static int xor(int number){

            if(number % 4 == 1){
                return 1;
            }else if(number % 4 == 2){
                return number+1;
            }else if(number % 4 == 3){
                return 0;
            }

            return number;

        }

        public static int xorNumbers_1(int left, int right){

            return xor(left - 1) ^ xor(right);

        }
        
    public static void main(String[] args) {
        
        int left = 1;
        int right = 3;

        int xorNumber = xorNumbers(left, right);

        System.out.println(xorNumber);

        int xorNumber_1 = xorNumbers_1(left, right);

        System.out.println(xorNumber_1);

    }

}
