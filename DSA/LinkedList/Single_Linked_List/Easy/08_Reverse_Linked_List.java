// Problem Statement: Given the head of a singly linked list, write a program to reverse the linked list
// and return the head pointer to the reversed list.

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

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        
        Node head_1 = convert(nums);


    }
}
