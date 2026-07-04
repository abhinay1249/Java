// Problem Statement: Given an array, convert it into a doubly linked list.

// Example 1:-

// Input: [1,2,3,4,5,6,7,8]
// Output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8
// Explanation: The first element of the array becomes the head of the linked list.

// Example 2:-

// Input: [10,20,30,40,50]
// Output: 10 <-> 20 <-> 30 <-> 40 <-> 50
// Explanation: The elements of the array are converted into nodes of the doubly linked list.


class Node{
    int data;
    Node nextptr;
    Node prevptr;
    
    Node(int data, Node nextptr, Node prevptr){
        this.data = data;
        this.nextptr = nextptr;
        this.prevptr = prevptr;
    }
    
    Node(int data){
        this.data = data;
        this.nextptr = null;
        this.prevptr = null;
    }
    
    // ============================== Convert Array into Linked List ==========================

        public static Node convert(int[] nums){
            
            int length = nums.length;
            
            Node head = new Node(nums[0]);
            
            Node prev = head;
            
            for(int i = 1 ; i < length ; i++){
                Node temp = new Node(nums[i],null,prev);
                // Node temp = new Node(nums[i]);
                prev.nextptr = temp;
                // temp.prevptr = prev;
                prev = temp;
            }
            
            return head;
        }

    
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        
        Node head = convert(nums);
        Node head_1 = convert(nums);
        Node head_2 = convert(nums);
        
        Node dll = head;
        
        System.out.print("Doubly Linked List --> ");
        
        while(dll != null){
            System.out.print(dll.data + " ");
            dll = dll.nextptr;
        }
        
        System.out.println();
        
        Node dll_nextptr = head_1;
        
        System.out.print("Next Pointers --> ");
        
        while(dll_nextptr != null){
            try {
                System.out.print(dll_nextptr.nextptr.data + " ");
            } catch (NullPointerException e) {
                System.out.print("[Next pointer is null]");
            }
            dll_nextptr = dll_nextptr.nextptr;
        }
        
        System.out.println();
        
        Node dll_prevptr = head_2;
        
        System.out.print("Previous Pointers --> ");
        
        while(dll_prevptr != null){
            try {
                System.out.print(dll_prevptr.prevptr.data + " ");
            } catch (NullPointerException e) {
                System.out.print("[Previous pointer of Head is null] ");
            }
            dll_prevptr = dll_prevptr.nextptr;
        }
    }
}
