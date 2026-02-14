// Problem Statement: Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and a target value k. 
// Now the array is rotated at some pivot point unknown to you. 
// Return True if k is present and otherwise, return False.


class Main {

    // ======================= Brute Force Approach =======================================

        static int rotatedSortedArray(int[] nums, int target){

            int length = nums.length;
            boolean result = false;

            for(int index = 0 ; index < length ; index++){
                if(nums[index] == target){                          // T.C = O(N), S.C = O(1)
                    result = true;
                    break;
                }
            }
            return result;
        }

    // ======================= Optimal Approach ============================================

        static int rotatedSortedArray_1(int[] nums, int target){

            int length = nums.length;
            boolean result = false;
            int low = 0, high = length - 1;

            while(low <= high){

                int mid = low + ((high-low)/2);

                if(nums[mid] == target){
                    result = true;
                    return result;                                              // T.C = O(LOG N), S.C = O(1)
                }

                if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                    low++;
                    high--;
                    continue;
                }

                if(nums[low]<=nums[mid]){
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
            return result;
        }

    public static void main(String[] args) {

        int[] nums = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target = 3;
        int result = rotatedSortedArray(nums,target);
        System.out.println(result);
    }
}