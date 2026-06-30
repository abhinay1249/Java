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


import java.util.HashMap;
import java.util.Map;

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

    // ============================ Print Linked List ======================

        private static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data +" ");
                temp = temp.next;
            }
        }

    // ==================== Brute Force Approach ============================

        public static Node copyRandomList(Node head) {

            if(head == null){
                return head;
            }

            Node temp = head;
            Map<Node,Node> hm = new HashMap<>();

            while(temp != null){
                Node newNode = new Node(temp.data);                // T.C = O(N) + O(N), S.C = O(N) + O(N)
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

    // ==================== Optimal Approach ====================================

        private static Node insertCopyNodes(Node head){

            Node temp = head;

            while(temp != null){
                Node copyNode = new Node(temp.data);
                copyNode.next = temp.next;
                temp.next = copyNode;
                temp = temp.next.next;
            }
            return temp; 
        }

        private static Node connectRandomPtrs(Node head){
        
            Node temp = head;

            while(temp != null){
                Node copyNode = temp.next;
                if(temp.random != null){
                    copyNode.random = temp.random.next;         // T.C = O(3N), S.C = O(N)
                }else{
                    copyNode.random = null;
                }
                temp = temp.next.next;
            }
            return temp;
        }

        private static Node connectNextPtrs(Node head){

            Node temp = head;
            Node dummyNode = new Node(-1);
            Node temp1 = dummyNode;

            while(temp != null){
                temp1.next = temp.next;
                temp1 = temp.next;
                temp.next = temp.next.next;
                temp = temp.next;
            }
            return dummyNode.next;
        }

        public static Node copyRandomList_1(Node head) {
            
            if(head == null){
                return null;
            }

            insertCopyNodes(head);
            connectRandomPtrs(head);
            return connectNextPtrs(head);
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

        System.out.println();

        Node copyHead_1 = copyRandomList_1(head);
        print(copyHead_1);

    }
}