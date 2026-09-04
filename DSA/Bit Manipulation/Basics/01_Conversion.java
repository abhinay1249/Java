// Problem Statement : Perform conversion of a decimal number into a binary number and vice versa.

// Example 1:

// Input : num = 13
// Output : 1101
// Explanation : The respective decimal number is divided by 2 to obtain the respective binary number.

// Example 2:

// Input : Binary = 1101
// Output : 13
// Explanation : The respective binary number is sum up with the multiplied power of 2 to obtain the respective decimal number.


class Main{

    // ============================ Approach ===================================

        private static String reverseString(String str){

            StringBuilder sb = new StringBuilder(str);

            int start = 0, end = sb.length()-1;

            while(start <= end){
                char temp = sb.charAt(start);

                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);

                start++;
                end--;
            }

            return sb.toString();
        }

        public static String convertIntoBinary(int num){

            StringBuilder sb = new StringBuilder();

            int number = num;

            while(number != 0){

                if(number % 2 == 1) sb.append("1");
                else sb.append("0");

                number/=2;
            }

            return reverseString(sb.toString());

        }

    public static void main(String[] args){
        
        int num = 13;

        String result = convertIntoBinary(num);

        System.out.println(result);

    }
}
