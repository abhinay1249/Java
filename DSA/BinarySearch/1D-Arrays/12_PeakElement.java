// Problem Statement: Given an array of length N, peak element is defined as the element greater than both of its neighbors. 
// Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] < arr[i]. 
// Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.

// Examples

// Input: arr[] = {1,2,3,4,5,6,7,8,5,1}
// Output: 7
// Explanation: There is only 1 peak element, 8,  that is at index 7.

// Input: arr[] = {1,2,1,3,5,6,4} 
// Output: 1 
// Explanation : There are 2 peak numbers that are at indices 1 and 5. We can return any of them.


class Main {

    // ======================= Brute Force Approach ===========================

        public static int peakElement(int[] nums){

            int length= nums.length;

            if(length == 1) return -1;

            int peakElementIdx = -1;                                             // T.C = O(N), S.C = O(1)

            for(int index = 0 ; index < length ; index++){

                boolean prev = (index == 0) || (nums[index - 1] < nums[index]);
                boolean next = (index == length-1) || (nums[index + 1] < nums[index]);

                if(prev && next){
                    return index;
                }
            }
            return peakElementIdx;
        }
    
    // ======================= Optimal Force Approach ===========================

        public static int peakElement_1(int[] nums){

            int length= nums.length;

            if(length == 1) return 0;

            if(nums[0]> nums[1]) return 0;

            if(nums[length-2]<nums[length-1]) return length -1;                   // T.C = O(Log N), S.C = O(1)

            int peakElementIndex = -1;

            int low = 1, high = length - 2;

            while(low <= high){
                int mid = low + ((high - low)/2);

                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                    peakElementIndex = mid;
                }

                if(nums[mid-1]> nums[mid] && nums[mid]>nums[mid+1]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return peakElementIndex;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,10,13,7,6,5,4,2,1,0};
        int result = peakElement_1(nums);
        System.out.println(result);
    }
}