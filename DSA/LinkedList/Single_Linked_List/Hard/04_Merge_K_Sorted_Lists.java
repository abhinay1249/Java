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

        private static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data +" ");
                temp = temp.next;
            }
        }

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

        public static Node mergeKLists(Node[] lists) {
            int length = lists.length;

            Node head = null;

            if(length == 0){
                return head;
            }

            List<Integer> al = new ArrayList<>();

            for(int index = 0 ; index < length ; index++){

                Node temp = lists[index];

                while(temp != null){
                    al.add(temp.data);
                    temp = temp.next;
                }
            }

            if(al.size() == 0) return head;

            Collections.sort(al);

            head = convertLL(al);

            return head;
        }

    public static void main(String[] args) {
        Node[] lists = new Node[3]; 
        lists[0] = convertLL(Arrays.asList(1,4,5));
        lists[1] = convertLL(Arrays.asList(1,3,4)); 
        lists[2] = convertLL(Arrays.asList(2,6));

        Node head = mergeKLists(lists);
        print(head);
    }
}