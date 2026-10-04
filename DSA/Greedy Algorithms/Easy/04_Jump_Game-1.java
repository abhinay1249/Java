
// Initially starting at the first index of the array, determine if it is possible to reach the last index.
// Return true if the last index can be reached, otherwise return false.

// Example 1:

// Input : nums = [2, 3, 1, 1, 4]
// Output : true
// Explanation : We can simply take Jump of 1 step at each index to reach the last index.

// Example 2:

// Input : nums = [3, 2, 1, 0, 4]
// Output : false
// Explanation : No matter how you make jumps you will always reach the third index (0 base) of the array.
// The maximum jump of index three is 0, So you can never reach the last index of array.

class Main {

    public static boolean jumpGame(int[] nums){

        if(nums.length == 1){
            return true;
        }

        if(nums.length == 2){
            return nums[0] > 0;
        }

        int length = nums.length;
        int maxIdx = 0, index = 0, jumpLength = 0;

        while(index < length && index <= maxIdx){
            
            jumpLength = index + nums[index];
            maxIdx = Math.max(jumpLength, maxIdx);
            if(maxIdx >= length - 1) return true;

            index++;
        }

        return false;

    }
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 0, 4};

        boolean result = jumpGame(nums);

        System.out.println(result);
    }
}