// Problem Statement: You are given a sorted array arr of distinct values and a target value x. 
// You need to search for the index of the target value in the array.

// Example 1:
// Input Format: arr[] = {1,2,4,7}, x = 6
// Result: 3
// Explanation: 6 is not present in the array. So, if we will insert 6 in the 3rd index(0-based indexing), the array will still be sorted. {1,2,4,6,7}.

// Example 2:
// Input Format: arr[] = {1,2,4,7}, x = 2
// Result: 1
// Explanation: 2 is present in the array and so we will return its index i.e. 1.


class Main {

    // =============================== Brute Force Approach =================================================

        public static int insertPosition(int[] nums, int target){

            int length = nums.length;
            int low = 0, high = length - 1;
            int ans = length;

            for(int i = 0; i < length; i++){                                    // T.C = O(N) S.C = O(1)
                if(nums[i] >= target){
                    ans = i;
                    break;
                }
            }
            return ans;
        }
    
    // =============================== Optimal Approach =================================================

        public static int insertPosition_1(int[] nums, int target){

            int length = nums.length;
            int low = 0, high = length - 1;
            int ans = length;

            while(low <= high){                                             // T.C = O(log N) S.C = O(1)
                int mid = low + ((high-low)/2);

                if(nums[mid] >= target){
                    ans = mid;
                    high = mid - 1;
                }else{
                    low = mid+1;
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,7,9,10,13,15};
        int target = 10;
        int result = insertPosition_1(nums,target);
        System.out.println(result);
    }
}