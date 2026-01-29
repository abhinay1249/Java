// Problem Statement: Given an array of integers A and an integer B. 
// Find the total number of subarrays having bitwise XOR of all elements equal to k.

class Main {

    // ==================================== Brute Force Approach ======================================

        static int subArraysOfXor(int[] nums, int target){

	        int length = nums.length;
	        int count = 0;
    
	        for(int idx_1 = 0; idx_1 < length ; idx_1++){
	    	    for(int idx_2 = idx_1; idx_2 < length ; idx_2++){
	    		    int xor = 0;
	    		    for(int values = idx_1 ; values <= idx_2 ; values++){
	    			    xor ^= nums[values];
	    			    if(xor == target){
	    				    count++;
                        }
                    }
                }
            }
            return count;
        }

    // ==================================== Better Approach ===========================================

        static int subArraysOfXor_1(int[] nums,int target){
            int length = nums.length;
            int count = 0;

            for(int idx_1 = 0 ; idx_1 < length ; idx_1++){
                int xor = 0;
                for(int idx_2 = idx_1 ; idx_2 < length ; idx_2++){
                    xor^=nums[idx_2];
                    if(xor == target){
                        count++;
                    }
                }

            }
            return count;
        }
    
    public static void main(String[] args) {
        int[] nums = {4,2,2,6,4};
        int target = 6;
        int res = subArraysOfXor_1(nums,target);
        System.out.println(res);
    }
}
