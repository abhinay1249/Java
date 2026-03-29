// Problem Statement: Given an array nums of n integers.
// Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

// Example 1:
// Input : nums = [100, 4, 200, 1, 3, 2]  
// Output : 4  
// Explanation: The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4. 
// This sequence can be formed regardless of the initial order of the elements in the array.

// Example 2:
// Input : nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]  
// Output : 9  
// Explanation : The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9.

import java.util.*;

class Main {

    // ======================= Brute Force Approach ====================================

        private static boolean linearSearch(int[] nums, int target){
        
	        for(int i = 0 ; i < nums.length ; i++){
	    	    if(nums[i] == target){
	    		    return true;
	    	    }
	        }
	        return false;
        }
        static int longestConsecutive(int[] nums){
        
        	int n = nums.length;
        	int maxConsecutive = Integer.MIN_VALUE;             // T.C = O(N^2), S.C = O(1)

        	for(int i = 0 ; i < n ; i++){
        		int x = nums[i];
        		int count = 1;

        		while(linearSearch(nums,x+1)==true){
        			x+=1;
        			count+=1;
        		}
        		maxConsecutive = Math.max(maxConsecutive, count);
        	}
        	return maxConsecutive;
        }

    // ======================= Better Approach =======================================

        static int longestConsecutive_1(int[] nums){
        
        	int n = nums.length;
        	int maxConsequence = Integer.MIN_VALUE;
            int count = 0;
            int lastSmaller = Integer.MIN_VALUE;
            Arrays.sort(nums);

            for(int i = 0 ; i < n ; i++){

                if(nums[i]-1 == lastSmaller){                       // T.C = O(N LOG N) + O(N), S.C = O(1)
                    count++;
                    lastSmaller = nums[i];
                }else if(nums[i]!=lastSmaller){
                    count=1;
                    lastSmaller = nums[i];
                }
                maxConsequence = Math.max(maxConsequence,count);
            }
        	return maxConsequence;
        }

    // ======================= Optimal Approach =======================================

        static int longestConsecutive_2(int[] nums){
        
            Set<Integer> hs = new HashSet<>();
            int maxConsequence = Integer.MIN_VALUE;
            for(int i = 0 ; i < nums.length ; i++){
                hs.add(nums[i]);
            }

            for(int i : hs){
                if(!hs.contains(i-1)){                              // T.C = O(2N), S.C = O(N)
                    int count = 0;
                    while(hs.contains(i++)){
                        count++;
                    }
                    maxConsequence = Math.max(maxConsequence, count);
                }
            }
        	return maxConsequence;
        }
    

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int res = longestConsecutive(nums);
        int res_1 = longestConsecutive_1(nums);
        int res_2 = longestConsecutive_2(nums);
        System.out.println(res_2);
    }
}