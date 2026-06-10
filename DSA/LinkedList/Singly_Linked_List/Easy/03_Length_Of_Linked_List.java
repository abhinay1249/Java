// Problem Statement: Given the head of a linked list, print the length of the linked list.

// Example:-
// Input: 12 -> 43 -> 134 -> 141 -> 431 -> 0
// Output: 6

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

    // ============================ Length Of Linked List =========================

        public static int lengthOfLL(int[] nums){

            Node head = Node.convertArrayToLL(nums);

            Node temp = head;

            int count = 0;

            while(temp != null){
                temp=temp.pointer;
                count++;
            }

            return count;

        }
}

class Main{
    public static void main(String[] args) {
        int[] nums = {12,43,134,141,431,0};

        Node head = Node.convertArrayToLL(nums);
        
        Node temp = head;

        while(temp != null){
            // System.out.print(temp.data+" ");
            temp=temp.pointer;
        }

        int length = Node.lengthOfLL(nums);

        System.out.println(length);
    }
}