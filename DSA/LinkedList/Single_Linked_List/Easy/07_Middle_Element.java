// Problem Statement: Given the head of a linked list of integers, determine the middle node of the linked list. However, if the linked list has an even number of nodes, return the second middle node.

// Example 1:

// Input : LL: 1  2  3  4  5 
// Output : 3    
// Explanation : Node with value 3 is the middle node of this linked list.
                                         
// Example 2:

// Input: LL: 1  2  3  4  5  6
// Output: 4
// Explanation : In this example, the linked list has an even number of nodes hence we return the second middle node which is 4.


class Node{
    int data;
    Node nextptr;
    
    Node(int data, Node nextptr){
        this.data = data;
        this.nextptr = nextptr;
    }
    
    Node(int data){
        this.data = data;
        this.nextptr = null;
    }

    private static Node convert(int[] nums){
        int length = nums.length;
        Node head = new Node(nums[0]);
        Node mover = head;
        for(int i = 1 ; i < length ; i++){
            Node temp = new Node(nums[i]);
            mover.nextptr = temp;
            mover= temp;
        }
        return head;
    }
    
    
    private static Node middleElement(Node head){
        Node current = head;
        
        int counter = 0;
        
        while(current != null){
            counter++;
             current = current.nextptr;
        }
        
        current = head;
        Node prev = null;
        Node result = null;
        
        if(counter%2 == 1){
            int target =(int) Math.ceil(counter/2.0);
            int pointer = 0;
            
            while(current != null){
                pointer++;
                if(pointer == target){
                    result = prev.nextptr;
                    break;
                }
                prev = current;
                current = current.nextptr;
            }
        }else{
            int target = counter/2;
            int pointer = 0;
            
            while(current.nextptr != null){
                pointer++;
                if(pointer == target){
                    result = current.nextptr;
                    break;
                }
                current = current.nextptr;
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] nums_1 = {1,2,3,4,5,6};
        
        Node head_1 = convert(nums);
        Node head_2 = convert(nums_1);
    
        
        System.out.print("Result --> ");
        Node result = middleElement(head_1);
        System.out.print(result.data);
        
        System.out.println();
        
        System.out.print("Result --> ");
        Node result_1 = middleElement(head_2);
        System.out.print(result_1.data);
    }
}