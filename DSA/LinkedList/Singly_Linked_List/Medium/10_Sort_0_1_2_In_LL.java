// Problem Statement: Given a linked list containing only 0's, 1's, and 2's, sort the linked list by 
// rearranging the links (not by changing the data values).

// Example 1:

// Input: 1 -> 2 -> 0 -> 1 -> 0 -> 2 -> NULL
// Output: 0 -> 0 -> 1 -> 1 -> 2 -> 2 -> NULL
// Explanation: The linked list is sorted in ascending order by rearranging the links.

// Example 2:

// Input: 2 -> 1 -> 2 -> 0 -> 0 -> 1 -> NULL
// Output: 0 -> 0 -> 1 -> 1 -> 2 -> 2 -> NULL

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    
    // ============================== Convert Array into Linked List =======================

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

    // ============================== Print the Linked List ================================

        public static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
    
    // ============================== Brute Force Approach ==================================

        public static Node sort012(Node head){

            if(head == null || head.next == null){
                return head;
            }

            Node temp = head;
            List<Integer> al = new ArrayList<>();

            while(temp != null){
                al.add(temp.data);
                temp=temp.next;
            }

            Collections.sort(al);                           // T.C = O(N) + O(N LOG N) + O(N), S.C = O(N)
            temp = head;
            int index = 0;

            while(temp != null){
                temp.data = al.get(index);
                index++;
                temp = temp.next;
            }
            return head;
        }

    // ============================== Better Approach ================================== 

        public static Node sort012_1(Node head){
            
            if(head == null || head.next == null){
                return head;
            }
            Node temp = head;
            int count0 = 0, count1 = 0, count2 = 0;

            while(temp != null){
                if(temp.data == 0){
                    count0++;
                }else if(temp.data == 1){
                    count1++;
                }else{
                    count2++;
                }
                temp = temp.next;                           // T.C = O(N) + O(N) = O(2N), S.C = O(1)
            }

            temp = head;

            while(temp != null){
                if(count0 != 0){
                    temp.data = 0;
                    count0--;
                }else if(count1 != 1){
                    temp.data = 1;
                    count1--;
                }else{
                    temp.data = 2;
                    count2--;
                }
                temp = temp.next;
            }
            return head;
        }

    // ============================== Optimal Approach ================================== 

        public static Node sort012_2(Node head){
                
            if(head == null || head.next == null){
                return head;
            }

            Node temp = head;

            Node zeroHead = new Node(-1);
            Node oneHead = new Node(-1);
            Node twoHead = new Node(-1);

            Node temp0 = zeroHead;
            Node temp1 = oneHead;
            Node temp2 = twoHead;

            while(temp != null){
                
                if(temp.data == 0){
                    temp0.next = temp;
                    temp0 = temp0.next;                                 // T.C = O(N), S.C = O(1)
                }else if(temp.data == 1){
                    temp1.next = temp;
                    temp1 = temp1.next;
                }else if(temp.data == 2){
                    temp2.next = temp;
                    temp2 = temp2.next;
                }
                temp = temp.next;
                
            }
            if(oneHead.next != null){
                temp0.next = oneHead.next;   
            }else{
                temp0.next = twoHead.next;
            }
            if(twoHead.next != null){
                temp1.next = twoHead.next;   
            }

            temp2.next = null;

            return zeroHead.next;
        }
    

    public static void main(String[] args) {
        int[] nums = {0,2,1,2,1,2,0,0,1,1,1,0,0,0,2,2,0};
        
        Node head = convert(nums);
        Node result = sort012(head);
        print(result);

        System.out.println();
                
        Node head_1 = convert(nums);
        Node result_1 = sort012_1(head_1);
        print(result_1);

        System.out.println();
        
        Node head_2 = convert(nums);
        Node result_2 = sort012_2(head_2);
        print(result_2);
    }
}