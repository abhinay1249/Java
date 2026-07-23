// Problem Statement: Given an array nums and an integer k. 
// Return true if there exist subsequences such that the sum of all elements in subsequences is equal to k else false.

// Example 1:

// Input : nums = [1, 2, 3, 4, 5] , k = 8
// Output : Yes
// Explanation : The subsequences like [1, 2, 5] , [1, 3, 4] , [3, 5] sum up to 8.

// Example 2:

// Input : nums = [4, 3, 9, 2] , k = 10
// Output : No
// Explanation : No subsequence can sum up to 10.


class Main{

    // ===================================== Recursive Approach ==========================================

        public static boolean checkSubsequence(int index, int sum, int k, int[] nums){

            if(index == nums.length){
                if(sum == k){
                    return true;
                }
                return false;           
            }                                                                   // T.C = O(2^N), S.C = O(N), due to recursive stack space.

            sum += nums[index]; 

            if(checkSubsequence(index+1, sum, k, nums) == true) return true;

            sum -= nums[index];

            return checkSubsequence(index+1, sum, k, nums);

        }
    
    public static void main(String[] args) {
        
        int[] nums = {4, 3, 9, 2};
        int k = 10;
        
        boolean result = checkSubsequence(0,0,k,nums);

        System.out.println(result);
    }
}