// Problem Statement: Given the head of a singly linked list, write a program to reverse the linked list
// and return the head pointer to the reversed list.

// Input-  LL: 1   3   2   4 
// Output: 4
// Explanation: After reversing the linked list, 
// the new head will point to the tail of the old linked list.

import java.util.*;

class Node{
    int data;
    Node nextptr;
    
    Node(int data, Node nextptr){
        this.data = data;
        this.nextptr = nextptr;
    }
    
    Node(int data){
        this.data = data;
        this.nextptr = null;
    }

    // ================================ Convert Array into Linked List ===========================

        private static Node convert(int[] nums){
            int length = nums.length;
            Node head = new Node(nums[0]);
            Node mover = head;
            for(int i = 1 ; i < length ; i++){
                Node temp = new Node(nums[i]);
                mover.nextptr = temp;
                mover= temp;
            }
            return head;
        }

    // ================================ Brute Force Approach ========================================

        public Node reverseList(Node head) {
            if(head == null || head.nextptr == null){
                return head;
            }

            Node temp = head;
            Stack<Integer> st = new Stack<Integer>();

            while(temp != null){
                st.add(temp.data);
                temp = temp.nextptr;
            }

            temp = head;

            while(temp != null){
                temp.data = st.peek();
                st.pop();
                temp = temp.nextptr;
            }

            return head;
        }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        
        Node head_1 = convert(nums);


    }
}
