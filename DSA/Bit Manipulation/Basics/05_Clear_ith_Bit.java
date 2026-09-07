// Problem Statement: Given two integers n and i, Make sure that the respective ith Bit need to be clear(need to be zero).

// Example 1:

// Input : N = 10, i = 1
// Output : 1000
// Explanation : Initially the 1th bit will be 1 for 10, after making the 1th bit to be clear then it will be 8 in decimal.

// Example 2:

// Input : N = 13, i = 2
// Ouput : 1001
// Explanation : Initially the ith bit will be 1 zero for 13, after making the ith bit to be clear then it will be 9 in decimal.

class Main {

    // ================================ Brute Force Approach =====================================

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

        public static String clearithBit(int number, int bitNumber){

            String binaryNumber = convertIntoBinary(number);

            StringBuilder sb = new StringBuilder(binaryNumber);

            int length = binaryNumber.length()-1;

            for(int index = length ; index >= 0; index--){
                if((length - index) == bitNumber){
                    if(sb.charAt(index) == '1'){                        // T.C = O(5 log N), S.C = o(2 Log N)
                        sb.setCharAt(index, '0');
                    }else{
                        break;
                    }
                }
            }

            return sb.toString();

        }
    
    public static void main(String[] args) {
        
        int number = 13;
        int bitNumber = 0;

        System.out.println(convertIntoBinary(number));

        String num1 = clearithBit(number, bitNumber);

        System.out.println(num1);


    }
}
