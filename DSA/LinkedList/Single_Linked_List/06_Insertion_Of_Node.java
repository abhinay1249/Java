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

    // ================================ Insertion At Head =====================================
    
        static Node insertAtHead(Node head, int val){
            Node temp = new Node(val,head);
            return temp;
        }
    
    // ================================ Insertion At Tail =====================================

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
    
    // ================================ Insertion At KthPos =====================================

        static Node insertAtKthPos(Node head, int element, int k){
            if(head == null){
                if(k == 1){
                    return new Node(element,null);
                }
            }

            if(k == 1){
                Node temp = new Node(element,head);
                return temp;
            }

            Node temp = head;

            int count = 0;

            while(temp != null){
                count++;

                if(count == k-1){
                    Node newNode = new Node(element);
                    newNode.pointer = temp.pointer;
                    temp.pointer = newNode;
                    break;
                }
                temp = temp.pointer;
            }
            return head;
        }
    
    // ================================ Insertion At Before Value =====================================

        static Node insertAtBeforeValue(Node head, int element, int value){
            if(head == null){
                return head;
            }

            if(head != null && head.data == value){
                Node temp = new Node(element,head);
                return temp;
            }
            Node temp = head;
            Node prev = null;
            Node newNode = new Node(element);

            while(temp != null){
                if(temp.data == value){
                    newNode.pointer = prev.pointer;
                    prev.pointer = newNode;
                    break;
                }else{
                    prev = temp;
                }
                temp = temp.pointer;
            }
            return head;
        }   
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        // int[] nums_1 = {1,1,1,1,1,1};
        Node head_1 = convert(nums);
        Node head_2 = convert(nums);
        Node head_3 = convert(nums);
        // Node head_4 = convert(nums_1);
        Node head_4 = convert(nums);
        
        System.out.print("Linked List --> ");
        Node temp = head_1;
        
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.pointer;
        }
        
        System.out.println();
        
        System.out.print("Insertion At Head --> ");
        
        Node insertAtHead = insertAtHead(head_1,100);
        
        while(insertAtHead != null){
            System.out.print(insertAtHead.data+" ");
            insertAtHead = insertAtHead.pointer;
        }
        
        System.out.println();
        
        System.out.print("Insertion At Tail --> ");
         
        Node insertAtTail = insertAtTail(head_2,100);
        
        while(insertAtTail != null){
            System.out.print(insertAtTail.data+" ");
            insertAtTail = insertAtTail.pointer;
        }
        
        System.out.println();
        
        System.out.print("Insertion At KthPos --> ");
        
        Node insertAtKthPos = insertAtKthPos(head_3,100,4);
        
        while(insertAtKthPos != null){
            System.out.print(insertAtKthPos.data+" ");
            insertAtKthPos = insertAtKthPos.pointer;
        }

        System.out.println();
        
        System.out.print("Insertion At Before Value --> ");
        
        Node insertAtBeforeValue = insertAtBeforeValue(head_4,100,4);
        
        while(insertAtBeforeValue != null){
            System.out.print(insertAtBeforeValue.data+" ");
            insertAtBeforeValue = insertAtBeforeValue.pointer;
        }
    
    }
}