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