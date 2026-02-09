// Problem Statement: Find out the Lower Bound and Upper Bound for the respective target provided.


class Main {
    
    // ------------------------------ Lower Bound [Smallest Index] --------------------------------------

    static int lowerBound(int[] nums, int target){
        
        int length = nums.length;
        int low = 0, high = length - 1;
        int ans = length;
        
        while(low <= high){                                             // T.C = O(log N)
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

    // -------------------------------- Upper Bound [Smallest Index] --------------------------------------

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,7,9,10,13,15};
        int target = 10;
        int result = lowerBound(nums,target);
        System.out.println(result);
    }
}