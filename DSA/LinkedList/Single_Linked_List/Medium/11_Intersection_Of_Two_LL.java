// Problem Statement: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
// If the two linked lists have no intersection at all, return null.

// Example 1:
// Input: List 1 = [1,3,1,2,4], List 2 = [3,2,4]

// List A: 1 → 3 → 1
//                    ↘
//                      2 → 4
//                    ↗
// List B:     3 → →

// Output: 2
// Explanation: Here, both lists intersecting nodes start from node 2.

// Example 2:
// Input: List1 = [1,2,7], List 2 = [2,8,1]

// List A: 1 → 2 → 7

// List B: 2 → 8 → 1

// Output: Null
// Explanation: Here, both lists do not intersect and thus no intersection node is present.

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
    
    // =========================== Convert Array into Linked List ===============================

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

    // ================================ Brute Force Approach =====================================

        public static Node intersectionNode(Node headA, Node headB) {

            Node temp = headA;
            Map<Node,Integer> hm = new HashMap<>();

            while(temp != null){
                hm.put(temp,1);
                temp = temp.next;
            }

            temp = headB;
            Node intersectionPoint = null;

            while(temp != null){
                if(hm.containsKey(temp)){
                    intersectionPoint = temp;
                    break;
                }
                temp = temp.next;
            }

            if(intersectionPoint != null){
                return intersectionPoint;
            }
            return null;
        }
    public static void main(String[] args) {
        int[] nums1 = {1,9,1,2,4};
        int[] nums2 = {3,2,4};
        
        Node head1 = convert(nums1);
        Node head2 = convert(nums2);
        
        Node result = intersectionNode(head1, head2);
        
        System.out.print(result);
    }
}