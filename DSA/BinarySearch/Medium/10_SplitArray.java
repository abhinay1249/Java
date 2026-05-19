// Problem Statement: Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. 
// Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. 
// Your task is to return the minimized largest sum of the split. A subarray is a contiguous part of the array.


import java.util.*;

class Main {
    
    // =========================== Brute Force Approach ============================== 

        public static int subArraySum(int[] nums,int largestSum ,int subArrays){

            int length = nums.length;
            int sum = 0;
            int countOfSubArrays = 1;

            for(int index = 0 ; index < length ; index++){
                if(sum+nums[index]<=largestSum){
                    sum+=nums[index];
                }else{                                           // T.C = O(sumOfElements - maxNumber) * O(N) + O(2N), S.C = O(1)
                    countOfSubArrays++;
                    sum = nums[index];
                }
            }
            return countOfSubArrays;
        }

        public static int minimumLargestSum(int[] nums, int noOfSubArrays){

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

    // =========================== Optimal Approach ============================== 

        public static int subArraySum_1(int[] nums,int largestSum ,int subArrays){

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

        public static int minimumLargestSum_1(int[] nums, int noOfSubArrays){

            int length = nums.length;
            if(length < noOfSubArrays) return -1;

            int low = Arrays.stream(nums).max().getAsInt();
            int high = Arrays.stream(nums).sum(); 

            if(length == noOfSubArrays) return low;

            while(low <= high){                                  // T.C = O(Log(sumOfElements - maxNumber)) * O(N) + O(2N) ,S.C = O(1) 
                int mid = low + ((high - low)/2);
                int subArrays = subArraySum(nums,mid,noOfSubArrays);
                if(subArrays <= noOfSubArrays){
                    high = mid - 1;
                }else{
                    low = mid +1;
                }
            }
            return low;
        }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,1,1,1};
        int subArrays = 5;
        int result = minimumLargestSum(nums,subArrays);
        System.out.println(result);
    }
}