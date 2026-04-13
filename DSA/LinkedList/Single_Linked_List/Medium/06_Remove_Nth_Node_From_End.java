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
    
    public static Node convert(int[] nums){
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
    
    public static void print(Node head){
        Node temp = head;
        
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
    }
    
    public static Node removeNthNodeFromEnd(Node head, int n){
        Node temp = head;
        int count = 0;
        
        while(temp != null){
            count++;
            temp = temp.next;
        }
        
        int result = count - n;
        
        if(result == 0){
            return head.next;
        }
        
        temp = head;
        
        while(temp != null){
            result--;
            if(result == 0){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int n = 6;
        
        Node head = convert(nums);
        
        Node result = removeNthNodeFromEnd(head,n);
        print(result);
    }
}