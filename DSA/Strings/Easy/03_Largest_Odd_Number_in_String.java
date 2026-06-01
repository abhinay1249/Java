// Problem Statement: Given a string s, representing a large integer, the task is to return 
// the largest-valued odd integer (as a string) that is a substring of the given string s.
// The number returned should not have leading zero's. But the given input string may have leading zero.

// Example 1

// Input: s = "5347"
// Output: "5347"
// Explanation: The odd numbers formed by the given string are → 5, 3, 53, 347, 5347. 
// The largest odd number without leading zeroes is 5347.

// Example 2

// Input: s = "0214638"
// Output: "21463"
// Explanation: The odd numbers formed by the string are → 1, 3, 21, 63, 463, 1463, 21463. 
// We can't use numbers starting with 0, so the largest valid odd number is 21463.


class Main {

    // ======================= Brute-Force Approach ===============================                                                     

        public static String largestOddNumberInString(String s){

            int pointer = s.length()-1;
            int idx = -1;

            while(pointer >= 0){
                char ch = s.charAt(pointer);
                int number = Integer.valueOf(ch);           

                if(number % 2 == 0){
                    pointer--;
                }else{                                               // T.C = O(N) +  O(N), S.C = O(N)
                    idx = pointer;
                    break;
                }
            }

            StringBuilder word = new StringBuilder();

            for(int index = 0 ; index <= idx ; index++){
                char ch = s.charAt(index);

                word.append(ch);
            }
            
            return word.toString().replaceFirst("^0+","");
        }

    // ======================= Optimal Approach - 1===============================

        public static String largestOddNumberInString_1(String s){
            
            int index = -1;
            int pointer = s.length()-1;
            while(pointer >= 0){
                char ch = s.charAt(pointer);
                int num = ch - '0';
                if(num % 2 == 0){
                    pointer--;                                      // T.C = O(N), S.C = O(1)
                }else{
                    index = pointer;
                    break;
                }
            }    
            return s.substring(0,index+1).replaceFirst("^0+","");
        }

    // ======================= Optimal Approach  - 2===============================

        public static String largestOddNumberInString_2(String s){
            
            int index = -1;
            int pointer = s.length()-1;
            while(pointer >= 0){
                char ch = s.charAt(pointer);
                int num = ch - '0';
                if(num % 2 == 0){
                    pointer--;                                      // T.C = O(N), S.C = O(1)
                }else{
                    index = pointer;
                    break;
                }
            }    
            return s.substring(0,index+1).replaceFirst("^0+","");
        }

    public static void main(String[] args) {
       String s = "002643183929089473";
       String result = largestOddNumberInString_1(s);
       System.out.println(result);
    }
}