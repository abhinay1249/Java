// Problem Statement: Given the head of a linked list of integers, delete the middle node of the linked list and return the modified head. 
// However, if the linked list has an even number of nodes, delete the second middle node.

// Examples:-

// Input: 1->2->3->4->5 
// Output: 1->2->4->5
// Explanation: Node with value 3 is at the middle node and deleted.

// Input: 1->2->3->4
// Output: 1->2->4
// Explanation: The linked list has an even number of nodes hence we delete the second middle node which is 3.

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

    // ============================== Print the Linked List ===============================

        public static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

    // ========================== Brute Force Approach =====================================

        public static Node removeMiddleNode(Node head){

            if(head == null || head.next == null){
                return null;
            }

            Node temp = head;
            int count = 0;

            while(temp != null){
                count++;
                temp = temp.next;
            }

            int middleNode = (count/2) + 1;                         // T.C = O(N) + O(N/2), S.C = O(1)
            int counter = 0;
            temp = head;
            Node prev = null;

            while(temp != null){
                counter++;
                if(counter == middleNode){
                    prev.next = temp.next;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            return head;
        }

    // ================================ Optimal Approach =====================================

        public static Node removeMiddleNode_1(Node head){

            if(head == null || head.next == null){
                return null;
            }

            Node slow = head;
            Node fast = head;
            Node prev = null;

            while(fast != null && fast.next != null){               // T.C = O(N), S.C = O(1)
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = slow.next;

            return head;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        
        Node head = convert(nums);
        
        Node result = removeMiddleNode(head);
        
        print(result);

        System.out.println();
        
        Node head_1 = convert(nums);
        
        Node result_1 = removeMiddleNode_1(head_1);
        
        print(result_1);
    }
}