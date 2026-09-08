// Problem Statement: Given an integer n, return the number of set bits (1s) in its binary representation.
// Can you solve it in O(log n) time complexity?

// Example 1:

// Input: n = 5
// Output: 2
// Explanation: The binary representation of 5 is 101, which has 2 set bits.

// Example 2:

// Input: n = 15
// Output: 4
// Explanation: The binary representation of 15 is 1111, which has 4 set bits.

class Main {

    // ====================================== Brute Force Approach ===================================

        private static String reverseString(String number){

            int start = 0, end = number.length()-1;

            StringBuilder sb = new StringBuilder(number);

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
                    sb.append("1");
                }else{
                    sb.append("0");
                }

                number /= 2;

            }
        
            return reverseString(sb.toString());

        }

        public static int countNumberOfSetBits(int number){

            String binaryNumber = convertIntoBinary(number);

            int length = binaryNumber.length()-1;

            int counter = 0;

            for(int index = length ; index >= 0 ; index--){
                if(binaryNumber.charAt(index) == '1'){
                    counter++;
                }
            }

            return counter;

        }

    public static void main(String[] args) {

        int number = 15;

        int result = countNumberOfSetBits(number);

        System.out.println(result);

    }
}
