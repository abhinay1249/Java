// Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target).
// find all unique combinations in candidates where the candidate numbers sum to target. 
// Each number in candidates may only be used once in the combination.

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: [ [1,1,6], [1,2,5], [1,7], [2,6]]
// Explanation: These are the unique combinations whose sum is equal to target.
 
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: [[1,2,2],[5]]
// Explanation: These are the unique combinations whose sum is equal to target.

import java.util.*;

class Main{


    // =================================== Brute Force Approach - 1========================================

        private static Set<List<Integer>> recursiveCombinationSum2(int index, Set<List<Integer>> hs, int target, int sum, int[] nums, List<Integer> ds){

            if(target < sum){
                return hs;
            }

            if(index == nums.length){
                if(sum == target){
                    List<Integer> temp = new ArrayList<>(ds);
                    Collections.sort(temp);
                    hs.add(temp);
                }                                                   // T.C = O(2^N * N LOG N), S.C = O(N * 2^N)
                return hs;
            }

            ds.add(nums[index]);
            recursiveCombinationSum2(index+1, hs, target, sum += nums[index], nums, ds);
            ds.remove(ds.size()-1);
            recursiveCombinationSum2(index+1, hs, target, sum -= nums[index], nums, ds);

            return hs;

        }

        public static List<List<Integer>> combinationSum2(int[] nums, int target){

            int index = 0;
            Set<List<Integer>> hs = new HashSet<>();
            List<Integer> ds = new ArrayList<>();

            recursiveCombinationSum2(index, hs, target, 0, nums, ds);

            List<List<Integer>> al = new ArrayList<>(hs);

            return al;

        }


    // =========================================== Brute Force Approach - 2 ==============================================

        private static Set<List<Integer>> recursiveCombinationSum2_1(int index, Set<List<Integer>> hs, int target, int[] nums, List<Integer> ds){


            if(index == nums.length){
                if(target == 0){
                    List<Integer> temp = new ArrayList<>(ds);
                    Collections.sort(temp);
                    hs.add(temp);
                }                                                   // T.C = O(2^N * N LOG N), S.C = O(N * 2^N)
                return hs;
            }

            if(target >= nums[index]){
                ds.add(nums[index]);
                recursiveCombinationSum2_1(index+1, hs, target - nums[index], nums, ds);
                ds.remove(ds.size()-1);
            }

            recursiveCombinationSum2_1(index+1, hs, target, nums, ds);

            return hs;

        }

        public static List<List<Integer>> combinationSum2_1(int[] nums, int target){

            int index = 0;
            Set<List<Integer>> hs = new HashSet<>();
            List<Integer> ds = new ArrayList<>();

            recursiveCombinationSum2_1(index, hs, target, nums, ds);

            List<List<Integer>> al = new ArrayList<>(hs);

            return al;

        }


    public static void main(String[] args){
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> al = combinationSum2(nums,target);
        List<List<Integer>> al_1 = combinationSum2_1(nums,target);


        System.out.println(al);
        System.out.println(al_1);

    }
}