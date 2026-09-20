// Problem Statement : Given an integer array nums where every element appears three times except for one, which appears exactly once.
// Find the single element and return it.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:

// Input: nums = [2,2,3,2]
// Output: 3
// Explanation : Return the number that appears once in the array.

// Example 2:

// Input: nums = [0,1,0,1,0,1,99]
// Output: 99
// Explanation : Return the number that appears once in the array.

import java.util.HashMap;
import java.util.Map;

class Main {

    // ================================= Brute Force Approach ===================================

        public static int singleNumber(int[] nums){
        
            Map<Integer, Integer> hm = new HashMap<>();

            for(int index = 0 ; index < nums.length ; index++){
                hm.put(nums[index], hm.getOrDefault(nums[index], 0)+1);
            }

            int singleNumber = 0;                                           

            for(Map.Entry<Integer, Integer> keys : hm.entrySet()){
                if(keys.getValue() == 1){
                    singleNumber = keys.getKey();                               // T.C = O(M) + O(M), S.C = O(M) where M = N/3 + 1
                    break;
                }
            }

            return singleNumber;

        }

    // =================================== Optimal Approach ==========================================

        public static int singleNumber_1(int[] nums){

        }

    public static void main(String[] args) {

        int[] nums = {2,2,3,2};
        
        int result = singleNumber(nums);
        
        System.out.println(result);

        int result_1 = singleNumber_1(nums);
        
        System.out.println(result_1);

    }
}