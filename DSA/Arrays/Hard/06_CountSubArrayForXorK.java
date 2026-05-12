// Problem Statement: Given an array of integers A and an integer B. 
// Find the total number of subarrays having bitwise XOR of all elements equal to k.

// Examples

// Input: A = [4, 2, 2, 6, 4] , k = 6
// Output: 4
// Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

// Input: A = [5, 6, 7, 8, 9], k = 5
// Output: 2
// Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]



class Main {

    // ==================================== Brute Force Approach ======================================

        public static int subArraysOfXor(int[] nums, int target){

	        int length = nums.length;
	        int count = 0;
    
	        for(int idx_1 = 0; idx_1 < length ; idx_1++){
	    	    for(int idx_2 = idx_1; idx_2 < length ; idx_2++){
	    		    int xor = 0;                                                          // T.C = O(N^3), S.C = O(1)
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

        public static int subArraysOfXor_1(int[] nums,int target){
            int length = nums.length;
            int count = 0;

            for(int idx_1 = 0 ; idx_1 < length ; idx_1++){
                int xor = 0;
                for(int idx_2 = idx_1 ; idx_2 < length ; idx_2++){
                    xor^=nums[idx_2];                                                   // T.C = O(N^2), S.C = O(1)
                    if(xor == target){
                        count++;
                    }
                }

            }
            return count;
        }

    // ==================================== Optimal Approach ===========================================

        public static int subArraysOfXor_2(int[] nums, int target){
            int length = nums.length;
            if(length == 0) return 0;

            int xor = 0;
            int count = 0;

            Map<Integer,Integer> freqCount = new HashMap<>();

            freqCount.put(0,1);                                                 // T.C = O(N * N Log N), S.C = O(N)

            for(int idx = 0 ; idx < length ; idx++){
                xor ^= nums[idx];

                int requiredElement = xor ^ target;

                if(freqCount.containsKey(requiredElement)){
                    count += freqCount.get(requiredElement);
                }
                freqCount.put(xor,freqCount.getOrDefault(xor,0)+1);
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
