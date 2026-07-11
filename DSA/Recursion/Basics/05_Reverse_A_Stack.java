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

    private static void insertAtBottom(Stack<Integer> st, int number){

        if(st.isEmpty()){
            st.push(number);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, number);
        st.push(top);

    }

    public static Stack<Integer> reverseStack(Stack<Integer> st){
        
        if(st.isEmpty()){
            return st;
        }

        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
        return st;
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        Stack<Integer> st = reverseStack(stack);

        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }

    }
} 

