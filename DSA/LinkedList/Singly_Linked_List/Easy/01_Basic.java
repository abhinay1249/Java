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