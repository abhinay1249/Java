// Problem Statement: Given an integer array nums, sorted in ascending order (with distinct values) and a target value k.
// The array is rotated at some pivot point that is unknown. 
// Find the index at which k is present and if k is not present return -1.

// Examples

// Input:nums = [4, 5, 6, 7, 0, 1, 2], k = 0
// Output :4
// Explanation : Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

// Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3
// Output :-1
// Explanation :Here, the target is 3. Since 3 is not present in the given rotated sorted array. 
// Thus, we get the output as -1.

class Main {

    // ======================= Brute Force Approach =======================================

        static int rotatedSortedArray(int[] nums, int target){

            int length = nums.length;
            int ans = -1;

            for(int index = 0 ; index < length ; index++){
                if(nums[index] == target){                                      // T.C = O(N), S.C = O(1)
                    ans = index;
                }
            }
            return ans;
        }

    // ======================= Optimal Approach =======================================

        static int rotatedSortedArray_1(int[] nums, int target){

            int length = nums.length;
            int ans = -1;
            int low = 0, high = length - 1;

            while(low <= high){

                int mid = low + ((high - low)/2);

                if(nums[mid]==target){
                    ans = mid;
                    break;
                }

                if(nums[low] <= nums[mid]){                                     // T.C = O(LOG N), S.C = O(1)
                    if(nums[low] <= target && target <= nums[mid]){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }else{
                    if(nums[mid] <= target && target <= nums[high]){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
            }
            return ans;
        }

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = rotatedSortedArray_1(nums,target);
        System.out.println(result);
    }
}