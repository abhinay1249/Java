// Problem Statement: Given the head of a linked list of integers, delete the middle node of the linked list and return the modified head. 
// However, if the linked list has an even number of nodes, delete the second middle node.



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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    public static Node removeMiddleNode(Node head){
        
        if(head.next == null){
            return head.next;
        }
        
        Node temp = head;
        int count = 0;
        
        while(temp != null){
            count++;
            temp = temp.next;
        }
        
        int middleNode = (count/2) + 1;
        int counter = 0;
        temp = head;
        Node prev = null;
        
        while(temp != null){
            counter++;
            if(counter == middleNode){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        
        Node head = convert(nums);
        
        Node result = removeMiddleNode(head);
        
        print(result);
    }
}