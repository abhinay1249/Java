// Problem Statement: Insertion Of Node In Doubly Linked List

// Example:-

// Input: [1,2,3,4,5,6,7,8]     
// Output:
// Insertion Of Node Before Head --> 10 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8
// Insertion Of Node Before Tail --> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 100 <-> 8
// Insertion At Kth Node --> 1 <-> 2 <-> 49 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8
// Insertion Of Value Node --> 99 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8

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

        public  static Node convert(int[] nums){

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

    // ================================ Insertion Of Node Before Head ==============================================

        public static Node insertionAtBeforeHead(Node head, int val){
            
            Node newHead = new Node(val,head,null);
            
            head.prevptr = newHead;
            
            return newHead;
        }

    // ================================ Insertion Of Node Before Tail ==============================================
        
        public static Node insertionAtBeforeTail(Node head, int val){

            Node temp = head;
            Node newNode = new Node(val,null,null);
            
            while(temp != null){
                if(temp.nextptr == null){
                    Node prev = temp.prevptr;
                    prev.nextptr = newNode;
                    newNode.prevptr = prev;
                    newNode.nextptr = temp;
                    temp.prevptr = newNode;
                }
                temp = temp.nextptr;
            }
            return head;
        }

    // ================================ Insertion Of Node At Kth Position ==========================================
        
        public static Node insertionAtKthPos(Node head, int val, int pos){

            if(pos == 1){
                return insertionAtBeforeHead(head,val);
            }

            Node temp = head;
            int count = 0;

            while(temp != null){
                count++;
                if(count == pos){
                    Node prev = temp.prevptr;
                    Node newNode = new Node(val,temp,prev);
                    prev.nextptr = newNode;
                    temp.prevptr = newNode;
                    break;
                }
                temp = temp.nextptr;
            }

            return head;
        }

    // ================================ Insertion Of Node At Value ========================================== 

        public static Node insertionAtValue(Node head, int val,int element){
        
            if(val == head.data){
                return insertionAtBeforeHead(head,element);
            }
            Node temp = head;

            while(temp != null){
                if(temp.data == val){
                    Node prev = temp.prevptr;
                    Node newNode = new Node(element,temp,prev);
                    prev.nextptr = newNode;
                    temp.prevptr = newNode;
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
        
        System.out.print("Insertion Of Node Before Head --> ");
        
        Node insertionAtBeforeHead = insertionAtBeforeHead(head_1,10);
        
        print(insertionAtBeforeHead);
        
        System.out.println();
        
        System.out.print("Insertion Of Node Before Tail --> ");
        
        Node insertionAtBeforeTail = insertionAtBeforeTail(head_2,100);
        
        print(insertionAtBeforeTail);

        System.out.println();
        
        System.out.print("Deletion At Kth Node --> ");
        
        Node insertionAtKthPos = insertionAtKthPos(head_3,49,3);
        
        print(insertionAtKthPos);
        
        System.out.println();
        
        System.out.print("Insertion Of Value Node --> ");
        
        Node insertionAtValue = insertionAtValue(head_4,1,99);
        
        print(insertionAtValue);
    }
}