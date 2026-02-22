import java.util.*;

class Main {
    
    static int subArraySum(int[] nums,int largestSum ,int subArrays){
        
        int length = nums.length;
        int sum = 0;
        int countOfSubArrays = 1;
        
        for(int index = 0 ; index < length ; index++){
            if(sum+nums[index]<=largestSum){
                sum+=nums[index];
            }else{
                countOfSubArrays++;
                sum = nums[index];
            }
        }
        return countOfSubArrays;
    }
    
    static int minimumLargestSum(int[] nums, int noOfSubArrays){
        
        int length = nums.length;
        if(length < noOfSubArrays) return -1;
        
        int max = Arrays.stream(nums).max().getAsInt();
        int sumOfElements = Arrays.stream(nums).sum(); 
        
        if(length == noOfSubArrays) return max;
        
        for(int largestSum = max ; largestSum <= sumOfElements ; largestSum++){
            int subArrays = subArraySum(nums,largestSum,noOfSubArrays);
            if(subArrays <= noOfSubArrays){
                return largestSum;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,1,1,1};
        int subArrays = 5;
        int result = minimumLargestSum(nums,subArrays);
        System.out.println(result);
    }
}