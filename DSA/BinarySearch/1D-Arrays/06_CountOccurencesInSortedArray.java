// Problem Statement: You are given a sorted array containing N integers and a number X, 
// you have to find the occurrences of X in the given array.

// Example 1:
// Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
// Output : 4
// Explanation : 3 is occurring 4 times in the given array so it is our answer.

// Example 2:
// Input: N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
// Output : 5
// Explanation : 2 is occurring 5 times in the given array so it is our answer.

class Main {
    
    // ======================= Brute Force Approach ================================
        
        static int first(int[] nums, int target){

            int length = nums.length;
            int low = 0, high = length - 1;
            int first = -1;

            while(low <= high){

                int mid = low + ((high - low)/2);

                if(nums[mid] == target){
                    first = mid;
                    high = mid - 1;
                }else if(nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return first;
        }
    
    // ======================= Better Approach =======================================

        static int last(int[] nums, int target){

            int length = nums.length;
            int low = 0, high = length - 1;
            int last = -1;

            while(low <= high){

                int mid = low + ((high - low)/2);

                if(nums[mid] == target){
                    last = mid;
                    low = mid + 1;
                }else if(nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return last;
        }

        static int firstAnsLastOccurence_3(int[] nums, int target){

            int length = nums.length;
            int first = first(nums,target);

            if(first == -1){
                return 0;
            }
            int last = last(nums,target);

            return (last - first)+1; 
        }

    public static void main(String[] args) {
        int[] nums = {3,4,13,13,13,20,40};
        int target = 13;
        int result = firstAnsLastOccurence_3(nums,target);
        
        System.out.println(result);
        
    }
}