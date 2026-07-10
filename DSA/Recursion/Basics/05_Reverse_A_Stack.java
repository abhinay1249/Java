// Problem Statement: You are given a stack of integers. Your task is to reverse the stack using recursion.
// You may only use standard stack operations (push, pop, top/peek, isEmpty).
// You are not allowed to use any loop constructs or additional data structures like arrays or queues.


// Example 1:

// Input: stack = [4, 1, 3, 2]  
// Output: [2, 3, 1, 4]
// Explanation: The numbers present in the stack need to be reversed and has to be present within the stack itself.

// Example 2:

// Input: stack = [10, 20, -5, 7, 15]  
// Output: [15, 7, -5, 20, 10]
// Explanation: The numbers present in the stack need to be reversed and has to be present within the stack itself.

import java.util.Stack;

class Main{
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(10);
        stack.push(20);
        stack.push(-5);
        stack.push(7);
        stack.push(15);
        stack.push(12);

        
    }
} 

