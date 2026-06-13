// Problem Statement: Given a doubly linked list that is sorted and a sum, find all pair of nodes whose sum is equal to the given sum.

// Example 1:

// Input: head = [1,2,3,4,9], sum = 5
// Output: [[1,4],[2,3]]
// Explanation: There are two pairs of nodes whose sum is 5, (1,4) and (2,3).
    
// Example 2:

// Input: head = [1,2,3,4,5], sum = 10
// Output: []
// Explanation: There are no pairs of nodes whose sum is 10.


import java.util.ArrayList;
import java.util.List;

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
    
    // =========================== Convert Array into Linked List =========================

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

    // ============================== Brute Force Approach ================================

        public static List<List<Integer>> pairs(Node head, int sum){
            
            Node temp1 = head;
            Node temp2 = head.next;

            List<List<Integer>> pairs = new ArrayList<>();

            while(temp1 != null){
                temp2 = temp1.next;
                while(temp2 != null && temp1.data+temp2.data <= sum){
                    int sumOfNodes = temp1.data + temp2.data;

                    if(sumOfNodes == sum){
                        List<Integer> elements = new ArrayList<>();         // T.C = O(N^2), S.C = O(1)
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

    // ============================== Optimal Approach =====================================

        public static List<List<Integer>> pairs_1(Node head, int sum){
            
            Node start = head;
            Node end = head;

            while(end.next != null){
                end = end.next;
            }

            List<List<Integer>> pairs = new ArrayList<>();

            while(start.data < end.data){
                int sumOfNodes = start.data + end.data;

                if(sumOfNodes == sum){
                    List<Integer> elements = new ArrayList<>();  
                    elements.add(start.data);                                       //T.C = O(2N), S.C = O(1)
                    elements.add(end.data);
                    pairs.add(elements);

                    start = start.next;
                    end = end.prev;
                }else if(sumOfNodes < sum){
                    start = start.next;
                }else{
                    end = end.prev;
                }
            }
            return pairs;
        }

    public static void main(String[] args) {
        
        int[] nums = {1,2,3,4,9};
        
        int sum = 5;
        
        System.out.println("Brute Force Approach");
        
        Node head = convert(nums);
        
        List<List<Integer>> result = pairs(head,sum);
        
        result.forEach(inner -> {
           inner.forEach(num -> System.out.print(num + " "));
           System.out.println();
        });
        
        System.out.println("Optimal Approach");
        
        Node head_1 = convert(nums);
        
        List<List<Integer>> result_1 = pairs(head_1,sum);
        
        result_1.forEach(inner -> {
           inner.forEach(num -> System.out.print(num + " "));
           System.out.println();
        });
        
    }
}