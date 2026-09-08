// Problem Statement : Given the problem statement, Where the respective right most set bit is removed (changed to zero).

// Example 1:

// Input : 
// Output :
// Explanation : 

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
                number/=2;

            }

            return reverseString(sb.toString());                            // T.C = O(5 log N), .SC = O(2 log N)

        }

        public static String removeTheLastSetBit(int number){

            String binaryNumber = convertIntoBinary(number);
            
            StringBuilder sb = new StringBuilder(binaryNumber);

            int length = binaryNumber.length()-1;

            for(int index = length ; index >= 0 ; index--){
                if(binaryNumber.charAt(index) == '1'){
                    sb.setCharAt(index, '0');
                    break;
                }
            }

            return sb.toString();

        }

    // ================================== Optimal Approach ====================================

        public static String removeTheLastSetBit_1(int number){

            int removeLastSet = number & (number-1);

            return convertIntoBinary(removeLastSet);

        }


    public static void main(String args[]){

        int number = 8;

        System.out.println(convertIntoBinary(number));

        String result = removeTheLastSetBit(number);

        System.out.println(result);

        System.out.println(convertIntoBinary(number));

        String result1 = removeTheLastSetBit_1(number);

        System.out.println(result1);




    }
}