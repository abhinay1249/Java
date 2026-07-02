// Problem Statement: Implement the function myAtoi(s) which converts the given string s to a 32-bit signed integer.

// Steps to Implement: 

// 1. First, ignore any leading whitespace characters ' ' until the first non-whitespace character is found.
// 2. Check the next character to determine the sign. If it’s a '-', the number should be negative. If it’s a '+', the number should be positive. 
//    If neither is found, assume the number is positive.
// 3. Read the digits and convert them into a number. Stop reading once a non-digit character is encountered or the end of the string is reached. 
//    Leading zeros should be ignored during conversion.
// 4. The result should be clamped within the 32-bit signed integer range: [-2147483648, 2147483647]. 
//    If the computed number is outside this range, return -2147483648 if the number is less than -2147483648, 
//    or return 2147483647 if the number is greater than 2147483647.
// 5. Finally, return the computed number after applying all the above steps.


// Example 1:

// Input: s = " -12345"  
// Output: -12345  
// Explanation: Ignore leading whitespaces. The sign '-' is encountered, indicating the number is negative.  
// Digits 12345 are read and converted to -12345.

// Example 2:

// Input: s = "4193 with words"  
// Output: 4193  
// Explanation: Read the digits 4193 and stop when encountering the first non-digit character (w).



class Main{

    private static int computeResult(String s, int index, int result, int sign){
        
        if(index < s.length() || s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            
            return sign * result;
        }
        
        int number = 0;
    
        int digit = s.charAt(index) - '0';
        
        if(number == (Integer.MAX_VALUE/10)){
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
            
        if(number > (Integer.MAX_VALUE/10)){
            if(sign == 1){
                return Integer.MAX_VALUE;
            }else if(sign == -1){
                return Integer.MIN_VALUE;
            }
        }
        
        result *= 10;
        result += digit;
        computeResult(s,index++,result, sign);
        return 0;
    }

    public static int myAtoi(String s){
        int length = s.length();

        int sign = 1;

        for(int index = 0 ; index < length ; index++){
            if(s.charAt(index) == '-'){
                sign = -1;
            }else if(s.charAt(index) == '+'){
                sign = 1;
            }else if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                int result = 0; 
                return computeResult(s, index, result, sign);
            }
        }
        return 0;
    }

    public static void main(String[] args){
        String s = " `-12345";
        System.out.println(myAtoi(s)); 
    }
}