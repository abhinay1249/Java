// Problem Statement : Given below there are few set of fundamental operations performed using Bit Manipulation.

// Example 1:

// Input : a = 6, b= 5
// Output : a = 5, b = 6
// Explanation : Swapped using Bit Manipulation

class Main{

    public static void swapTwoNumbers(int num1, int num2){

        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;

        System.out.println(num1);
        System.out.println(num2);

    }


    public static void main(String[] args) {

        int num_1 = 2;
        int num_2 = 10;
        
        swapTwoNumbers(num_1, num_2);

    }
}
