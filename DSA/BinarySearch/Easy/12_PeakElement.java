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
    
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int result = peakElement(nums);
        System.out.println(result);
    }
}