// Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the lower and upper bound of x.

// What is lower bound?
// The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

// The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.


// What is Upper Bound?
// The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key i.e. x.

// The upper bound is the smallest index, ind, where arr[ind] > x.

class Main {
    
    // ============================ Lower Bound [Smallest Index] ==================================

        static int lowerBound(int[] nums, int target){

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

    // =============================== Upper Bound [Smallest Index] ===================================

        static int upperBound(int[] nums, int target){
        
            int length = nums.length;
            int low = 0, high = length - 1;
            int ans = length;

            while(low <= high){
                int mid = low + ((high-low)/2);                                  // T.C = O(log N) S.C = O(1)

                if(nums[mid] > target){
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
        int result = lowerBound(nums,target);
        System.out.println(result);
    }
}