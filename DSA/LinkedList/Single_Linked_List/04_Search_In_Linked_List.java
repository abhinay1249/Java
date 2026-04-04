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

    static boolean isPresent(int[] nums, int value){
        
        Node head = Node.convertArrayToLL(nums);

        Node temp = head;
        
        boolean isPresent = false;

        while(temp != null){
            if(temp.data == value){
                return true;
            }
            temp=temp.pointer;
        }

        return isPresent;
    }

}

class Main{
    public static void main(String[] args) {
        int[] nums = {12,43,134,141,431,0};

        Node head = Node.convertArrayToLL(nums);
        
        Node temp = head;

        while(temp != null){
            // System.out.print(temp.data+" ");
            temp=temp.pointer;
        }

        boolean result = Node.isPresent(nums,134);

        System.out.println(result);
    }
}