// Problem Statement: Given the head of a linked list that may contain a cycle, return the starting point of that cycle. 
// If there is no cycle in the linked list return null.

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
    
    static Node detectCycleStart(Node head){
        Node temp = head;
        Node startPoint = null;
        
        Set<Node> hs = new HashSet<>();
        
        while(temp != null){
            if(hs.contains(temp)){
                startPoint = temp;
                break;
            }else{
                hs.add(temp);
            }
            temp = temp.next;
        }
        return startPoint;
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
        
        Node res = detectCycleStart(head);
        System.out.print(res.data);
        
        System.out.println();
    }
}