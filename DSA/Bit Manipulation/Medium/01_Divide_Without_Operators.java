// Problem Statement: Given the two integers, dividend and divisor. 
// Divide without using the mod, division, or multiplication operators and return the quotient.
// The fractional portion of the integer division should be lost as it truncates toward zero.
// As an illustration, 8.345 and -2.7335 would be reduced to 8 and -2 respectively.
// Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. 
// For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

// Example 1:

// Input : Dividend = 10, Divisor = 3
// Output : 3
// Explanation : 10/3 = 3.33, truncated to 3.

// Example 2:

// Input : Dividend = 7, Divisor = -3
// Output : -2
// Explanation : 7/-3 = -2.33, truncated to -2.

class Main {

    public static int divideWithoutOperators(int dividend, int divisor){
        
        if(dividend == divisor){
            return 1;
        }

        boolean sign = true;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long ans = 0;

        if(dividend >= 0 && divisor < 0) sign = false;
        if(dividend <= 0 && divisor > 0) sign = false;

        while(n >= d){
            int power = 0;

            while(n >= (d << (power+1))){
                power+=1;
            }

            ans += (1L << power);
            n-=(d << power);

        }


        return sign ? (int) ans : (int) -ans;
    }

    public static void main(String[] args) {

        int dividened = 10;
        int divisor = 3;

        int result = divideWithoutOperators(dividened, divisor);

        System.out.println(result);
        
    }
}