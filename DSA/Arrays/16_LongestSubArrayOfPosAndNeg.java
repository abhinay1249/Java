import java.util.*;

class Main {
    
	// ======================= Brute Force Approach =======================================

    static int longestSubArray(int[] nums, int value){

	    int maxSubArrayLength = 0;
	    
	    for(int i = 0; i < nums.length ; i++){
	    	for(int j = i ; j < nums.length ; j++){
	    		int sumOfElements = 0;
	    		
	    		for(int k = i ; k <= j; k++){
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

	// ======================= Better Approach ============================

    static int longestSubArray_1(int[] nums, int value){

	    int maxSubArrayLength = 0;
	    
	    for(int i = 0; i < nums.length ; i++){
			int sumOfElements = 0;
	    	for(int j = i ; j < nums.length ; j++){
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

    static int longestSubArray_2(int[] nums, int k){

	    int prefixSum = 0;
	    int maxSubArrayLength= 0;
	    Map<Integer, Integer> prefixSumMap = new TreeMap<>();
    
	    for(int i = 0; i < nums.length ; i++){
	    	prefixSum+=nums[i];
    
	    	if(prefixSum == k){
	    		maxSubArrayLength = Math.max(maxSubArrayLength, i+1);	
	    	}

	    	else if(prefixSumMap.containsKey(prefixSum - k)){
	    		maxSubArrayLength = Math.max(maxSubArrayLength, i - prefixSumMap.get(prefixSum-k));
	    	}
            if(!prefixSumMap.containsKey(prefixSum)){
	    	    prefixSumMap.putIfAbsent(prefixSum,i);
	        }
	    }

        if(maxSubArrayLength == 0){
	    	return 0;
	    }
        return maxSubArrayLength;    
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,0,0,3,0,-1,1,1,2,-1,4,-1};
        int k = 1;
        int result = longestSubArray(nums, k);
        int result_1 = longestSubArray_1(nums, k);
        int result_2 = longestSubArray_2(nums, k);
        System.out.println(result);
        System.out.println(result_1);
        System.out.println(result_2);
    }
}