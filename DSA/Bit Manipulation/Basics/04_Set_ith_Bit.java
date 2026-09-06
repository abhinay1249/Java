// Problem Statement: Given two integers n and i, Make sure that the respective ith Bit need to be set.

// Example 1:

// Input : N = 10, i = 0
// Output : 1011
// Explanation : Initially the 0th bit will be 0 zero for 10, after making the 0th bit to be set then it will be 11 in decimal.

// Example 2:

// Input : N = 13, i = 1
// Ouput : 1111
// Explanation : Initially the ith bit will be 0 zero for 13, after making the ith bit to be set then it will be 15 in decimal.


class Main {

    // ================================ Brute Force Approach ====================================

        private static String reverseString(String number){

            StringBuilder sb = new StringBuilder(number);

            int start = 0, end = number.length()-1;

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
                if(number %2 == 1){
                    sb.append("1");
                }else{
                    sb.append("0");
                }
                number/=2;
            }

            return reverseString(sb.toString());

        }

        public static String setIthBit(int number, int bitNumber){

            String binaryNumber = convertIntoBinary(number);

            StringBuilder sb = new StringBuilder(binaryNumber);

            int length = binaryNumber.length()-1;

            for(int index = length ; index >= 0 ; index--){
                if((length - index) == bitNumber){
                    if(sb.charAt(index) == '0'){
                        sb.setCharAt(index, '1');
                    }else{
                        break;
                    }
                }
            }

            return sb.toString();
        }

    public static void main(String args[]){

        int number = 13;
        int bitNumber = 1;

        String num1 = convertIntoBinary(number);

        System.out.println(num1);

        String num2 = setIthBit(number, bitNumber);

        System.out.println(num2);

    }
}