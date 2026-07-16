// Problem Statement: Given the head of a linked list of integers, determine the middle node of the linked list. 
// However, if the linked list has an even number of nodes, return the second middle node.

// Example 1:

// Input : LL: 1 -> 2 -> 3 -> 4 -> 5 
// Output : 3    
// Explanation : Node with value 3 is the middle node of this linked list.
                                         
// Example 2:

// Input: LL: 1 -> 2 -> 3 -> 4 -> 5 -> 6
// Output: 4
// Explanation : In this example, the linked list has an even number of nodes hence we return the second middle node which is 4.


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
    
    // ================================ Brute Force Approach =======================================

        public static Node middleElement(Node head){

            if(head == null || head.nextptr == null){
                return head;
            }

            Node current = head;

            int length = 0;

            while(current != null){
                length++;
                current = current.nextptr;                              // T.C = O(N + N/2), S.C = O(1)
            }

            int middleIndex = length/2;
            current = head;
            int counter = 0;

            while(current != null){
                counter++;
                if(counter == middleIndex){
                    break;
                }
                current = current.nextptr;
            }

            return current;

        }
    
    // ================================ Optimal Approach =======================================

        public static Node middleElement_1(Node head){

            if(head == null || head.nextptr == null){
                return head;
            }

            Node slowPtr = head;                                         // T.C = O(N/2), S.C = O(1)
            Node fastPtr = head;

            while(fastPtr != null && fastPtr.nextptr != null){
                slowPtr = slowPtr.nextptr;
                fastPtr = fastPtr.nextptr.nextptr;
            }

            return slowPtr;
        }
    
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        int[] nums_1 = {1,2,3,4,5,6};
        
        Node head_1 = convert(nums);
        Node head_2 = convert(nums_1);
        Node head_3 = convert(nums);
        Node head_4 = convert(nums_1);
    
        
        System.out.print("Result --> ");
        Node result = middleElement(head_1);
        System.out.print(result.data);
        
        System.out.println();
        
        System.out.print("Result --> ");
        Node result_1 = middleElement(head_2);
        System.out.print(result_1.data);

        System.out.println();

        System.out.print("Result --> ");
        Node result_2 = middleElement_1(head_3);
        System.out.print(result_2.data);
        
        System.out.println();
        
        System.out.print("Result --> ");
        Node result_3 = middleElement_1(head_4);
        System.out.print(result_3.data);
        
    }
}