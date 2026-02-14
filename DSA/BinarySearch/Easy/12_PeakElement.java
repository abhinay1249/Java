class Main {

    static int peakElement(int[] nums){
        
        int length= nums.length;
            
        if(length == 1) return 0;
        
        int peakElementIdx = 0;
        
        for(int index = 0 ; index < length ; index++){

            boolean prev = (index == 0) || (nums[index - 1] < nums[index]);
            boolean next = (index == length-1) || (nums[index + 1] < nums[index]);
            
            if(prev && next){
                return index;
            }
        }
        return peakElementIdx;
    }
    
    static int singlePeakElement(int[] nums){
        
        int length= nums.length;
            
        if(length == 1) return 0;
        
        if(nums[0]> nums[1]) return 0;
        
        if(nums[length-2]<nums[length-1]) return length -1;
        
        int peakElementIndex = 0;
        
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
        int result = singlePeakElement(nums);
        System.out.println(result);
    }
}