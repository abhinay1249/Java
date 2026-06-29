// Problem Statement: Given the head of a singly linked list containing integers, shift the elements of the linked list to the
//  right by k places and return the head of the modified list. 
// Do not change the values of the nodes, only change the links between nodes.

// Example 1:

// Input : head -> 1 -> 2 -> 3 -> 4 -> 5, k = 2
// Output : head -> 4 -> 5 -> 1 -> 2 -> 3
// Explanation :List after 1 shift to right: head -> 5 -> 1 -> 2 -> 3 -> 4.
// List after 2 shift to right: head -> 4 -> 5 -> 1 -> 2 -> 3.

// Example 2:

// Input : head -> 1 -> 2 -> 3 -> 4 -> 5, k = 4
// Output :head -> 2 -> 3 -> 4 -> 5 -> 1
// Explanation :List after 1 shift to right: head -> 5 -> 1 -> 2 -> 3 -> 4.
// List after 2 shift to right: head -> 4 -> 5 -> 1 -> 2 -> 3.
// List after 3 shift to right: head -> 3 -> 4 -> 5 -> 1 -> 2.
// List after 4 shift to right: head -> 2 -> 3 -> 4 -> 5 -> 1. 


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

    // ============================ Convert Array into Linked List =========================
    
        private static Node convert(int[] nums){

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

    // =============================== Print Linked List ====================================

        private static void print(Node head){

            Node temp = head;

            while(temp != null){
                System.out.print(temp.data +" ");
                temp = temp.next;
            }
        }

    // =============================== Brute Force Approach =================================

        private static Node reverseLL(Node head){

            Node temp = head;
            Node prevNode = null;
            Node front = null;

            while(temp != null){
                front = temp.next;
                temp.next = prevNode;
                prevNode = temp;
                temp = front;
            }

            return prevNode;
        }

        private static int findLength(Node head){

            Node temp = head;
            int count = 0;

            while(temp != null){
                count++;
                temp = temp.next;
            }
            return count;
        }

        public static Node rotateLL(Node head, int k){

            if(head == null || head.next == null){
                return head;
            }

            int length = findLength(head);

            k %= length;

            if(k==0){
                return head;
            }
            Node reverseHead = reverseLL(head);

            Node temp = reverseHead;
            Node newHead = null;                                    // T.C = O(5N), S.C = O(1)
            Node nextNode = null;

            int count = 1;

            while(temp != null){
                if(count == k){
                    nextNode = temp.next;
                    temp.next = null;
                    newHead = reverseLL(reverseHead);
                    reverseLL(nextNode);
                    break;
                }
                count++;
                temp = temp.next;
            }
            reverseHead.next = head;

            return newHead;
        }

    // =============================== Optimal Approach ========================================

        public static Node rotateLL_1(Node head, int k){
                
            Node tail = head;
                
            int length = 1;
                
            while(tail.next != null){
                length++;
                tail = tail.next;
            }

            k %= length;

            if(k == 0){
                return head;
            }                                           // T.C = O(2N), S.C = O(1)

            tail.next = head;

            Node temp = head;
            int counter = 0;

            while(temp != null){
                counter++;
                if(counter == length - k){
                    head = temp.next;
                    temp.next = null;
                    break;
                }
                temp = temp.next;
            }
        
            return head;
        }

    public static void main(String[] args) {
        int[] nums = {10,20};
        int k = 1;
        
        Node head = convert(nums);
        Node result = rotateLL(head,k);
        print(result);

        System.out.println();

        Node head_1 = convert(nums);
        Node result_1 = rotateLL_1(head_1,k);
        print(result_1);
    }
}