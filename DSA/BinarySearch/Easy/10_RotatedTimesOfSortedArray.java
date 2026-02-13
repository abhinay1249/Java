
class Main {
    
    static int rotatedTimes(int[] nums){
        
        int length = nums.length;
        int minValue = Integer.MAX_VALUE;
        
        for(int index = 0; index < length ; index++){
            minValue = Math.min(nums[index],minValue);
        }
        int rotatedTimes = 0;
        
        for(int index = 0 ; index < length ; index++){
            if(nums[index] == minValue){
                rotatedTimes = index;
            }
        }
        
        return rotatedTimes;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        int result = rotatedTimes(nums);
        System.out.println(result);
    }
}