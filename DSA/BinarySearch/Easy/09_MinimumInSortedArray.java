// Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values), the array is rotated at any index which is unknown.
// Find the minimum element in the array.


class Main {
    
    static int minimumInSortedArray(int[] nums){
        
        int length = nums.length;
        int minValue = Integer.MAX_VALUE;                       // T.C = O(N), S.C = O(1)
        
        for(int index = 0 ; index < length ; index++){
            
            minValue = Math.min(nums[index],minValue);
        }
        return minValue;
    }
    
    static int minimumInSortedArray_1(int[] nums){
        
        int length = nums.length;
        int minValue = Integer.MAX_VALUE;
        int low = 0, high = length - 1;
        
        while(low <= high){
            
            int mid = low + ((high - low)/2);                       // T.C = O(Log N), S.C = O(1)
            
            // Optional-->[For more optimized time complexity]
            
            if(nums[low] <= nums[high]){
                minValue = Math.min(nums[low],minValue);
                break;
            }
            
            if(nums[low] <= nums[mid]){
                minValue = Math.min(nums[low],minValue);
                low = mid + 1;
            }else{
                minValue = Math.min(nums[mid],minValue);
                high = mid - 1;
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        int result = minimumInSortedArray_1(nums);
        System.out.println(result);
    }
}