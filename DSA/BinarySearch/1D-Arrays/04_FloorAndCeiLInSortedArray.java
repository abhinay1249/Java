// Problem Statement: ou're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1]. \
// The floor of x is the largest element in the array which is smaller than or equal to x. 
// The ceiling of x is the smallest element in the array greater than or equal to x

// Example 1:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
// Result: 4 7
// Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

// Example 2:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 8
// Result: 8 8
// Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.


class Main {
    
    // ================================= Floor Approach ================================================

        public static int floor(int[] nums, int target){

            int length = nums.length;
            int low = 0, high = length - 1;
            int ans = length;

            while(low <= high){                                             // T.C = O(log N) S.C = O(1)
                int mid = low + ((high-low)/2);

                if(nums[mid] <= target){
                    ans = nums[mid];
                    low = mid+1;
                }else{
                    high = mid - 1;
                }
            }
            return ans;
        }

    // =================================== Ceil Approach =======================================

        public static int ceil(int[] nums, int target){

            int length = nums.length;
            int low = 0, high = length - 1;
            int ans = length;

            while(low <= high){                                             // T.C = O(log N) S.C = O(1)
                int mid = low + ((high-low)/2);

                if(nums[mid] >= target){
                    ans = nums[mid];
                    high = mid - 1;
                }else{
                    low = mid+1;
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,7,9,10,13,15};
        int target = 14;
        int result = floor(nums,target);
        int result1 = ceil(nums,target);
        System.out.println(result);
        System.out.println(result1);
    }
}