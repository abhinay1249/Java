// Problem Statement: Given an array nums of size n and an integer k, 
// find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.


import java.util.*;

class Main {
    
	// ======================= Brute Force Approach =======================================

    static int longestSubArray(int[] nums, int value){

	    int maxSubArrayLength = 0;
	    
	    for(int i = 0; i < nums.length ; i++){
	    	for(int j = i ; j < nums.length ; j++){
	    		int sumOfElements = 0;
	    		
	    		for(int k = i ; k <= j; k++){							// T.C = O(N^3) , S.C = O(1)
	    			sumOfElements += nums[k];
	    		}
	    		if(sumOfElements == value){
	    			maxSubArrayLength = Math.max(maxSubArrayLength, j-i+1);
	    		}
	    	}
	    }
	    if(maxSubArrayLength == 0){
	    	return 0;
	    }
	    return maxSubArrayLength;
    }

	// ======================= Better Brute Force Approach ============================

    static int longestSubArray_1(int[] nums, int value){

	    int maxSubArrayLength = 0;
	    
	    for(int i = 0; i < nums.length ; i++){
			int sumOfElements = 0;	
	    	for(int j = i ; j < nums.length ; j++){								// T.C = O(N^2) , S.C = O(1)
	    		sumOfElements += nums[j];
	    		if(sumOfElements == value){
	    			maxSubArrayLength = Math.max(maxSubArrayLength, j-i+1);
	    		}
	    	}
	    }
	    if(maxSubArrayLength == 0){
	    	return 0;
	    }
	    return maxSubArrayLength;
    }

	// ======================= Better Approach 	USING PREFIX SUM =======================================

	static int longestSubArray_2(int[] nums, int k){
	
	    int prefixSum = 0;
	    int maxSubArrayLength = 0;

	    Map<Integer, Integer> indexing = new HashMap<>();

	    for(int i = 0 ; i < nums.length ; i++){
		
		    prefixSum+=nums[i];

		    if(prefixSum == k){
			    maxSubArrayLength = i+1;
		    }else if(indexing.containsKey(prefixSum-k)){
			    maxSubArrayLength = Math.max(maxSubArrayLength, i - indexing.get(prefixSum-k));
		    }
			
		    indexing.putIfAbsent(prefixSum, i);
	    }
		if(maxSubArrayLength == 0){
	    	return 0;
	    }
	    return maxSubArrayLength;
    }

	// ======================== Optimal Approach =======================================

	static int longestSubArray_3(int[] nums, int k){

		int maxLength = 0;
		int sum = nums[0];
		int i = 0, j = 0;

		while(j<nums.length){

			while(i <= j && sum>k){
				sum-=nums[i];
				i++;
			}

			if(sum==k){
				maxLength = Math.max(maxLength, j-i+1);				// ---> T.C = O(2N)
			}

			j++;
			if(j<nums.length){
				sum+=nums[j];
			}
		}
		if(maxLength == 0){
	    	return 0;
	    }
		return maxLength;
	}
    
    public static void main(String[] args) {
        int[] nums = {10,5,8,3,7,1,9};
        int k = 18;
        int result = longestSubArray(nums, k);
        int result_1 = longestSubArray_1(nums, k);
        int result_2 = longestSubArray_2(nums, k);
        int result_3 = longestSubArray_3(nums, k);
        System.out.println(result);
        System.out.println(result_1);
        System.out.println(result_2);
        System.out.println(result_3);
    }
}