// Problem Statement: You are given a 0-indexed array nums of length n representing your maximum jump capability from each index.
// You start at index 0. Each element nums[i] represents the maximum number of steps you can jump forward from index i.
// Your goal is to reach the last index of the array (nums[n - 1]) using the minimum number of jumps.
// Return the minimum number of jumps required to reach the last index.
// You can assume that it is always possible to reach the last index.

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: Jump from index 0 → 1 → 4 (2 jumps).

// Example 2:

// Input: nums = [2,3,0,1,4]
// Output: 2
// Explanation: Jump from index 0 → 1 → 4.

class Main {

    // =============================== Brute Force Approach ==================================

        public static int minJumps(int index, int jumps, int[] nums){

            if(index >= nums.length - 1){
                return jumps;
            }

            int minJump = Integer.MAX_VALUE;

            for(int jump = 1 ; jump <= nums[index] ; jump++){
                minJump = Math.min(minJump, minJumps(jump+index, jumps+1, nums));
            }

            return minJump;

        }

        public static int jumpGame(int[] nums) {

            int index = 0;

            int jumps = 0;

            return minJumps(index, jumps, nums);

        }

    // ============================== Greedy Algorithm Approach ==============================

        public static int jumpGame_1(int[] nums){
            
        }

    public static void main(String[] args) {
        
        int[] nums = {2, 3, 1, 1, 4};

        int result = jumpGame(nums);

        System.out.println(result);

        int result_1 = jumpGame_1(nums);

        System.out.println(result_1);

    }
}