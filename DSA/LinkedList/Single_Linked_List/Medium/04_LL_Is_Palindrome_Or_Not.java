// Problem Statement: Given the head of a singly linked list representing a positive integer number. 
// Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. 
// Check whether the linked list values form a palindrome or not. 
// Return true if it forms a palindrome, otherwise, return false.

// A palindrome is a sequence that reads the same forward and backwards.

// Example 1:
// Input: 3 -> 7 -> 5 -> 7 -> 3
// Output: true
// Explanation: 37573 is a palindrome.

// Example 2:
// Input: 1 -> 1 -> 2 -> 1
// Output: false
// Explanation: 1121 is not a palindrome.

import java.util.*;

class Node{
    
    int data;
    Node next;
    
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    
    Node(int data){
        this.data = data;
        this.next = null;
    }
    
    // ============================== Convert Array into Linked List ==========================

        public static Node convert(int[] nums){
            int length = nums.length;

            Node head = new Node(nums[0]);

            Node mover = head;

            for(int index = 1 ; index < length ; index++){
                Node temp = new Node(nums[index]);
                mover.next = temp;
                mover = temp;
            }
            return head;
        }

    // ================================ Brute Force Approach ===================================

        public static boolean isPalindrome(Node head){

            if(head.next == null){
                return true;
            }

            Node temp = head;
            Stack<Integer> st = new Stack<>();

            while(temp != null){
                st.add(temp.data);
                temp = temp.next;
            }

            temp = head;                                        // T.C = O(N) + O(N), S.C = O(N)

            while(temp != null){
                int num = st.peek();
                if(num != temp.data){
                    return false;
                }
                st.pop();
                temp = temp.next;
            }

            return true;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        
        Node head = convert(nums);
        
        boolean result = isPalindrome(head);
        System.out.println(result);
    }
}