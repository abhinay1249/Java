// Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

// Example 1:

// Input: N = 3, arr[] = {5,2,1}
// Output: 0,1,2,3,5,6,7,8
// Explanation: We have to find all the subset’s sum and print them.
// In this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2].
// [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8

// Example 2:

// Input: N = 3, arr[]= {3,1,2}
// Output: 0,1,2,3,3,4,5,6
// Explanation: We have to find all the subset’s sum and print them.
// In this case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2].
// [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6

import java.util.*;

class Main{

    // ============================================== Recursive Approach - 1 ========================================

        private static List<Integer> recursiveSubsets(int index, int[] nums, List<Integer> al, int sum){

            al.add(sum);

            if(index == nums.length){
                return al;
            }

            for(int i = index ; i < nums.length ; i++){
                sum += nums[i];
                recursiveSubsets(i+1, nums, al, sum);                       
                sum -= nums[i];
            }

            return al;

        }

        public static List<Integer> subsets(int[] nums, List<Integer> al){

            int sum = 0;
            int index = 0;

            recursiveSubsets(index, nums, al, 0);

            return al;

        } 

    public static void main(String[] args){

        int[] nums = {5, 2, 1};

        List<Integer> al = new ArrayList<>();

        subsets(nums,al);

        Collections.sort(al);

        System.out.println(al);

    }
}