// Problem Statement: Given the head of a doubly linked list with its values "Sorted" in non-decreasing order. 
// Remove all duplicate occurrences of any value in the list so that only distinct values are present in the list.

// Return the head of the modified linked list.

// Example 1:

// Input: head -> 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5
// Output: head -> 1 <-> 3 <-> 4 <-> 5
// Explanation: Duplicate occurences of 1 and 3 are deleted

// Example 2:

// Input: head -> 1 <-> 1 <-> 1 <-> 1 <-> 1 <-> 2
// Output: head -> 1 <-> 2
// Explanation: All duplicate occurences of 1 is deleted


class Node{

    int data;
    Node next;
    Node prev;
    
    Node(int data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    // =========================== Convert Array into Linked List ========================

        private static Node convert(int[] nums){

            int length = nums.length;
            Node head = new Node(nums[0]);
            Node prevNode = head;

            for(int index = 1 ; index < length ; index++){
                Node temp = new Node(nums[index]);
                prevNode.next = temp;
                prevNode = temp;
            }
            return head;
        }
    
    // ============================== Print the Linked List ===============================

        private static void print(Node head){

            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

    // ============================== Only Approach =======================================

        public static Node removeDuplicates(Node head){

            if(head == null || head.next == null){
                return head;
            }

            Node temp = head;
            Node nextNode = temp;

            while(temp != null && temp.next != null){
                nextNode = temp.next;
                while(nextNode != null && nextNode.data == temp.data){
                    nextNode = nextNode.next;
                }
                temp.next = nextNode;                       
                if(nextNode!=null){
                    nextNode.prev = temp;
                }                                               // T.C = O(N), S.C = O(1)

                temp = nextNode;
            }
            return head;
        }
    public static void main(String[] args) {
        
        int[] nums = {1,1,2,3,3,4,4,4,5,5,5,5,5,5,5,5,6};
        
        Node head = convert(nums);
        Node result = removeDuplicates(head);
        print(result);
    }
}