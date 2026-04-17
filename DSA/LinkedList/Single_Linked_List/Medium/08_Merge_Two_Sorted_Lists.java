// Problem Statement: You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted list. 
// The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.

// Example 1:
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Example 2:
// Input: list1 = [], list2 = []
// Output: []

// Example 3:
// Input: list1 = [], list2 = [0]
// Output: [0]

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

    // ============================== Convert Array into Linked List =======================

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

    // ============================== Print the Linked List ================================
    
        public static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }

    // ============================== Brute Force Approach ==================================
        
        private static Node convertintoLL(List<Integer> al){
            int length = al.size();
            
            Node head = new Node(al.get(0));
            Node mover = head;
            
            for(int index = 1; index < length ; index++){
                Node temp = new Node(al.get(index));
                mover.next = temp;
                mover = temp;
            }
            return head;
        }

        public static Node mergeTwoLists(Node list1, Node list2) {
            if(list1 == null && list2 == null){
                return null;
            }

            Node temp1 = list1;
            Node temp2 = list2;
            List<Integer> al = new ArrayList<>();

            while(temp1 != null){
                al.add(temp1.data);
                temp1=temp1.next;                       // T.C = O(N) + O(M) + O(N LOG N) + O(N), S.C = O(N) + O(N)
            }

            while(temp2 != null){
                al.add(temp2.data);
                temp2=temp2.next;
            }

            Collections.sort(al);

            Node head = convertintoLL(al);

            return head;
        }

    // ============================== Optimal Approach ==================================

        public static Node mergeTwoLists_1(Node list1, Node list2) {
            
            Node dummyNode = new Node(-1);

            Node temp = dummyNode;

            Node temp1 = list1;
            Node temp2 = list2;

            while(temp1 != null && temp2 != null){
                if(temp1.data < temp2.data){
                    temp.next = temp1;
                    temp = temp.next;
                    temp1 = temp1.next;
                }else{
                    temp.next = temp2;
                    temp = temp.next;                           // T.C = O(N) + O(M), S.C = O(1)
                    temp2 = temp2.next; 
                }
            }

            if(temp1 != null){
                temp.next = temp1;
            }else if(temp2 != null){
                temp.next = temp2;
            }
            
            return dummyNode.next;
        }
    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};

        Node head1 = convert(nums1);
        Node head2 = convert(nums2);

        Node mergedHead = mergeTwoLists(head1, head2);

        print(mergedHead);

        System.out.println();

        Node head3 = convert(nums1);
        Node head4 = convert(nums2);

        Node mergedHead_1 = mergeTwoLists_1(head3, head4);
        print(mergedHead_1);
    }
}   