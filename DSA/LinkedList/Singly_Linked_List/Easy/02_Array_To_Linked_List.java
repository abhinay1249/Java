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
    
    // ============================ Convert Array into Linked List =========================
    
    static Node convertArrayToLL(int[] nums){

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

}

class Main{
    public static void main(String[] args) {
        int[] nums = {12,43,134,141,431,0};

        Node head = Node.convertArrayToLL(nums); 

        System.out.println(head.data);

    }
}