// Problem Statement: Given the head of a singly linked list representing a positive integer number. 
// Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. 
// The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.

// The number will contain no leading zeroes except when the value represented is zero itself.

// Example 1:

// Input: 4->5->6
// Output: 4->5->7
// Explanation: 456 + 1 = 457

// Example 2:

// Input: 9->9->9
// Output: 1->0->0->0
// Explanation: 999 + 1 = 1000


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

    // ============================== Print the Linked List ================================

        private static void print(Node head){

            Node temp = head;

            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }

    // ============================== Iterative Approach ==================================

        private static Node reverse(Node head){

            Node temp = head;

            Node prev = null;

            Node front = null;

            while(temp != null){
                front = temp.next;
                temp.next = prev;
                prev = temp;
                temp = front;
            }
            return prev;
        }


        public static Node addOne(Node head){

            head = reverse(head);

            Node temp = head;

            int carry = 1;

            while(temp != null){
                temp.data = temp.data + carry;

                if(temp.data == 10){
                    temp.data = 0;
                    carry = 1;
                }else{
                    carry=0;                                        // T.C = O(N) + O(N) + O(N) = O(3N), S.C = O(1)
                    break;
                }
                temp = temp.next;
            }

            head = reverse(head);

            if(carry == 1){
                Node newHead = new Node(1);
                newHead.next = head;
                return newHead;
            }

            return head;
        }

    // ============================== Recursive Approach ==================================

        private static int recursiveAdd(Node head){

            Node temp = head;

            if(temp == null){
                return 1;
            }

            int carry = recursiveAdd(temp.next);
            temp.data = temp.data + carry;

            if(temp.data < 10){                                     // T.C = O(N), S.C = O(N) due to recursive stack space
                return 0;
            }
            temp.data = 0;
            return 1;
        }

        public static Node addOne_1(Node head){

            int carry = recursiveAdd(head);

            if(carry == 1){
                Node newHead = new Node(1);
                newHead.next = head;
                return newHead;
            }
            return head;
        }
        
    public static void main(String[] args) {
        int[] nums1 = {9,9,9};
        
        Node head = convert(nums1);
        
        Node result = addOne(head);
        
        print(result);

        System.out.println();

        Node head_1 = convert(nums1);
        
        Node result_1 = addOne_1(head_1);
        
        print(result_1);
        
    }
}

// Approach 1: Iterative Approach:
    // Pros: No space
    // Cons: Tampering of data and consumes more time.

// Approach 2: Recursive Approach:
    // Pros: No tampering of data and addition is done in place and is faster in time.
    // Cons: Extra space due to recursive stack space.
