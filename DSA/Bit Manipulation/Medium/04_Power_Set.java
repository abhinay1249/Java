// Problem Statement: Given an array of numbers, print all subsets of it using bitwise operators.

// Example 1:

// Input: nums = [1, 2, 3]
// Output: [[ ], [1], [2], [3], [1, 2], [2, 3], [3, 1], [1, 2, 3]]
// Explanation:  A power set of an array is an array of all possible subarrays, including an empty array.
// It contains all combinations of elements from the original array.
// By iterating through all possible combinations of the elements in the input array we are able to get the power set of the array.

// Example 2:

// Input: nums = [5, 7, 8]
// Output: [[ ], [5], [7], [8], [5, 7], [7, 8], [8, 5], [5, 7, 8]]
// Explanation:  A power set of an array is an array of all possible subarrays, including an empty array.
// It contains all combinations of elements from the original array.
// By iterating through all possible combinations of the elements in the input array we are able to get the power set of the array.

import java.util.ArrayList;
import java.util.List;

class Main {

    // ============================== Approach Using Left Shift ====================================

        public static List<List<Integer>> powerSet(int[] nums){

            List<List<Integer>> subsets = new ArrayList<>();

            int length = nums.length;

            int numberOfSubsets = 1 << length;

            for(int number = 0 ; number < numberOfSubsets ; number++){

                List<Integer> numbers = new ArrayList<>();                         // T.C = O(2^N * N), S.C = O(2^N * N) 

                for(int index = 0 ; index < length ; index++){
                    if((number & (1 << index)) != 0){
                        numbers.add(nums[index]);
                    }
                }
                subsets.add(numbers);
            }

            return subsets;

        }

    public static void main(String[] args){

        int[] nums = {1, 2, 3};


    }
}