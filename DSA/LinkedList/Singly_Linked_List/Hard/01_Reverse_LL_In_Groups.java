// Problem Statement: Given the head of a singly linked list containing integers, reverse the nodes of the list in groups of k and return the head of the modified list. 
// If the number of nodes is not a multiple of k, then the remaining nodes at the end should be kept as is and not reversed.
// Do not change the values of the nodes, only change the links between nodes.

// Example 1:

// Input : 1 -> 2 -> 3 -> 4 -> 5, k = 2
// Output :2 -> 1 -> 4 -> 3 -> 5
// Explanation :The groups 1 -> 2 and 3 -> 4 were reversed as 2 -> 1 and 4 -> 3.

// Example 2:

// Input : 1 -> 2 -> 3 -> 4 -> 5, k = 3
// Output : 3 -> 2 -> 1 -> 4 -> 5
// Explanation :The groups 1 -> 2 -> 3 were reversed as 3 -> 2 -> 1.
// Note that 4 -> 5 was not reversed.

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

    // ============================ Convert Array into Linked List ===========================
    
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

    // =============================== Print Linked List ========================================

        private static void print(Node head){

            Node temp = head;

            while(temp != null){
                System.out.print(temp.data +" ");
                temp = temp.next;
            }
        }

    // =============================== Only Approach ========================================

        private static Node findKthNode(Node head, int k){

            Node temp = head;
            int count = 1;

            while(temp!= null && count < k){
                temp = temp.next;
                count++;
            }
            return temp;
        }

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

        public static Node reverseKthGroup(Node head, int k){

            if(head == null || head.next == null){
                return head;
            }

            Node temp = head;
            Node prevNode = null;

            while(temp != null){

                Node kthNode = findKthNode(temp,k);

                if(kthNode == null){
                    if(prevNode != null){
                       prevNode.next = temp;                         // T.C = O(2N), S.C = O(1) 
                    }                                               // O(2n) = findKthNode + reverseLL = 2k 
                    break;                                          // Number of groups = N/k, Total = O(2k) * N/k = O(2N)
                }

                Node nextNode = kthNode.next;
                kthNode.next = null;
                reverseLL(temp);

                if(temp == head){
                    head = kthNode;
                }else{
                    prevNode.next = kthNode;
                }

                prevNode = temp;
                temp = nextNode;
            }
            return head;
        }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;
        
        Node head = convert(nums);
        Node result = reverseKthGroup(head,k);
        print(result);
    }
}