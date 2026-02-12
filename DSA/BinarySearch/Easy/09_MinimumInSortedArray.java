class Main {
    
    static int minimumInSortedArray(int[] nums){
        
        int length = nums.length;
        int minValue = Integer.MAX_VALUE;   
        
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
            
            int mid = low + ((high - low)/2);
            
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