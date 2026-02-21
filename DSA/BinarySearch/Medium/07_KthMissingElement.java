class Main {
    
    static int kthMissingElement(int[] nums, int k){
        int missingElement = -1;
        int length = nums.length;
        
        if(nums[0]>k){
            missingElement = k;
            return missingElement;
        }
        for(int index = 0 ; index < length ; index++){
            if(nums[index]>k){
                missingElement = k;
                break;
            }
            k++;
        }
        return missingElement;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,10,15};
        int k = 9;
        int result = kthMissingElement(nums,k);
        System.out.println(result);
    }
}