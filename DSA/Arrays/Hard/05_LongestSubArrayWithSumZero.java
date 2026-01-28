
class Main {
    
    // ==================================== Brute Force Approach ===========================================

        static int longestSubArrayOfSumZero(int[] nums){
	        int length = nums.length;
	        if(length == 0) return -1;
	        int maxLength = Integer.MIN_VALUE;

	        for(int idx_1= 0 ; idx_1 < length ; idx_1++){           // T.C = O(N^2), S.C = O(1)
	    	    int sum = 0;
	    	    for(int idx_2 = idx_1 ; idx_2 < length ; idx_2++){
	    		    sum += nums[idx_2];
	    		    if(sum == 0){
	    			    maxLength = Math.max(maxLength, idx_2-idx_1+1);
                    }
                }
            }
            if(maxLength == Integer.MIN_VALUE) return -1;
            return maxLength;
        }


    // ==================================== Optimal Approach ===========================================

        static int longestSubArrayOfSumZero_1(int[] nums){
	        int length = nums.length;
	        Map<Integer,Integer> prefixCount = new TreeMap<>();
	        int sum = 0;
	        int prefixSum = 0;
	        int target = 0;
	        int maxLength = -1;
    
            if(length == 0) return -1;
	        for(int index = 0 ; index < length ; index++){
	            prefixSum+=nums[index];                             // T.C = O(N * Log N), S.C = O(N)
	            sum = prefixSum - target;
	            if(sum == 0){
		            maxLength = Math.max(maxLength,index+1); 
                }else if(prefixCount.containsKey(sum)){
		            maxLength = Math.max(maxLength,index - prefixCount.get(sum)); 
                }
                if(!prefixCount.containsKey(prefixSum)){
	                prefixCount.put(prefixSum,index);
                }
            }
            return maxLength;
        }

    public static void main(String[] args) {
        int[] nums = {1,2,-3,0,0,0,0,4,-4};
        int result = longestSubArrayOfSumZero(nums);
        int result_1 = longestSubArrayOfSumZero_1(nums);
        System.out.println(result);
        System.out.println(result_1);
    }
}