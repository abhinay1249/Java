// Problem Statement: Given two integers n and i, Make sure that the respective ith Bit need to be toggle(change to other value).

// Example 1:

// Input : N = 10, i = 1
// Output : 1000
// Explanation : Initially the 1th bit will be 1 for 10, after making the 1th bit to toggle then it will be 0.

// Example 2:

// Input : N = 13, i = 2
// Ouput : 1001
// Explanation : Initially the ith bit will be one, after making the ith bit to toggle then it will be 0.

class Main {

    // ======================================= Approach =======================================

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
                number/=2;

            }

            return reverseString(sb.toString());

        }

        public static int toggleithBit(int number, int bitNumber){

            int toggleNumber = number ^ (1 << bitNumber);                         // T.C = O(1), S.C = O(1)

            return toggleNumber;

        }
    public static void main(String[] args) {
        
        int number = 13;
        int bitNumber = 1;

        System.out.println(convertIntoBinary(number));

        int num = toggleithBit(number, bitNumber);

        String num1 = convertIntoBinary(num);

        System.out.println(num1);

    }
}
