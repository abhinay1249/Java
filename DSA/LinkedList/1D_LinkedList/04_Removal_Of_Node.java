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

    // ================================ Convert Array into Linked List ==============================================

        static Node convertArrayToLinkedList(int[] nums){

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

    // ================================ Removal Of Head ==============================================

        static Node deleteHead(Node head){
            if(head == null) return null;

            head = head.pointer;

            return head;
        }

    // ================================ Removal Of Tail ==============================================

        static Node deleteTail(Node head){
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
}   


class Main{

    public static void main(String[] args) {
        int[] nums = {12,45,356,553,262,90};

        Node head_1 = Node.convertArrayToLinkedList(nums);

        Node head = Node.deleteHead(head_1);

        while(head!=null){
            System.out.print(head.data+" ");
            head = head.pointer;
        }

        System.out.println();

        Node tail = Node.deleteTail(head_1);

        while(tail != null){
            System.out.print(tail.data+" ");
            tail = tail.pointer;
        }
    }
    
}
