// Problem Statement: Given an array nums and an integer k.
// Print the non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.

// Example 1:

// Input : nums = [4, 9, 2, 5, 1] , k = 10
// Output : [ [9, 1] , [4, 5, 1] ]
// Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].

// Example 2:

// Input : nums = [4, 2, 10, 5, 1, 3] , k = 5
// Output : [ [4, 1] , [2, 3] , [5] ]
// Explanation : The possible subsets with sum k are [4, 1] , [2, 3] , [5].

import java.util.*;

class Main{

    public static void subsequenceEqualK(int index, List<Integer> al, int sum, int k, int[] nums){

        if(index == nums.length){
            if(sum == k){
                System.out.println(al);
                return;
            }
            return;
        }

        al.add(nums[index]);
        subsequenceEqualK(index+1, al, sum += nums[index], k, nums);
        al.remove(al.size()-1);
        subsequenceEqualK(index+1, al, sum -= nums[index], k, nums);    

    }
    public static void main(String[] args) {
        
        int[] nums = {1,2,1};
        int k = 2;

        subsequenceEqualK();

    }
}