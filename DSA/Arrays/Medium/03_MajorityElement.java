//Problem Statement: Given an integer array nums of size n, return the majority element of the array.
// The majority element of an array is an element that appears more than n/2 times in the array. 
// The array is guaranteed to have a majority element.

// Example 1:

// Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]  
// Output: 7  
// Explanation: The number 7 appears 5 times in the 9-sized array, making it the most frequent element.

// Example 2:

// Input: nums = [1, 1, 1, 2, 1, 2]  
// Output: 1  
// Explanation: The number 1 appears 4 times in the 6-sized array, making it the most frequent element.


import java.util.*;

class Main {

	// ======================= Brute Force Approach =======================================
	
    static int majorityElement(int[] nums){
	    
	    int element = -1;
	    int lengthOfArray = nums.length;
	    int maxCount = 0;

	    for(int i = 0 ; i < nums.length;i++){
	        int count = 0;												// T.C = O(N^2) S.C = O(1)
		    for(int j = 0 ; j < nums.length ; j++){
			    if(nums[i]==nums[j]){
				    count++;
			    }
		    }
		  if(count > (lengthOfArray/2)){
		    element = nums[i];
		    break;
		  }
	    }
	    return element;
    }
    
	// ======================= Better Approach =======================================

    static int majorityElement_1(int[] nums){
	
	    Map<Integer,Integer> freqCount = new TreeMap<>();
	
	    for(int i = 0; i < nums.length; i++){												// T.C = O(M + N) S.C = O(M)
		    freqCount.put(nums[i],freqCount.getOrDefault(nums[i],0)+1);
	    }
	
	    int majorityElement = 0;
	
	    for(Map.Entry<Integer,Integer> value : freqCount.entrySet()){
		    if(value.getValue() > nums.length/2){
			    majorityElement = value.getKey();
		    }
    	}
	    return majorityElement;
    }

	// ======================= Optimal Approach [MOORE'S VOTING ALGORITHM] =======================================

	static int majorityElement_2(int[] nums){
	    int element = nums[0];
	    int count = 0;
		int counter = 0;

	    for(int i = 0 ; i < nums.length ; i++){
		    if(element == nums[i]){
			    count++;
		    }else if(element != nums[i]){
			    count--;
		    }															// T.C = O(N) + O(N) S.C = O(1)

		    if(count == 0){
				count=1;
			    element = nums[i];
		    }   
	    }
	
	    for(int i : nums){
		    if(element == i){
			    counter++;
		    }
		    if(counter>nums.length/2){
		        return i;
	        }
	    }

	    return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 1, 2};
        int[] nums_1 = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int[] nums_2 = {3,2,3};
        int result = majorityElement(nums);
        int result_1 = majorityElement_1(nums_1);
        int result_2 = majorityElement_2(nums_2);
        System.out.println(result);
        System.out.println(result_1);
        System.out.println(result_2);
    }
}