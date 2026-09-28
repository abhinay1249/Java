// Problem Statement : Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
// Find the two elements that appear only once. You can return the answer in any order.

// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

// Example 1:

// Input : nums = [1, 2, 1, 3, 2, 5]
// Output : [3, 5]
// Explanation : [5, 3] is also a valid answer, but it should be in increasing order.

// Example 2:

// Input : nums = [-1, 0]
// Output : [-1, 0]
// Explanation : [-1, 0] is also a valid answer, but it should be in increasing order.

// Example 3:

// Input : nums = [0, 1]
// Output : [1, 0]
// Explanation : [1, 0] is also a valid answer, but it should be in increasing order.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

    // ================================ Brute Force Approach ==================================

        public static int[] singleNumber(int[] nums){
                    
            Map<Integer, Integer> freqCount = new HashMap<>();

            for(int index : nums){
                freqCount.put(index, freqCount.getOrDefault(index,0)+1);
            }
            List<Integer> singleNumbers = new ArrayList<>();

            for(Map.Entry<Integer, Integer> keys : freqCount.entrySet()){
                if(keys.getValue() == 1){
                    singleNumbers.add(keys.getKey());
                }

                if(singleNumbers.size()==2){                                            // T.C = O(N) + O(M), S.C = (M)
                    break;
                }
            }
                
            Collections.sort(singleNumbers);

            return new int[]{singleNumbers.get(0), singleNumbers.get(1)};

        }

    // ================================= Optimal Approach ======================================

        public static int[] singleNumber_1(int[] nums){

            return new int[]{, };
            
        }
    
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] result = singleNumber(nums);

        System.out.println(result[0]);
        System.out.println(result[1]);

        int[] result_1 = singleNumber_1(nums);

        System.out.println(result_1[0]);
        System.out.println(result_1[1]);
        
    }
}