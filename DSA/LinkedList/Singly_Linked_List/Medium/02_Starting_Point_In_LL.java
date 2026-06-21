// Problem Statement: Given the head of a linked list that may contain a cycle, return the starting point of that cycle. 
// If there is no cycle in the linked list return null.

// Example 1:

// Input: LL: 1  2  3  4  5
// Output: 3
// Explanation: This linked list contains a loop of size 3 starting at node with value 3.

// Example 2:

// Input: LL: 1 -> 2 -> 3 -> 4 -> 9 -> 9
// Output:NULL
// Explanation: This linked list does not contain a loop hence has no starting point

import java.util.HashSet;
import java.util.Set;

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
    
    // ============================== Convert Array into Linked List ==========================

        private static Node convert(int[] nums){
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

        
    
    // ================================ Brute Force Approach ===================================

        public static Node detectCycleStart(Node head){
            Node temp = head;
            Node startPoint = null;

            Set<Node> hs = new HashSet<>();

            while(temp != null){
                if(hs.contains(temp)){
                    startPoint = temp;                              // T.C= O(N), S.C = O(N)
                    break;
                }else{
                    hs.add(temp);
                }
                temp = temp.next;
            }
            return startPoint;
        }

    // ================================ Optimal Approach ===================================

        public static Node detectCycleStart_1(Node head){

            if(head == null){
                return head;
            }

            Node slow = head;
            Node fast = head;

             Node startPoint = null;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;                              // T.C = O(N), S.C = O(1)

                if(slow == fast){
                    slow = head;
                    while(slow != fast){
                        slow = slow.next;
                        fast = fast.next;
                    }
                    startPoint = slow;
                    break;
                }
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
        
        Node head_1 = convert(nums);
        
        Node temp_1 = head_1;
        Node thirdNode_1 = null;
        int count_1 = 1;
        
        while(temp_1.next != null){
            if(count_1==3){
                thirdNode_1 = temp_1;
            }
            temp_1 = temp_1.next;
            count_1++;
        }
        
        temp_1.next = thirdNode_1;
        
        Node res_1 = detectCycleStart_1(head_1);
        System.out.print(res_1.data);
    }
}