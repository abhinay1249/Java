// Problem Statement: Given two integers n and i, return true if the ith bit in the binary representation of n 
// (counting from the least significant bit, 0-indexed) is set (i.e., equal to 1). Otherwise, return false.

// Example 1:

// Input: n = 5, i = 0
// Output: true
// Explanation: Binary representation of 5 is 101. The 0-th bit from LSB is set (1).

// Example 2:

// Input: n = 10, i = 1
// Output: true
// Explanation: Binary representation of 10 is 1010. The 1-st bit from LSB is set (1).

class Main {

    // ================================ Brute Force Approach ====================================
    
        private static String reverseString(String str){

            StringBuilder sb = new StringBuilder(str);

            int start = 0, end = str.length()-1;

            while(start < end){
                char temp = sb.charAt(start);

                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);

                start++;
                end--;
            }

            return sb.toString();

        }

        private static String convertIntoBinary(int number){

            StringBuilder sb = new StringBuilder();

            while(number != 0){

                if(number % 2 == 1){
                    sb.append("1");                                     // T.C = O(2 log n) + O(N), S.C = O(1)
                }else{
                    sb.append("0");
                }

                number/=2;

            }

            return reverseString(sb.toString());

        }

        public static boolean checkithBit(int number, int bitNumber){

            String binaryNumber = convertIntoBinary(number);

            int length = binaryNumber.length()-1;

            for(int index = length ; index >= 0 ; index--){

                if(length - index == bitNumber){
                    int value = binaryNumber.charAt(index) - '0';

                    if(value == 1){
                        return true;
                    }else{
                        break;
                    }
                }
            }

            return false;
        }

    // ================================ Optimal Approach ====================================

        


    public static void main(String[] args) {
        
        int number = 13;

        int bitNumber = 2;

        System.out.println(checkithBit(number, bitNumber));

    }
}

