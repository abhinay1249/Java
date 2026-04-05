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
    
    private static void print(Node head){
        
        Node dll = head;
        
        while(dll != null){
            System.out.print(dll.data + " ");
            dll = dll.nextptr;
        }
    }
    
    private static Node deletionAtHead(Node head){
        
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
    
    
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        
        Node head = convert(nums);
        Node head_1 = convert(nums);
        Node head_2 = convert(nums);
        
        Node dll = head;
        
        System.out.print("Doubly Linked List --> ");
        
        print(dll);
        
        System.out.println();
        
        System.out.print("Deletion Of Head Node --> ");
        
        Node deletionAtHead = deletionAtHead(head_1);
        
        print(deletionAtHead);

    }
}