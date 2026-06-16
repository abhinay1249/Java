//Problem Statement: Create a singly linked list and print the data of the last node.

// Example 1:-

// Input: [4,1,5,3,2]
// Output: 2
// Explanation: The last node of the linked list contains the data 2,
// which is the last element of the input array. Therefore, the output is 2.

// Example 2:-

// Input: [10,20,30,40,50]
// Output: 50
// Explanation: The last node of the linked list contains the data 50,
// which is the last element of the input array. Therefore, the output is 50.


class Node{

    int data;
    Node pointer;

    Node(int data,Node pointer){
        this.data = data;
        this.pointer = pointer;
    }

    Node(int data){
        this.data = data;
        this.pointer = null;
    }

}
    
class Main{
    public static void main(String[] args) {
        int[] nums = {4,1,5,3,2};
        
        Node y = new Node(nums[4],null);

        System.out.println(y.data);
    }
}