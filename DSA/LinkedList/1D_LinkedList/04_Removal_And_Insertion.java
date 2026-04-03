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


    static Node deleteHead(Node head){
        if(head == null) return null;
        
        head = head.pointer;

        return head;

    }
}


class Main{

    public static void main(String[] args) {
        int[] nums = {12,45,356,553,262,90};

        Node head = Node.convertArrayToLinkedList(nums);

        head = Node.deleteHead(head);

        while(head!=null){
            System.out.println(head.data);
            head = head.pointer;
        }
    }
    
}
