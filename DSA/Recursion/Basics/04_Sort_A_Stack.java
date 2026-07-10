// Problem Statement: You are given a stack of integers. 
// Your task is to sort the stack in descending order using recursion, such that the top of the stack contains the greatest element. 
// You are not allowed to use any loop-based sorting methods (e.g., quicksort, mergesort). 
// You may only use recursive operations and the standard stack operations (push, pop, peek/top, and isEmpty).

// Example 1:

// Input: stack = [4, 1, 3, 2]
// Output: [4, 3, 2, 1]
// Explanation: After sorting, the largest element (4) is at the top, and the smallest (1) is at the bottom.

// Example 2:

// Input: stack = [1]
// Output: [1]
// Explanation: A single-element stack is already sorted.

import java.util.Stack;

class Main{

    private static void insertIntoStack(int element, Stack<Integer> st){
        
        if(st.isEmpty() || st.peek() <= element){
            st.push(element);
            return;
        }

        int top = st.pop();
        insertIntoStack(element, st);                                       // T.C = O(N), S.C = O(N) due to recursive stack space
        st.push(top);

    }
    
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        
         if(stack.isEmpty() || stack.size() == 1){
            return stack;
        }

        int top = stack.pop();
        sortStack(stack);
        insertIntoStack(top,stack);
        return stack;
    }
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);
        st.push(5);

        Stack<Integer> stack = sortStack(st);

        while(st.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}