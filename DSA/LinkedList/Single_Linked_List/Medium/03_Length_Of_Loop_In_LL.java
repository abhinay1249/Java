// Problem Statement: Given the head of a linked list, determine the length of a loop present in the linked list. 
// If there's no loop present, return 0.

// Examples:

// Input:  1 → 2 → 3 → 4 → 5 → 6
    //               ↑         ↓
    //               ← ← ← ← ← ←

// Output: 3
// Explanation: A cycle exists in the linked list starting at node 3 -> 4 -> 5 and then back to 3. 
// There are 3 nodes present in this cycle.


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
    
    // ============================== Convert Array into Linked List ==========================

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
        
    // ================================ Brute Force Approach ===================================

        static int lengthOfCycle(Node head){
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

    // ================================ Better Approach ==========================================

        static int length_1(Node head){
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
        
        int res = lengthOfCycle(head);

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
        
        int res_1 = length_1(head_1);
        System.out.print(res_1);
    }
}