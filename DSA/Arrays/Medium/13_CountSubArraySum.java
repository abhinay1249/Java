// Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k. 
// A subarray is a contiguous non-empty sequence of elements within an array.


import java.util.*;

class Main {
    
    // ======================= Brute Force Approach =======================================

        static int countSubArrays(int[] nums, int target){
	        int count = 0;
	        int n = nums.length;

	        for(int i = 0 ; i < n ; i++){
	    	    for(int j = i ; j < n ; j++){
	    	        int sum = 0;
	    	        for(int k = i ; k <= j ; k++){
        			    sum+=nums[k];
	        		    if(sum == target){
	    	    		    count++;
	    		        }
	    	         }	
	            }
	        }
	        return count;
        }

    // ======================= Better Approach =======================================

        static int countSubArrays_1(int[] nums, int target){
	        int count = 0;
	        int n = nums.length;

	        for(int i = 0 ; i < n ; i++){
	            int sum = 0;
	    	    for(int j = i ; j < n ; j++){
	    		    sum+=nums[j];
	    		    if(sum== target){
	    			    count++;
	    		    }
	    	    }	
	        }
	        return count;
        }
    
    // ======================= Optimal Approach =======================================

        static int countSubArrays_2(int[] nums, int target){
	        int count = 0;
	        int n = nums.length;
	        int sum = 0;
            Map<Integer,Integer> prefixCount = new TreeMap<>();

            prefixCount.put(0,1);

            for(int i = 0 ; i < n ; i++){
                sum+=nums[i];
                if(prefixCount.containsKey(sum - target)){
                    count+= prefixCount.get(sum - target);
                }
                prefixCount.put(sum,prefixCount.getOrDefault(sum,0)+1);
            }
	        return count;
        }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int result = countSubArrays_2(nums,6);
        System.out.println(result);
    }
}