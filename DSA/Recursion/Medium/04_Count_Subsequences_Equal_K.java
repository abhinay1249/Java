// Problem Statement: Given an array nums and an integer k.
// Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.

// Example 1:

// Input : nums = [4, 9, 2, 5, 1] , k = 10
// Output : 2
// Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].

// Example 2:

// Input : nums = [4, 2, 10, 5, 1, 3] , k = 5
// Output : 3
// Explanation : The possible subsets with sum k are [4, 1] , [2, 3] , [5].

class Main{
    
    private static int recursiveSubsequences(int index, int sum, int k, int[] nums){

        if(index == nums.length){
            if(sum == k){
                return 1;
            }
            return 0;
        }

        sum += nums[index];
        int includeCount = recursiveSubsequences(index+1,sum,k,nums);
        sum -= nums[index];
        int excludeCount = recursiveSubsequences(index+1,sum,k,nums);

        return includeCount+excludeCount;
        
    }
    
    public static int countSubsequences(int[] nums, int k){

        int index = 0;
        int sum = 0;
        
        int result = recursiveSubsequences(index, sum, k, nums);

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {4, 2, 10, 5, 1, 3};
        int k = 5 ;
        int result = countSubsequences(nums, k);

        System.out.println(result);

    }
}