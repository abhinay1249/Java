// Problem Statement: Given an array of distinct integers and a target, you have to return the list of all unique combinations 
// where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from the given array an unlimited number of times. 
// Two combinations are unique if the frequency of at least one of the chosen numbers is different.

// It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


// Example 1:

// Input: array = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.


// Example 2:

// Input: array = [2], target = 1
// Output: []
// Explaination: No combination is possible.

import java.util.*;

class Main{

    // ====================================== Recursive Approach ======================================

        private static List<List<Integer>> recursiveCombinationSum(int index, List<List<Integer>> al, int target, int[] nums, List<Integer> ds){
        
            if(index == nums.length){
                if(target == 0){
                    al.add(new ArrayList<>(ds));
                }
                return al;
            }

            if(target >= nums[index]){
                ds.add(nums[index]);
                recursiveCombinationSum(index,al,target - nums[index],nums, ds);
                ds.remove(ds.size()-1);
            }

            recursiveCombinationSum(index+1, al, target, nums, ds);

            return al;
        
        }

        public static List<List<Integer>> combinationSum(int[] nums, int target){

            int index = 0;
            List<List<Integer>> al = new ArrayList<>();
            List<Integer> ds = new ArrayList<>(); 


            return recursiveCombinationSum(index, al, target, nums, ds);

        }

    public static void main(String[] args) {

        int[] nums = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ds = combinationSum(nums, target);

        System.out.print(ds);

    }
}


