// Problem Statement: Given two integers n and i, Make sure that the respective ith Bit need to be toggle(change to other value).

// Example 1:

// Input : N = 10, i = 1
// Output : 1000
// Explanation : Initially the 1th bit will be 1 for 10, after making the 1th bit to toggle then it will be 0.

// Example 2:

// Input : N = 13, i = 2
// Ouput : 1001
// Explanation : Initially the ith bit will be one, after making the ith bit to toggle then it will be 0.

class Main {

    public static int toggleithBit(int number, int bitNumber){

        int toggleNumber = number ^ (1 << i);

        return toggleNumber;


    }
    public static void main(String[] args) {
        
        int number = 13;
        int bitNumber = 1;

        toggleithBit(number, bitNumber);


    }
}
