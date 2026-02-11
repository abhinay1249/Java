
class Main {

    // ======================= Brute Force Approach =======================================

        static int rotatedSortedArray(int[] nums, int target){

            int length = nums.length;
            int ans = -1;

            for(int index = 0 ; index < length ; index++){
                if(nums[index] == target){
                    ans = index;
                }
            }
            return ans;
        }

        static int rotatedSortedArray(int[] nums, int target){

            int length = nums.length;
            int ans = -1;
            int low = 0, high = length - 1;

            while(low <= high){

                int mid = low + ((high - low)/2);

                if(nums[mid]==target){
                    ans = mid;
                    break;
                }

                if(nums[low] <= nums[mid]){
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
        int result = rotatedSortedArray(nums,target);
        System.out.println(result);
    }
}