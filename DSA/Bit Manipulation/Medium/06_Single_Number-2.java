// Problem Statement : Given an integer array nums where every element appears three times except for one, which appears exactly once.
// Find the single element and return it.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:

// Input : nums = [2,2,3,2]
// Output : 3
// Explanation : Return the number that appears once in the array.

// Example 2:

// Input : nums = [0,1,0,1,0,1,99]
// Output : 99
// Explanation : Return the number that appears once in the array.

import java.util.Arrays;
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
                    singleNumber = keys.getKey();                                 // T.C = O(M) + O(M), S.C = O(M), where M = N/3 + 1
                    break;
                }
            }

            return singleNumber;

        }

    // ======================== Better Approach [Bit Manipulation] ===============================

        public static int singleNumber_1(int[] nums){
            int singleNumber = 0;

            for(int bitNumber = 0 ; bitNumber < 32 ; bitNumber++){
                int counter = 0;
                for(int index = 0 ; index < nums.length ; index++){
                    if((nums[index] & (1 << bitNumber)) != 0){
                        counter+=1;                                                // T.C = O(N * 32), S.C = O(1)
                    }
                }
                if(counter % 3 == 1){
                    singleNumber = singleNumber | (1 << bitNumber);
                }
            }

            return singleNumber;

        }

    // ======================== Better [than Bit Manipulation] Approach =============================

        public static int singleNumber_2(int[] nums){
            
            Arrays.sort(nums);

            int singleNumber = 0;
            boolean flag = false;                                                   // T.C = O(N LOG N) + O(N/3), S.C = O(1)

            for(int index = 1 ; index < nums.length ; index+=3){
                if(nums[index-1] != nums[index]){
                    singleNumber = nums[index-1];
                    flag = true;
                    break;
                }
            }

            return (flag == false) ? nums[nums.length-1] : singleNumber;

        }

    // ================================= Optimal Approach ==========================================
        
        public static int singleNumber_3(int[] nums){

            int ones = 0;
            int twos = 0;

            for(int index = 0 ; index < nums.length ; index++){
                ones = (ones ^ nums[index]) & (~twos);                          // T.C = O(N), S.C = O(1)
                twos = (twos ^ nums[index]) & (~ones);
            }

            return ones;

        }

    public static void main(String[] args) {

        int[] nums = {2,2,3,2};
        
        int result = singleNumber(nums);
        
        System.out.println(result);

        int result_1 = singleNumber_1(nums);
        
        System.out.println(result_1);

        int result_2 = singleNumber_2(nums);
        
        System.out.println(result_2);

        int result_3 = singleNumber_3(nums);
        
        System.out.println(result_3);

    }
}