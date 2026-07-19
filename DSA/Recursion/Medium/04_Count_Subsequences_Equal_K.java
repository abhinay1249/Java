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

import java.util.ArrayList;
import java.util.List;

class Main{


    private static boolean sumEqualsK(List<Integer> list, int k){
        
        int length = list.size();

        int sum = 0;

        for(int index = 0 ; index < length ; index++){
            sum+=list.get(index);

            if(sum > k){
                return false;
            }
        }

        return sum < k ? false : true;
    }
    
    
    private static int recursiveSubsequences(int index, int[] nums, List<Integer> subsequences, int k, int count){

        if(index == nums.length){
            boolean valid = sumEqualsK(subsequences,k);
            if(valid){
                count++;
            }
            return count;
        }

        subsequences.add(nums[index]);
        recursiveSubsequences(index+1, nums, subsequences, k, count);
        subsequences.remove(nums[index]);
        recursiveSubsequences(index+1, nums, subsequences, k, count);

        return count;

    }
    
    public static int countSubsequences(int[] nums, int k){

        List<Integer> subsequences = new ArrayList<>();

        int result = recursiveSubsequences(0, nums, subsequences, k, 0);

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {4,9,2,5,1};
        int k = 10;
        int result = countSubsequences(nums, k);

        System.out.println(result);

    }
}