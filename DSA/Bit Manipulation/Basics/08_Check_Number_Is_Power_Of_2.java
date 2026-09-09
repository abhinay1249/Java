// Problem Statement: Given an integer n, return true if it is a power of two. Otherwise, return false.
// An integer n is a power of two if there exists an integer x such that n == 2ˣ.

// Example 1:

// Input : n = 16
// Output : true
// Explanation : 2⁴ = 16, so 16 is a power of two.

// Example 2:

// Input : n = 3
// Output: false
// Explanation : 3 is not a power of two.

class Main {

    // ============================== Brute Force Approach =======================================

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
                    sb.append("1");                                     
                }else{
                    sb.append("0");
                }
                number/=2;                                                     // T.C = O(4 log N), S.C = O(log N)

            }

            return reverseString(sb.toString());                            

        }

        public static boolean checkNumber(int number){

            String binaryNumber = convertIntoBinary(number);

            int length = binaryNumber.length()-1;

            int counter = 0;

            for(int index = length ; index >= 0 ; index--){
                if(binaryNumber.charAt(index) == '1'){
                    counter++;
                }
            }

            return counter == 1;

        }

    // ========================= Optimal Approach ============================

        public static boolean checkNumber_1(int number){

            return (number > 0) && ((number & number-1) == 0);                  // T.C = O(1), S.C = O(1)

        }

    public static void main(String args[]){

        int number = 13;

        boolean result = checkNumber(number);

        System.out.println(result);

        boolean result1 = checkNumber_1(number);

        System.out.println(result1);

    }
}