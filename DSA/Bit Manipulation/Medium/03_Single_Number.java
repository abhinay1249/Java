// Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

// Example 1:

// Input : arr[] = {2,2,1}
// Result : 1
// Explanation : In this array, only the element 1 appear once and so it is the answer.

// Example 2:

// Input : arr[] = {4,1,2,1,2}
// Result : 4
// Explanation : In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.

import java.util.HashMap;
import java.util.Map;

class Main {

    // ================================= Brute Force Approach ==================================

        public static int singleNumer(int[] nums){

            int singleNumber = 0;

            for(int index_1 = 0 ; index_1 < nums.length ; index_1++){

                int number = nums[index_1];
                int counter = 0;

                for(int index_2 = 0 ; index_2 < nums.length ; index_2++){                  

                    if(number == nums[index_2]){                                    // T.C = O(N ^ 2), S.C = O(1)
                        counter++;
                    }
                }

                if(counter == 1){
                    singleNumber = nums[index_1];
                    break;
                }

            }

            return singleNumber;
            
        }

    // ================================= Better Approach ==================================

        public static int singleNumber_1(int[] nums){

            int singleNumber = 0;

            Map<Integer, Integer> hm = new HashMap<>();

            for(int index = 0 ; index < nums.length ; index++){
                hm.put(nums[index], hm.getOrDefault(nums[index],0)+1);
            }

            for(Map.Entry<Integer, Integer> keys : hm.entrySet()){
                if(keys.getValue() == 1){
                    singleNumber = keys.getKey();                                   // T.C = O(N) + O(N/2+1) + O(N), S.C = O(N/2+1)
                    break;
                }
            }

            int counter = 0;

            for(int index = 0 ; index < nums.length ; index++){
                if(nums[index] == singleNumber){
                    counter++;
                }
            }

            return counter == 1 ? singleNumber : -1;

        }

    // ================================== Optimal Approach ======================================

        public static int singleNumber_2(int[] nums){

            int appearsOnce = 0;

            for(int index = 0 ; index < nums.length ; index++){
                appearsOnce ^= nums[index];                                     // T.C = O(N), S.C = O(1)
            }

            return appearsOnce;

        }

    public static void main(String[] args) {

        int[] nums = {4,1,2,1,2};

        int result = singleNumber(nums);

        System.out.println(result);

        int result_1 = singleNumber_1(nums);

        System.out.println(result_1);

        int result_2 = singleNumber_2(nums);

        System.out.println(result_2);

    }
}
