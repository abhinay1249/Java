// Problem Statement : Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
// Find the two elements that appear only once. You can return the answer in any order.

// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

// Example 1:

// Input : nums = [1, 2, 1, 3, 2, 5]
// Output : [3, 5]
// Explanation :  [5, 3] is also a valid answer.

// Example 2:

// Input : nums = [-1, 0]
// Output : [-1, 0]
// Explanation :  [-1, 0] is also a valid answer.

// Example 3:

// Input : nums = [0, 1]
// Output : [1, 0]
// Explanation :  [1, 0] is also a valid answer.

class Main {

    // ================================ Brute Force Approach ==================================

        public static int[] singleNumber(int[] nums){

            int num1 = 0;
            int num2 = 0;

            return new int[]{num1, num2};

        }

    // ================================= Optimal Approach ======================================

        public static  int[] singleNumber_1(int[] nums){

            int num1 = 0;
            int num2 = 0;

            return new int[]{num1, num2};
            
        }
    
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] result = singleNumber(nums);

        int[] result_1 = singleNumber_1(nums);

        System.out.println(result[0]);
        System.out.println(result[1]);
        
    }
}