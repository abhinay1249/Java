// Problem Statement: Given the head of a singly linked list. Group all the nodes with odd indices followed by all the nodes with even indices and return the reordered list. 
// Consider the 1st node to have index 1 and so on. 
// The relative order of the elements inside the odd and even group must remain the same as the given input.

// Examples

// Input: 1 → 2 → 3 → 4 → 5 → 6 → Null
// Output: 2 → 4 → 6 → 1 → 3 → 5 → Null
// Explanation : Odd Nodes in LinkedList are 1,3,5 and Even Nodes in LinkedList are 2,4,6
// In Modified LinkedList all even Nodes comes before all Odd Nodes. So Modified LinkedList looks like 2→4→6→1→3→5→Null. Order of even and odd Nodes is 
// maintained in modified LinkedList.

// Input: 1 → 3 →5 → Null
// Output: 1 → 3 → 5 → Null
// Explanation: As there are no Even Nodes in LinkedList, The Modified LinkedList is same as Original LinkedList.

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

    // ============================== Print the  Linked List ====================================

        public static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }

    // ================================ Brute Force Approach =====================================

        public static Node segregateNodes(Node head){

            if(head == null || head.next == null){
                return head;
            }

            Node temp = head;

            List<Integer> al = new ArrayList<>();

            while(temp != null && temp.next != null){
                al.add(temp.data);
                temp = temp.next.next;
            }

            if(temp != null){
                al.add(temp.data);
            }                                                       // T.C = O(N/2) + O(N/2) + O(N) = O(2N), S.C = O(N)

            temp = head.next;

            while(temp != null && temp.next != null){
                al.add(temp.data);
                temp = temp.next.next;
            }
            if(temp != null){
                al.add(temp.data);
            }

            int index = 0;
            temp = head;

            while(temp != null){
                temp.data = al.get(index);
                index++;
                temp = temp.next;
            }

            return head;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        
        Node head = convert(nums);
        
        Node result = segregateNodes(head);
        print(result);
    }
}