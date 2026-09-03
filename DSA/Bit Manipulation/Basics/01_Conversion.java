// Problem Statement : Perform conversion of a decimal number into a binary number and vice versa.

//Example :

// Input : num = 13
// Output : 1101
// Explanation : The respective decimal number is divided by 2 to obtain the respective binary number`

class Main{

    // ============================ Approach ===================================

        private static String reverseString(String sb){

            int start = 0, end = sb.length()-1;

            char startStr = '\0';
            char endStr = '\0';


            while(start <= end){
                char temp = sb.charAt(start);
                endStr = sb.charAt(end);
                startStr = temp;
                start++;
                end--;
            }

            return sb;
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
