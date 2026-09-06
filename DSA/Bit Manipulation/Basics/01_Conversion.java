// Problem Statement : Perform conversion of a decimal number into a binary number and vice versa.

// Example 1:

// Input : num = 13
// Output : 1101
// Explanation : The respective decimal number is divided by 2 to obtain the respective binary number.

// Example 2:

// Input : Binary = 1101
// Output : 13
// Explanation : The respective binary number is sum up with the multiplied power of 2 to obtain the respective decimal number.


class Main {

    // ============================ Approach [Decimal To Binary] ===================================

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

    // ============================ Brute Force Approach [Convert Binary into Decimal] ===================================

        private static int powerOfNumber(int power){
            
            if(power == 0){
                return 1;
            }

            int value = 1;

            for(int index = power ; index > 0 ; index--){
                value *= 2;
            }

            return value;

        }

        public static int convertIntoDecimal(String str){

            int number = 0;

            int length = str.length();
            int power = 0;

            for(int counter = length - 1 ; counter >= 0 ; counter--){

                int value = str.charAt(counter) - '0';

                int powerValue = powerOfNumber(power++);

                number+= (value * powerValue);

            }

            return number;

        }

    // ============================ Optimal Approach [Convert Binary into Decimal] ===================================

        public static int convertIntoDecimal_1(String binaryNumber){

            int length = binaryNumber.length();

            int number = 0;

            int power = 1;

            for(int index = length - 1 ; index >= 0 ; index--){

                if(binaryNumber.charAt(index) == '1'){
                    number+=power;
                }

                power *= 2;

            }

            return number;

        }

    public static void main(String[] args){
        
        int num = 13;

        String decimalNum = convertIntoBinary(num);

        System.out.println(decimalNum);

        String binaryNum = "1101";

        int decimalNumber = convertIntoDecimal(binaryNum);

        System.out.println(decimalNumber);

        int decimalNumber_1 = convertIntoDecimal_1(binaryNum);

        System.out.println(decimalNumber_1);

    }
}
