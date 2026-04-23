// Problem Statement: Given a doubly linked list that is sorted and a sum, find all pair of nodes whose sum is equal to the given sum.

// Example 1:
// Input: head = [1,2,3,4,9], sum = 5
// Output: [[1,4],[2,3]]
    
// Example 2:
// Input: head = [1,2,3,4,5], sum = 10
// Output: []

import java.util.*;

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
    
    private static Node convert(int[] nums){
        int length = nums.length;
        
        Node head = new Node(nums[0]);
        Node prevNode = head;
        
        for(int index = 1 ; index < length ; index++){
            Node temp = new Node(nums[index],null,prevNode);
            prevNode.next = temp;
            prevNode = temp;
        }
        return head;
    }

    public static List<List<Integer>> pairs(Node head, int sum){
        Node temp1 = head;
        Node temp2 = head.next;
        
        List<List<Integer>> pairs = new ArrayList<>();
        
        while(temp1 != null){
            temp2 = temp1.next;
            while(temp2 != null && temp1.data+temp2.data <= sum){
                int sumOfNodes = temp1.data + temp2.data;
                
                if(sumOfNodes == sum){
                    List<Integer> elements = new ArrayList<>();
                    elements.add(temp1.data);
                    elements.add(temp2.data);
                    
                    pairs.add(elements);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return pairs;
    }
    
    
    public static void main(String[] args) {
        
        int[] nums = {1,2,3,4,9};
        
        int sum = 5;
        
        Node head = convert(nums);
        
        List<List<Integer>> result = pairs(head,sum);
        
        result.forEach(inner -> {
           inner.forEach(num -> System.out.print(num + " "));
           System.out.println();
        });
        
    }
}