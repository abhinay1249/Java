// Problem Statement: Given an integer array nums, 
// find the subarray with the largest sum and return the sum of the elements present in that subarray.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Follow-up Question:
// Can you print the subarray that has the maximum sum?


class Main {
    

    // ======================= Brute Force Approach =======================================

        static int maxSubArraySum(int[] nums){
        
	        int maxSum = Integer.MIN_VALUE;
    
	        for(int i = 0 ; i < nums.length ; i++){
	    	    for(int j = i ; j < nums.length ; j++){
	    		    int sum = 0;
    
	    		    for(int k = i ; k <= j ; k++){
	    			    sum+=nums[k];
	    		    }
	    		    maxSum = Math.max(sum, maxSum);
	    	    }
	        }
	        return maxSum;
        }

	// ======================= Better Approach =======================================

        static int maxSubArraySum_1(int[] nums){
        
	        int maxSum = Integer.MIN_VALUE;
    
	        for(int i = 0 ; i < nums.length ; i++){
	            int sum = 0;
	    	    for(int j = i ; j < nums.length ; j++){
	    			sum+=nums[j];
	    			maxSum = Math.max(sum, maxSum);
	    		}
            }   
            return maxSum;
        }

    // ======================= Optimal Approach [KADANE'S ALGORITHM] =======================

        static int maxSubArraySum_2(int[] nums){
	        int sum = 0;
    	    int maxSum = Integer.MIN_VALUE;

	        for(int i = 0 ; i < nums.length ; i++){

		        sum+=nums[i];

		        if(sum > maxSum){
		    	    maxSum = sum;
		        }

		        if(sum < 0){
		    	    sum = 0;
	        	}
	        }
	        return maxSum;
        }

    // ======================= FOLLOW UP Question to Print the SubArray =======================

        static void maxSubArraySum_3(int[] nums){
	        int sum = 0;
    	    int maxSum = Integer.MIN_VALUE;
            int start = 0, ansStart = -1, ansEnd = -1;

	        for(int i = 0 ; i < nums.length ; i++){
                
                if(sum == 0){
                    start = i;
                }

		        sum+=nums[i];

		        if(sum > maxSum){
		    	    maxSum = sum;
                    ansStart = start;
                    ansEnd = i;
		        }

		        if(sum < 0){
		    	    sum = 0;
	        	}
	        }
            System.out.print("[ ");
            for(int i = ansStart ; i <= ansEnd ; i++){
                System.out.print(nums[i]+" ");
            }
            System.out.print("]");
            System.out.println();
        }

    public static void main(String[] args) {

        int[] nums = {2, 3, 5, -2, 7, -4};
        int[] nums_1 = {-2,1};
        int result = maxSubArraySum(nums);
        int result_1 = maxSubArraySum_1(nums);
        int result_2 = maxSubArraySum_2(nums_1);
        maxSubArraySum_3(nums);
        System.out.println(result);
        System.out.println(result_1);
        System.out.println(result_2);
    }
}