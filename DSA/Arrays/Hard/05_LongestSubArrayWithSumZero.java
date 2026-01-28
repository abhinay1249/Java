
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

    public static void main(String[] args) {
        int[] nums = {1,2,-3,0,0,0,0,4,-4};
        int result = longestSubArrayOfSumZero(nums);
        System.out.println(result);
    }
}