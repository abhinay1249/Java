// Problem Statement: Implement the function myAtoi(s) which converts the given string s to a 32-bit signed integer.
// Steps to Implement: 
// 1. First, ignore any leading whitespace characters ' ' until the first non-whitespace character is found.
// 2. Check the next character to determine the sign. If it’s a '-', the number should be negative. 
//      If it’s a '+', the number should be positive. If neither is found, assume the number is positive.
// 3. Read the digits and convert them into a number. 
//      Stop reading once a non-digit character is encountered or the end of the string is reached. Leading zeros should be ignored during conversion.
// 4. The result should be clamped within the 32-bit signed integer range: [-2147483648, 2147483647]. 
//      If the computed number is outside this range, return -2147483648 if the number is less than -2147483648, or return 2147483647 if the number is greater than 2147483647.
// 5. Finally, return the computed number after applying all the above steps


// Example 1:
// Input:
//  s = " -12345"  
// Output:
//  -12345  
// Explanation:
  
// Ignore leading whitespaces.  
// The sign '-' is encountered, indicating the number is negative.  
// Digits 12345 are read and converted to -12345.

// Example 2:
// Input:
//  s = "4193 with words"  
// Output:
//  4193  
// Explanation:
  
// Read the digits 4193 and stop when encountering the first non-digit character (w).


class Main {
    
    // ======================= Optimal Approach ===============================

        private static boolean isDigit(char ch){
            return ch >= '0' && ch <= '9';    
        }

        public static int stringToInteger(String s){
            int length = s.length();

            if(length == 0){
                return 0;
            }

            int index = 0;                                          

            while(index < length && s.charAt(index)==' '){
                index++;
            }

            int sign = 1;

            if(index < length){
                if(s.charAt(index)=='-'){
                    sign = -1;
                    index++;
                }else if(s.charAt(index)=='+'){
                    index++;                                    // T.C = O(N), S.C = O(1)
                }
            }

            int num = 0;

            while(index < length && isDigit(s.charAt(index))){
                int digit = s.charAt(index) - '0';

                if(num == Integer.MAX_VALUE/10){
                    if(sign == 1){
                        if(digit >= 7){
                            return Integer.MAX_VALUE;
                        }
                    }else if(sign == -1){
                        if(digit >= 8){
                            return Integer.MIN_VALUE;
                        }
                    }
                }

                if(num > Integer.MAX_VALUE/10){
                    if(sign == 1){
                        return Integer.MAX_VALUE;
                    }else if(sign == -1){
                        return Integer.MIN_VALUE;
                    }
                }

                num = num * 10 + digit;
                index++;
            }

            return sign * num;
        }
    
    public static void main(String[] args) {
        String s ="  -424153abueath";
        int result = stringToInteger(s);
        System.out.println(result);
    }
}