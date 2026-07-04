// Problem Statement: Given a Linked List, determine whether the linked list contains a cycle or not.

// Example 1:

// Input: LL: 1 2 3 4 5
// Output: True
// Explanation: The last node with the value of 5 has its 'next' pointer pointing back to a previous node with the value of 3. 
// This has resulted in a loop, hence we return true.

// Example 2:

// Input: LL: 1 2 3 4 9 9
// Output: False
// Explanation:  In this example, the linked list does not have a loop hence returns false.


import java.util.HashMap;
import java.util.Map;

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

    // ===================== Convert Array into Linked List ===================================

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

    // ================================ Brute Force Approach ===================================

        public static boolean detectLoop(Node head){
            Node temp = head;
            boolean flag = false;

            Map<Node,Integer> hm = new HashMap<>();

            while(temp != null){
                if(hm.containsKey(temp)){                               // T.C= O(N), S.C = O(N)
                    flag = true;
                    break;
                }else{
                    hm.put(temp,hm.getOrDefault(temp,0)+1);
                }
                temp = temp.next;
            }
            return flag;
        }

    // ================================ Optimal Approach =====================================

        public static boolean detectLoop_1(Node head){

            boolean flag = false;
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){                                      // T.C= O(N), S.C = O(1)
                    flag = true;
                    break;
                }
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
        System.out.print(res);
        
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
        
        boolean res_1 = detectLoop_1(head_1);
        System.out.println(res_1);
    }
}