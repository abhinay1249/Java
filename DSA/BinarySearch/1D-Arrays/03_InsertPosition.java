// Problem Statement: You are given a sorted array arr of distinct values and a target value x. You need to search for the index of the target value in the array.


class Main {
    
    // =============================== Optimal Approach =================================================

        static int insertPosition(int[] nums, int target){

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
        int result = insertPosition(nums,target);
        System.out.println(result);
    }
}