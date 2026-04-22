// Problem Statement: Given the head of a doubly linked list and an integer key,
//  delete all the occurrences of key from the linked list and return the head of the modified linked list.



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
    
    // =========================== Convert Array into Linked List ===============================

        private static Node convert(int[] nums){
            int length = nums.length;

            Node head = new Node(nums[0]);

            Node prev = head;

            for(int index = 1; index < length ; index++){
                Node temp = new Node(nums[index],null,prev);
                prev.next = temp;
                prev = temp;
            }
            return head;
        }

    // ============================== Print the Linked List ================================

        private static void print(Node head){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

    // ============================== Only Approach =======================================

        public static Node deleteAllOccurences(Node head, int key){
            Node temp = head;
            Node prevNode = null;
            Node nextNode = null;

            while(temp != null){
                if(temp.data == key){
                    if(temp == head){
                        head = head.next;
                    }
                    prevNode = temp.prev;
                    nextNode = temp.next;

                    if(prevNode != null) prevNode.next = nextNode;
                    if(nextNode != null) nextNode.prev = prevNode;

                    temp = nextNode;
                }else{
                    temp = temp.next;
                }
            }
            return head;
        }
    public static void main(String[] args) {
        
        int[] nums = {10,4,10,10,6,10};
        int key = 10;
        Node head = convert(nums);

        Node result = deleteAllOccurences(head, key);
        print(result);
    }
}