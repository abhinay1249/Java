// Problem Statement: Given a linked list, sort its nodes based on the data value in them. Return the head of the sorted linked list.

// Examples

// Input: 3->4->2->1->5 
// Output: 1->2->3->4->5

// Explanation: The input linked list when sorted from [3, 4, 2, 1, 5] results in a linked list with values [1, 2, 3, 4, 5].

// Input: 40->20->60->10->50->30
// Output: 10->20->30->40->50->60

// Explanation: The input linked list when sorted from [40, 20, 60, 10, 50, 30] results in a linked list with values [10, 20, 30, 40, 50, 60].


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

    // ============================== Print the Linked List ====================================

        public static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

    // ============================== Brute Force Approach ======================================

        public static Node sortList(Node head) {

            if(head == null || head.next == null){
                return head;
            }

            Node temp = head;
            List<Integer> al = new ArrayList<>();

            while(temp != null){
                al.add(temp.data);
                temp = temp.next;                               // T.C = O(N) + O(N LOG N) + O(N) , S.C = O(N)
            }

            Collections.sort(al);
            temp = head;

            int index = 0;

            while(temp != null){
                temp.data = al.get(index);
                index++;
                temp = temp.next;
            }
            return head;
        }

    // ============================== Optimal Approach ======================================
        
        public static Node sortList_1(Node head) {
            return head;
        }

   public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        
        Node head = convert(nums);
        
        Node result = sortList(head);
        
        print(result);

        System.out.println();

        Node head_1 = convert(nums);
        
        Node result_1 = sortList_1(head_1);
        
        print(result_1);


    }
}