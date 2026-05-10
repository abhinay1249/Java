// Problem Statement: Given an integer array nums of size n. 
// Return all elements which appear more than n/3 times in the array. 
// The output can be returned in any order.

// Example 1:

// Input : nums = [1, 2, 1, 1, 3, 2]  
// Output: [1]  
// Explanation: Here, n / 3 = 6 / 3 = 2.  
// Therefore, the elements appearing 3 or more times are: [1].

// Example 2:

// Input : nums = [1, 2, 1, 1, 3, 2, 2]  
// Output : [1, 2]  
// Explanation: Here, n / 3 = 7 / 3 = 2.  
// Therefore, the elements appearing 3 or more times are: [1, 2].

import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================

        static List<Integer> majorityElement(int[] nums){
        
	        int length = nums.length;
	        List<Integer> result = new ArrayList<>();
    
	        for(int idx_1 = 0 ; idx_1 < length ; idx_1++){
        		int count = 0;  
	    	    for(int idx_2 = 0 ; idx_2 < length ; idx_2++){                  //T.C = O(N^2), S.C = O(1)
	    		    if(nums[idx_1] == nums[idx_2]){
	    			    count++;
                }
            }
                if(count > length/3 && !result.contains(nums[idx_1])){
	                result.add(nums[idx_1]);
                }
            }
            return result;
        }

    // ==================================== Better Approach ===========================================

        static List<Integer> majorityElement_1(int[] nums){
	        Map<Integer, Integer> freqCount = new HashMap<>();
	        List<Integer> result = new ArrayList<>();
	        int min = nums.length/3+1;

	        for(int index = 0 ; index < nums.length ; index++){
	            freqCount.put(nums[index] , freqCount.getOrDefault(nums[index], 0)+1);
    
	            if(freqCount.get(nums[index]) == min){
	                result.add(nums[index]);                                                //T.C = O(N), S.C = O(N)
	            }
	            if (result.size() == 2) break;
            }

            // for(Map.Entry<Integer,Integer> element : freqCount.entrySet()){
            //         if(element.getValue() > num.length/3){
        	   //         result.add(element.getKey());
            //         }
            // }
            return result;
        }

    // ==================================== Optimal Approach <MOORE'S VOTING ALGO MODIFIED> ===========================================

        static List<Integer> majorityElement_2(int[] nums){

	        int length = nums.length;
        	List<Integer> elements = new ArrayList<>();
	        int count1 = 0, count2 = 0, element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

	        for(int index = 0 ; index < length ; index++){
	    	    if(count1 == 0 && nums[index]!=element2){
	    		    count1 = 1;
	    		    element1 = nums[index];
                }else if(count2 == 0 && nums[index]!=element1){
	    		    count2 = 1;
	    		    element2 = nums[index];
                }else if(element1 == nums[index]){                                  //T.C = O(N)+ O(N), S.C = O(1)
                	count1++;
                }else if(element2 == nums[index]){
                	count2++;
                }else{
                    count1--;
                    count2--;	
                }
            }

            int counter1 = 0 , counter2 = 0;

            for(int index = 0 ; index < length ; index++){
            	if(element1 == nums[index]){
            		counter1++;
                }
            	if(element2 == nums[index]){
            		counter2++;
                }
            }
            int  min = length/3+1;
            if(counter1 >= min){
            	elements.add(element1);
            }
            if(counter2 >= min){
            	elements.add(element2);
            }
            return elements;
        }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 3, 1, 4, 5, 6};
        int[] nums_1 = {0,0,0};
        List<Integer> result = majorityElement(nums);
        List<Integer> result_1 = majorityElement_1(nums);
        List<Integer> result_2 = majorityElement_2(nums_1);
        for(int i : result){
            System.out.println(i);
    
        }
    }
}

