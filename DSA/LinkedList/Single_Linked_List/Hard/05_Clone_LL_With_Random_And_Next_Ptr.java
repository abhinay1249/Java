// Problem Statement: Given a linked list where every node in the linked list contains two pointers:

// ‘next’ which points to the next node in the list.
// ‘random’ which points to a random node in the list or ‘null’.
// Create a ‘deep copy’ of the given linked list and return it.

// Example 1:

// Input: [[1, -1], [2, 0], [3, 4], [4, 1], [5, 2]]
// Output: 1 2 3 4 5, true
// Explanation: All the nodes in the new list have same corresponding values as original nodes.
// All the random pointers point to their corresponding nodes in the new list.
// 'true' represents that the nodes and references were created new.

// Example 2: 
// Input: [[5, -1], [3, -1], [2, 1], [1, 1]]
// Output: 5 3 2 1, true
// Explanation: All the nodes in the new list have same corresponding values as original nodes.
// All the random pointers point to their corresponding nodes in the new list.
// 'true' represents that the nodes and references were created new.
// [[5, -1], [3, -1], [2, -1], [1, -1]] will be incorrect, although it has the same values.

import java.util.*;

class Node{
    int data;
    Node next;
    Node random;
    
    Node(int data, Node next, Node random){
        this.data = data;
        this.next = next;
        this.random = random;
    }
    
    Node(int data){
        this.data = data;
        this.next = null;
        this.random = null;
    }

    // ============================ Print Linked List ===========================

        private static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data +" ");
                temp = temp.next;
            }
        }

    // ==================== Brute Force Approach ================================

        public static Node copyRandomList(Node head) {
            if(head == null){
                return head;
            }

            Node temp = head;
            Map<Node,Node> hm = new HashMap<>();

            while(temp != null){
                Node newNode = new Node(temp.data);                
                hm.put(temp,newNode);
                temp = temp.next;
            }

            temp = head;

            while(temp != null){
                Node copyNode = hm.get(temp);
                copyNode.next = hm.get(temp.next);
                copyNode.random = hm.get(temp.random);
                temp = temp.next;
            }
            return hm.get(head);        
        }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = head;

        Node copyHead = copyRandomList(head);
        print(copyHead);
    }
}