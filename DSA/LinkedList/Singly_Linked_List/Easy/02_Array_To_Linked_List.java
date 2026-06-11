// Problem Statement: Given an array, convert it into a singly linked list.

// Example:-
// Input: [1,2,3,4,5,6,7,8]
// Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
// Explanation: The first element of the array becomes the head of the linked list
// and each subsequent element is added as a new node to the end of the list.

class Node{

    int data;
    Node pointer;

    Node(int data, Node pointer){
        this.data = data;
        this.pointer = pointer;
    }

    Node(int data){
        this.data = data;
        this.pointer = null;
    }
    
    // ============================ Convert Array into Linked List =========================
    
        public static Node convertArrayToLL(int[] nums){
        
            int length = nums.length;
        
            Node head = new Node(nums[0]);
        
            Node mover = head;
        
            for(int index = 1 ; index < length ; index++){
                Node temp = new Node(nums[index]);
                mover.pointer = temp;
                mover = temp;
            }
        
            return head;
        }

}

class Main{
    public static void main(String[] args) {
        int[] nums = {12,43,134,141,431,0};

        Node head = Node.convertArrayToLL(nums); 

        System.out.println(head.data);

    }
}