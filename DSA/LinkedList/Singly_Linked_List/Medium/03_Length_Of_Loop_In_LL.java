// Problem Statement: Given the head of a linked list, determine the length of a loop present in the linked list. 
// If there's no loop present, return 0.

// Example 1:

// Input:  1 → 2 → 3 → 4 → 5 → 6
    //               ↑         ↓
    //               ← ← ← ← ← ←

// Output: 3
// Explanation: A cycle exists in the linked list starting at node 3 -> 4 -> 5 and then back to 3. 
// There are 3 nodes present in this cycle.

// Example 2:

// Input:  1 → 2 → 3 → 4 → 5 → 6
// Output: 0
// Explanation: In this example, the linked list does not contain a loop hence returns 0.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        
    // ====================== Brute Force Approach ====================================

        public static int lengthOfCycle(Node head){

            Node temp = head;

            Map<Node,Integer> hm = new HashMap<>();
            List<Node> al = new ArrayList<>();

            while(temp != null){
                if(hm.containsKey(temp)){                       // T.C = O(N) + O(N * K) = O(N^2), S.C = O(2N)
                    if(!(al.contains(temp))){
                        al.add(temp);
                    }else{
                        break;   
                    }
                }else{
                    hm.put(temp,1);
                }
                temp = temp.next;
            }
            
            return al.size();

        }

    // =================== Better Approach =========================================

        public static int length_1(Node head){
            Node temp = head;
            int timer = 1, length = 0;
            Map<Node,Integer> hm = new HashMap<>();

            while(temp != null){
                if(hm.containsKey(temp)){                        // T.C = O(N), S.C = O(N)
                    length = timer - hm.get(temp);
                    break;
                }else{
                    hm.put(temp,timer);
                }
                temp = temp.next;
                timer++;
            }
            return length;
        }

    // ========================= Optimal Approach ==================================

        public static int length_2(Node head){
            Node slow = head;
            Node fast = head;

            int length = 1;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){                                   // T.C = O(N), S.C = O(1)
                    while(fast.next != slow){
                        length++;
                        fast = fast.next;
                    }
                    return length;
                }
            }
            return 0;
        }


    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        
        Node head = convert(nums);
        

        // ==== Brute Force Approach ====

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

            int res = lengthOfCycle(head);

            System.out.print(res);
        
            System.out.println();

        // ==== Better Approach ====

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

            int res_1 = length_1(head_1);
            System.out.print(res_1);

            System.out.println();

        // ==== Optimal Approach ====

            Node head_2 = convert(nums);
            
            Node temp_2 = head_2;
            Node thirdNode_2 = null;
            int count_2 = 1;
            
            while(temp_2.next != null){
                if(count_2==3){
                    thirdNode_2 = temp_2;
                }
                temp_2 = temp_2.next;
                count_2++;
            }

            temp_2.next = thirdNode_2;

            int res_2 = length_2(head_2);
            System.out.print(res_2);
    }
}