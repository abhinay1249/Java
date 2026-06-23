// Problem Statement: Given a linked list and an integer N, 
// the task is to delete the Nth node from the end of the linked list and print the updated linked list.

// Example 1:

// Input:  5->1->2, N=2
// Output: 5->2
// Explanation: The 2nd node from the end of the linked list is 1. Therefore, we get this result after removing 1 from the linked list.

// Example 2:

// Input:  1->2->3->4->5, N=3
// Output: 1->2->4->5
// Explanation: The 3rd node from the end is 3, therefore, we remove 3 from the linked list.


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
    
    // =========================== Convert Array into Linked List ==========================

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

    // ========================== Print the Linked List ====================================

        public static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data+ " ");
                temp = temp.next;
            }
        }

    // ========================= Brute Force Approach =====================================

        public static Node removeNthNodeFromEnd(Node head, int n){

            Node temp = head;
            int count = 0;

            while(temp != null){
                count++;
                temp = temp.next;
            }

            int result = count - n;

            if(result == 0){
                return head.next;                           // T.C = O(Length) + O(Length - N) = O(2 * Length), S.C = O(1)
            }

            temp = head;

            while(temp != null){
                result--;
                if(result == 0){
                    break;
                }
                temp = temp.next;
            }
            temp.next = temp.next.next;
            
            return head;
        }

    // ================================ Optimal Approach =====================================

        public static Node removeNthNodeFromEnd_1(Node head, int n){

            Node fast = head;
            Node slow = head;

            for(int index = 0 ; index < n ; index++){
                fast = fast.next;
            }

            if(fast == null){
                return head.next;                               // T.C = O(Length), S.C = O(1)
            }

            while(fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;

            return head;
        }
    
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int n = 6;
        
        Node head = convert(nums);
        
        Node result = removeNthNodeFromEnd(head,n);
        print(result);

        System.out.println();
        
        Node head_1 = convert(nums);
        
        Node result_1 = removeNthNodeFromEnd_1(head_1,n);
        print(result_1);
    }
}