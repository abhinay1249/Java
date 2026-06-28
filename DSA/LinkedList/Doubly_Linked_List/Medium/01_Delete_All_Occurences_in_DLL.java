// Problem Statement: Given the head of a doubly linked list and an integer key,
//  delete all the occurrences of key from the linked list and return the head of the modified linked list.

// Example 1:

// Input: head = [10,4,10,10,6,10], key = 10
// Output: [4,6]  
// Explanation: All the occurrences of 10 are deleted from the linked list. 
// Hence the modified linked list is 4 <-> 6. 

// Example 2:

// Input: head = [1,2,3,4,5], key = 6      
// Output: [1,2,3,4,5]
// Explanation: 6 is not present in the linked list.
// Hence the modified linked list is 1 <-> 2 <-> 3 <->


class Node{

    int data;
    Node next;
    Node prev;
    
    Node(int data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    // =========================== Convert Array into Linked List ==========================

        public  static Node convert(int[] nums){
            
            int length = nums.length;

            Node head = new Node(nums[0]);

            Node prev = head;

            for(int index = 1; index < length ; index++){
                Node temp = new Node(nums[index],null,prev);
                prev.next = temp;
                prev = temp;
            }
            return head;
        }

    // ============================== Print the Linked List ================================

        public static void print(Node head){
            
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

    // ============================== Only Approach =======================================

        public static Node deleteAllOccurences(Node head, int key){
            
            Node temp = head;
            Node prevNode = null;
            Node nextNode = null;

            while(temp != null){
                if(temp.data == key){
                    if(temp == head){
                        head = head.next;                                   // T.C = O(N), S.C = O(1)
                    }
                    prevNode = temp.prev;
                    nextNode = temp.next;

                    if(prevNode != null) prevNode.next = nextNode;
                    if(nextNode != null) nextNode.prev = prevNode;

                    temp = nextNode;
                }else{
                    temp = temp.next;
                }
            }
            return head;
        }
        
    public static void main(String[] args) {
        
        int[] nums = {10,4,10,10,6,10};
        int key = 10;
        Node head = convert(nums);

        Node result = deleteAllOccurences(head, key);
        print(result);
    }
}

class A{
    public static Node deleteALLOccureneces(Node head, int target){
        if(head == null){
            return head;
        }

        Node temp = head;

        while(temp.next != null){
            if(temp.data == target){
                if(temp == head){
                    head = head.next;
                }

                if(temp.data == target){
                    Node prev = temp.prev;
                    Node front = temp.next;
                    prev.next = front;
                    front.prev = prev;
                }
            }
            temp = temp.next;
        }

        if(temp.data == target){
            Node prev = temp.prev;
            prev.next = temp.next;
            temp.prev = null;
        }

        return head;
    }
}
