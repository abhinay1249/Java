// Problem Statement: Given a Linked List, determine whether the linked list contains a cycle or not.

// Examples

// Input: LL: 1 2 3 4 5
// Output: True
// Explanation: The last node with the value of 5 has its 'next' pointer pointing back to a previous node with the value of 3. 
// This has resulted in a loop, hence we return true.

// Input: LL: 1 2 3 4 9 9
// Output: False
// Explanation:  In this example, the linked list does not have a loop hence returns false.


import java.util.*;

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
    
    static Node convert(int[] nums){
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
    
        static boolean detectLoop(Node head){
            Node temp = head;
            boolean flag = false;
            
            Map<Node,Integer> hm = new HashMap<>();
            
            while(temp != null){
                if(hm.containsKey(temp)){
                    flag = true;
                    break;
                }else{
                    hm.put(temp,hm.getOrDefault(temp,0)+1);
                }
                temp = temp.next;
            }
            return flag;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        
        Node head = convert(nums);
        
        Node temp = head;
        Node thirdNode = null;
        int count = 1;
        
        while(temp.next != null){
            if(count==3){
                thirdNode = temp;
            }
            temp = temp.next;
            count++;
        }
        
        temp.next = thirdNode;
        
        boolean res = detectLoop(head);
        System.out.println(res);
    }
}
