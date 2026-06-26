// Problem Statement: You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6

// Example 2:

// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []


 import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    // ============================ Print Linked List ===========================

        private static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data +" ");
                temp = temp.next;
            }
        }

    // ==================== Brute Force Approach ================================
    
        private static Node convertLL(List<Integer> al){
            
            int length = al.size();

            Node head = new Node(al.get(0));

            if(length == 1){
                return head;
            }

            Node mover = head;

            for(int index = 1 ; index < length ; index++){
                Node temp = new Node(al.get(index));
                mover.next = temp;
                mover = temp;
            }
            return head;
        }

        public static Node mergeKLists_1(Node[] lists) {

            int length = lists.length;

            Node head = null;

            if(length == 0){
                return head;
            }

            List<Integer> al = new ArrayList<>();

            for(int index = 0 ; index < length ; index++){

                Node temp = lists[index];                      // T.C = O(M * N) + O(X LOG X) + X, S.C = O(2X) 
                                                        
                while(temp != null){                // M is the number of linked lists and N is the maximum number of nodes in any linked list, X = M * N
                    al.add(temp.data);
                    temp = temp.next;
                }
            }

            if(al.isEmpty()) return head;

            Collections.sort(al);

            head = convertLL(al);

            return head;
        }

    // ==================== Better Approach ================================

        private static Node mergeTwoLists(Node list1, Node list2){
            Node temp1 = list1;
            Node temp2 = list2;

            Node dummyNode = new Node(-1);
            Node temp = dummyNode;

            while(temp1 != null && temp2 != null){
                if(temp1.data < temp2.data){
                    temp.next = temp1;
                    temp = temp.next;
                    temp1 = temp1.next;
                }else{
                    temp.next = temp2;
                    temp = temp.next;                   // T.C = O(N * ((K * K+1)/2)) near to O(N^3), S.C = O(1)
                    temp2 = temp2.next;
                }
            }

            if(temp1 != null){
                temp.next = temp1;
            }

            if(temp2 != null){
                temp.next = temp2;
            }

            return dummyNode.next;
        }


        public static Node mergeKLists(Node[] lists) {

            if(lists.length == 0){
                return null;
            }

            Node head = lists[0];

            for(int index = 1 ; index < lists.length ; index++){
                head = mergeTwoLists(head,lists[index]);
            }

            return head;
        }


    // ==================== Optimal Approach ================================

        public static Node mergeKLists_2(Node[] lists) {

            Queue<Node> pq = new PriorityQueue<>((a,b)-> a.data - b.data);

            for(Node node : lists){
                if(node != null){
                    pq.offer(node);
                }
            }

            Node dummyNode = new Node(-1);
            Node temp = dummyNode;

            while(!pq.isEmpty()){                           // T.C = O(K LOG K) + O(K * N * 2 LOG K), S.C = O(K)
                Node curr = pq.poll();          // where K is the number of linked lists and N is the maximum number of nodes in any linked list.

                temp.next = curr;
                temp = temp.next;

                if(curr.next != null){
                    pq.offer(curr.next);
                }
            }

            return dummyNode.next;
        }

    public static void main(String[] args) {
        Node[] lists = new Node[3]; 
        lists[0] = convertLL(Arrays.asList(1,4,5));
        lists[1] = convertLL(Arrays.asList(1,3,4)); 
        lists[2] = convertLL(Arrays.asList(2,6));

        Node head = mergeKLists(lists);
        print(head);

        System.out.println();

        Node[] lists_1 = new Node[3];
        lists_1[0] = convertLL(Arrays.asList(1,4,5));
        lists_1[1] = convertLL(Arrays.asList(1,3,4));
        lists_1[2] = convertLL(Arrays.asList(2,6)); 

        Node head_1 = mergeKLists_1(lists_1);
        print(head_1);

        System.out.println();

        Node[] lists_2 = new Node[3];
        lists_2[0] = convertLL(Arrays.asList(1,4,5));
        lists_2[1] = convertLL(Arrays.asList(1,3,4));
        lists_2[2] = convertLL(Arrays.asList(2,6)); 

        Node head_2 = mergeKLists_2(lists_2);
        print(head_2);
    }
}