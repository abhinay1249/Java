// Problem Statement: Given an integer array nums, sorted in ascending order (with distinct values) and a target value k.
// The array is rotated at some pivot point that is unknown. 
// Find the index at which k is present and if k is not present return -1.



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

    // ======================= Optimal Approach =======================================

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

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = rotatedSortedArray(nums,target);
        System.out.println(result);
    }
}