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
    
    // ============================== Convert Array into Linked List ==========================

        static Node convert(int[] nums){
            int length = nums.length;

            Node head = new Node(nums[0]);

            Node mover = head;

            for(int index = 1 ; index < length ; index++){
                Node temp = new Node(nums[index]);
                mover.next = temp;
                mover = temp;
            }

            return head;
        }
        
    // ================================ Brute Force Approach ===================================

        static int lengthOfCycle(Node head){
            Node temp = head;

            Map<Node,Integer> hs = new HashMap<>();
            List<Node> al = new ArrayList<>();

            while(temp != null){
                if(hs.containsKey(temp)){                       // T.C = O(N) + O(N * K) = O(N^2), S.C = O(2N)
                    if(!(al.contains(temp))){
                        al.add(temp);
                    }else{
                        break;   
                    }
                }else{
                    hs.put(temp,1);
                }
                temp = temp.next;
            }
            return al.size();
        }

    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        
        Node head = convert(nums);
        
        Node temp = head;
        Node thirdNode = null;
        int count = 1;
        
        while(temp.next != null){
            if(count==3){
                thirdNode = temp;
            }
            temp = temp.next;
            count++;
        }
        
        temp.next = thirdNode;
        
        int res = lengthOfCycle(head);

        System.out.print(res);
        
        System.out.println();
    }
}