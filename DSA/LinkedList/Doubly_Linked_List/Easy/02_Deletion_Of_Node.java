// Problem Statement: Deletion Of Node In Doubly Linked List

// Example 1:-

// Input: [1,2,3,4,5,6,7,8]
// Output: 
// Deletion Of Head Node --> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8
// Deletion Of Tail Node --> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7
// Deletion At Kth Node --> 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8
// Deletion Of Value Node --> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 7 <-> 8

// Deletion Of Nodes 
// --> Head, Tail, KthPos, Value 

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
    
    // ================================ Convert Array into Doubly Linked List =====================================

        public static Node convert(int[] nums){

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

    // ================================ Print Doubly Linked List ==============================================
    
        public static void print(Node head){

            Node dll = head;

            while(dll != null){
                System.out.print(dll.data + " ");
                dll = dll.nextptr;
            }
        }

    // ================================ Removal Of Head Node ==============================================

        public static Node deletionAtHead(Node head){

            if(head == null) return head;

            if(head.prevptr == null && head.nextptr == null){
                return null;   
            }

            Node prev = head;

            head = head.nextptr;
            head.prevptr = null;
            prev.nextptr = null;

            return head;
        }
    
    // ================================ Removal Of Tail Node ==============================================
    
        public static Node deletionAtTail(Node head){

            if(head == null) return head;

            if(head.prevptr == null && head.nextptr == null){
                return null;   
            }

            Node tail = head;

            while(tail.nextptr != null){
                tail = tail.nextptr;
            }

            Node prev = tail.prevptr;
            prev.nextptr = null;
            tail.prevptr = null;

            return head;
        }
    
    // ================================ Removal Of Kth Position Node ==============================================

        public static Node deletionAtKthPos(Node head, int k){

            Node temp = head;

            int count = 0;

            while(temp != null){
                count++;
                if(count == k){
                    break;   
                }
                temp = temp.nextptr;
            }

            if(temp == null) return head;

            Node prev = temp.prevptr;
            Node front = temp.nextptr;

            if(prev == null && front == null){
                return null;
            }else if(prev == null){
                return deletionAtHead(head);
            }else if(front == null){
                return deletionAtTail(head); 
            }else{
                prev.nextptr = temp.nextptr;
                front.prevptr = temp.prevptr;
                temp.nextptr = null;
                temp.prevptr = null;
            }
            
            return head;
        }
    
    // ================================ Removal Of Value Node ==============================================

        public static Node deletionOfValue(Node head, int elementNode){
            
            if(head == null) return null;
            
            Node temp = head;
            
            while(temp != null){
                if(temp.data == elementNode){
                    
                    if(temp.prevptr == null){
                        return deletionAtHead(head);
                    }
                    if(temp.nextptr == null){
                        return deletionAtTail(head);
                    }

                    Node prev = temp.prevptr;
                    Node front = temp.nextptr;
            
                    front.prevptr = prev;
                    prev.nextptr = front;
                    
                    temp.nextptr = null;
                    temp.prevptr=null;
                    
                    break;   
                }
                temp = temp.nextptr;
            }
            return head;
        }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        // int[] nums = {1};
        
        Node head = convert(nums);
        Node head_1 = convert(nums);
        Node head_2 = convert(nums);
        Node head_3 = convert(nums);
        Node head_4 = convert(nums);
        
        System.out.print("Doubly Linked List --> ");
        
        Node dll = head;
        
        print(dll);
        
        System.out.println();
        
        System.out.print("Deletion Of Head Node --> ");
        
        Node deletionAtHead = deletionAtHead(head_1);
        
        print(deletionAtHead);
        
        System.out.println();
        
        System.out.print("Deletion Of Tail Node --> ");
        
        Node deletionAtTail = deletionAtTail(head_2);
        
        print(deletionAtTail);

        System.out.println();
        
        System.out.print("Deletion At Kth Node --> ");
        
        Node deletionAtKthPos = deletionAtKthPos(head_3,1);
        
        print(deletionAtKthPos);

        System.out.println();
        
        System.out.print("Deletion Of Value Node --> ");
        
        Node deletionOfValue = deletionOfValue(head_4,1);
        
        print(deletionOfValue);
    }
}