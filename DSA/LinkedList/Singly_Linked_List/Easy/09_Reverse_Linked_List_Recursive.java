// Problem Statement: Given the head of a singly linked list, write a program to reverse the linked list
// and return the head pointer to the reversed list.

// Example 1:

// Input-  LL: 1 ->  3 ->  2 -> 4 -> null
// Output: 4
// Explanation: After reversing the linked list, the new head will point to the tail of the old linked list.

// Example 2:

// Input-  LL: 1 ->  2 ->  3 ->  4 -> 5 -> null
// Output: 5
// Explanation: After reversing the linked list, the new head will point to the tail of the old linked list.


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

    // ================================ Print Singly Linked List =================================
    
        private static void print(Node head){

            Node dll = head;

            while(dll != null){
                System.out.print(dll.data + " ");
                dll = dll.nextptr;
            }
        }

    // ================================ Recursive Approach ========================================

        private static Node reverseLL(Node head) {
            if(head == null || head.nextptr == null){
                return head;
            }

            Node newHead = reverseLL(head.nextptr);                     // T.C = O(N), S.C = O(N)
            Node front = head.nextptr;
            front.nextptr = head;
            head.nextptr = null;

            return newHead;
        }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        Node head = convert(nums);
        
        Node result = reverseLL(head);
        
        print(result);

    }
}
