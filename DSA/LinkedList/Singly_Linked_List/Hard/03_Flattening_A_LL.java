// Problem Statement: Given a linked list containing ‘N’ head nodes where every node in the linked list contains two pointers:

// ‘Next’ points to the next node in the list
// ‘Child’ pointer to a linked list where the current node is the head

// Each of these child linked lists is in sorted order and connected by a 'child' pointer. 
// Your task is to flatten this linked list such that all nodes appear in a single layer or level in a 'sorted order'.

// Example 1:- 

//Input :
// 1 → 2 → 3
// |   |   |
// 4   5   6
// |       |
// 7       8

//Output : 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
// Explanation : The flattened linked list is 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8, which is in sorted order.

// Example 2:-

//Input :
// 10 → 20 → 30
// |    |    |
// 40   50   60

//Output : 10 → 20 → 30 → 40 → 50 → 60
// Explanation : The flattened linked list is 10 → 20 → 30 → 40 → 50 → 60, which is in sorted order.



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node{
    int data;
    Node next;
    Node child;
    
    Node(int data, Node next,Node child){
        this.data = data;
        this.next = next;
        this.child = child;
    }

    Node(int data){
        this.data = data;
        this.next = null;
        this.child = null;
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

        private static Node convertFromAL(List<Integer> al){
            int length = al.size();

            Node head = new Node(al.get(0));
            Node mover = head;

            for(int index = 1; index < length ; index++){
                Node temp = new Node(al.get(index));
                mover.child = temp;
                mover = temp;
            }
            return head;
        }

        public static Node flattenLL(Node head){
            Node temp1 = head;
            List<Integer> al = new ArrayList<>();
            Node temp2 = head;

            while(temp1 != null){
                temp2 = temp1;
                while(temp2 != null){
                    al.add(temp2.data);
                    temp2 = temp2.child;                    // T.C = O(2(N * M)) + O(X LOG X), S.C = O(N*M)*2 -> X = N * M 
                }                           // where N is the number of head nodes and M is the maximum number of child nodes in any chain.
                temp1 = temp1.next;
            }

            Collections.sort(al);

            Node newHead = convertFromAL(al);

            return newHead;
        }

    // ==================== Optimal Approach ================================

        private static Node mergeLL(Node list1, Node list2){
            Node dummyNode = new Node(-1);
            Node temp = dummyNode;
                
            while(list1 != null && list2 != null){
                if(list1.data < list2.data){
                    temp.child = list1;
                    temp = list1;
                    list1 = list1.child;
                }else{
                    temp.child = list2;
                    temp = list2;
                    list2 = list2.child;            // T.C = O(2*M[Merge])*N = O(2MN), S.C = O(N), Not external space but internal stack space due to recursion.
                }
                temp.next = null;
            }
            if(list1 != null){
                temp.child = list1;
            }
            if(list2 != null){
                temp.child = list2;
            }
            return dummyNode.child;
        }


        public static Node flattenLL_1(Node head){
            if(head == null || head.next == null){
                return head;
            }

            Node mergedHead = flattenLL_1(head.next);
            return mergeLL(head,mergedHead);
        }
    
    public static void main(String[] args) {
    
        // Creating vertical lists (child chains)
    
        Node head1 = new Node(1);
        head1.child = new Node(4);
        head1.child.child = new Node(7);
    
        Node head2 = new Node(2);
        head2.child = new Node(5);
    
        Node head3 = new Node(3);
        head3.child = new Node(6);
        head3.child.child = new Node(8);
    
        // Connecting horizontally (next pointers)
        head1.next = head2;
        head2.next = head3;
    
        Node head = head1;
    
        // Flatten
        Node result = flattenLL(head);
    
        // Print result
        print(result);

        System.out.println();
        
        Node h1 = new Node(1);
        h1.child = new Node(4);
        h1.child.child = new Node(7);
    
        Node h2 = new Node(2);
        h2.child = new Node(5);
    
        Node h3 = new Node(3);
        h3.child = new Node(6);
        h3.child.child = new Node(8);
    
        h1.next = h2;
        h2.next = h3;
        
        Node head_1 = h1;
    
        Node result_1 = flattenLL_1(head_1);
    
        Node temp_1 = result_1;
        
        print(temp_1);
    }
}