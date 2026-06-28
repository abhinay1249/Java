// Problem Statement: Add two numbers represented as Linked Lists.

// Example 1:

// Input: num1 = 243, num2 = 564
// Output:sum = 807; L = [7,0,8]
// Explanation: Since the digits are stored in reverse order, reverse the numbers first to get the or original number and then 
// add them as → 342 + 465 = 807.

// Example 2:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: Result: [8,9,9,9,0,0,0,1]
// Explanation: Since the digits are stored in reverse order, 
// reverse the numbers first to get the original number and then add them as → 9999999 + 9999 = 8999001. 

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

    // =========================== Convert Array into Linked List ===============================
    
        private static Node convert(int[] nums){
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
    
    // ============================== Print the Linked List ================================

        private static void print(Node head){
            
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            
        }

    // ============================== Only Approach =======================================
    
        public static Node addTwoLL(Node head1, Node head2){

            Node temp1 = head1;
            Node temp2 = head2;

            Node dummyNode = new Node(-1);
            Node curr = dummyNode;

            int carry = 0;

            while(temp1 != null || temp2 != null){
                int sum = carry;

                if(temp1 != null){
                    sum += temp1.data;
                }

                if(temp2 != null){                  // T.C = O(max(l1,l2))
                    sum += temp2.data;              // S.C = O(max(l1,l2)) because we are creating a new linked list to store the result.
                }

                Node newNode = new Node(sum % 10);
                carry = sum / 10;

                curr.next = newNode;
                curr = curr.next;

                if(temp1 != null){
                    temp1 = temp1.next;
                }

                if(temp2 != null){
                    temp2 = temp2.next;
                }
            }

            if(carry == 1){
                Node newHead = new Node(1);
                curr.next = newHead;
            }
            return dummyNode.next;
    }    
    
    public static void main(String[] args) {
        int[] nums1 = {9,9,9,9,9};
        int[] nums2 = {9,9};
        
        Node head_1 = convert(nums1);
        Node head_2 = convert(nums2);
        
        Node result = addTwoLL(head_1,head_2);
        print(result);
    }
}