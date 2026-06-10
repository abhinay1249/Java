// Problem Statement: Given a Linked List, delete node types and print the updated list.

// Example:-
// Input: 12 -> 45 -> 356 -> 553 -> 262 -> 90, k = 3
// Output: 12 -> 45 -> 553 -> 262 -> 90
// Explanation: The node at position 3 is 356, which is removed from the list.


class Node{
    int data;
    Node pointer;

    Node(int data, Node pointer){
        this.data = data;
        this.pointer = pointer;
    }
    Node(int data){
        this.data = data;
        this.pointer = null;
    }

    // ================================ Convert Array into Linked List =====================================

        public static Node convertArrayToLinkedList(int[] nums){

            int length = nums.length;

            Node head = new Node(nums[0]);

            Node mover = head;

            for(int index = 1 ; index < length ; index++){
                Node temp = new Node(nums[index]);
                mover.pointer = temp;
                mover = temp;
            }

            return head;

        }

    // ================================ Removal Of Head Node ==============================================

        public static Node deleteHead(Node head){

            if(head == null) return null;

            head = head.pointer;

            return head;
        }

    // ================================ Removal Of Tail Node ==============================================

        public static Node deleteTail(Node head){
            if(head == null || head.pointer == null){
                return null;
            }

            Node temp = head;

            while(temp.pointer.pointer != null){
                temp=temp.pointer;
            }

            temp.pointer = null;

            return head;
        }

    // ================================ Removal Of Node at Kth Position ==============================================

        public static Node removeAtPosition(Node head, int target){

            if(head == null){
                return head;
            }

            if(target == 1){
                head = head.pointer;

                return head;
            }

            Node temp = head;

            int count = 0;

            Node prev = null;

            while(temp != null){
                count++;

                if(count == target){
                    prev.pointer = temp.pointer;
                    break;
                }
                prev = temp;
                temp = temp.pointer;
            }
            return head;
        }

    // ================================ Removal Of Value Node ==============================================
        
        public static Node removeOfValue(Node head, int target){

            if(head == null){
                return head;
            }

            while(head!= null && target == head.data){
                head = head.pointer;
            }

            Node temp = head;

            Node prev = null;

            while(temp != null){
                int value = temp.data;

                if(value == target){
                    prev.pointer = prev.pointer.pointer;
                }else{
                    prev = temp;
                }
                
                temp = temp.pointer;
            }
            return head;
        } 
    
}   


class Main{

    public static void main(String[] args) {
        int[] nums = {12,45,356,553,262,90};

        Node head_0 = Node.convertArrayToLinkedList(nums);
        Node head_1 = Node.convertArrayToLinkedList(nums);
        Node head_2 = Node.convertArrayToLinkedList(nums);
        Node head_3 = Node.convertArrayToLinkedList(nums);
        Node head_4 = Node.convertArrayToLinkedList(nums);

        System.out.print("LinkedList --> ");

        while(head_1!=null){
            System.out.print(head_1.data+" ");
            head_1 = head_1.pointer;
        }

        System.out.println();

        Node head = Node.deleteHead(head_0);

        System.out.print("Removal of Head --> ");

        while(head!=null){
            System.out.print(head.data+" ");
            head = head.pointer;
        }

        System.out.println();

        Node tail = Node.deleteTail(head_2);

        System.out.print("Removal of Tail --> ");

        while(tail != null){
            System.out.print(tail.data+" ");
            tail = tail.pointer;
        }

        System.out.println();

        Node atPosition = Node.removeAtPosition(head_3,4);
 
        System.out.print("Removal At Position --> ");

        while(atPosition != null){
            System.out.print(atPosition.data+" ");
            atPosition = atPosition.pointer;
        }

        System.out.println();

        Node value = Node.removeAtPosition(head_4,262);
 
        System.out.print("Removal At Value --> ");

        while(value != null){
            System.out.print(value.data+" ");
            value = value.pointer;
        }
    }
    
}
