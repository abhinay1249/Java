// Problem Statement: Given a doubly linked list of size ‘N’ consisting of positive integers, 
// your task is to reverse it and return the head of the modified doubly linked list.

// Examples

// Input : DLL - 1 <-> 2 <-> 3 <-> 4
// Output : DLL - 4 <-> 3 <-> 2 <-> 1
// Explanation : The doubly linked list is reversed and its last node is returned at the new head pointer.


import java.util.Stack;

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
    
        private static Node convert(int[] nums){
            int length = nums.length;
            Node head = new Node(nums[0],null,null);
            Node prev = head;
            for(int i = 1 ; i < length ; i++){
                Node temp = new Node(nums[i],null,prev);
                prev.nextptr = temp;
                prev = temp;
            }
            return head;
        }

    // ============================== Print the Linked List ===============================
    
        private static void print(Node head){
            
            Node dll = head;
            while(dll != null){
                System.out.print(dll.data + " ");
                dll = dll.nextptr;
            }
        }

    // =========================== Brute Force Approach ==============================

        private static Node reverseADLL(Node head){

            Node temp = head;
            
            Stack<Integer> st = new Stack<>();
            
            while(temp != null){
                st.add(temp.data);                              
                temp = temp.nextptr;                            // T.C = O(2N), S.C = O(N)
            }
            
            temp = head;
            
            while(temp != null){
                temp.data = st.peek();
                st.pop();
                temp = temp.nextptr;
            }
            return head;
        }

    // =========================== Optimal Approach ==============================

        private static Node reverseADLL_1(Node head){

            Node current = head;

            Node last = null;

            while(current != null){
                last = current.prevptr;
                current.prevptr = current.nextptr;                      // T.C = O(N), S.C = O(1)
                current.nextptr = last;

                current = current.prevptr;
            }

            return last.prevptr;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        // int[] nums = {1};
        
        Node head = convert(nums);
        Node head_1 = convert(nums);
        Node head_2 = convert(nums);
        
        System.out.print("Doubly Linked List --> ");
        
        Node dll = head;
        
        print(dll);
        
        System.out.println();
        
        System.out.print("Reverse Of DLL --> ");
        
        Node reverseADLL = reverseADLL(head_1);
        
        print(reverseADLL);
        
        System.out.println();
        
        System.out.print("Reverse Of DLL --> ");
        
        Node reverseADLL_1 = reverseADLL_1(head_2);
        
        print(reverseADLL_1);
    }
}