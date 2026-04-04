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

    static Node convert(int[] nums){
        int length = nums.length;
        
        Node head = new Node(nums[0]);
        
        Node mover = head;
        
        for(int i = 1 ; i < length ; i++){
            Node temp = new Node(nums[i]);
            mover.pointer = temp;
            mover= temp;
        }
        
        return head;
    }

    // ================================ Insertion At Head  ==============================================
    
        static Node insertAtHead(Node head, int val){
            Node temp = new Node(val,head);
            return temp;
        }
    
    // ================================ Insertion At Tail ===============================================

        static Node insertAtTail(Node head, int val){
            if(head == null){
                return new Node(val,null);    
            }

            Node temp = head;

            while(temp.pointer != null){
                temp = temp.pointer;
            }
            temp.pointer = new Node(val,null);
            return head;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        Node head = convert(nums);
        
        Node temp = head;
        
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.pointer;
        }
        
        System.out.println();
        
        Node insertAtHead = insertAtHead(head,100);
        
        while(insertAtHead != null){
            System.out.print(insertAtHead.data+" ");
            insertAtHead = insertAtHead.pointer;
        }
        
        System.out.println();
        
        Node insertAtTail = insertAtTail(head,100);
        
        while(insertAtTail != null){
            System.out.print(insertAtTail.data+" ");
            insertAtTail = insertAtTail.pointer;
        }
    
    }
}