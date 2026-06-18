// Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. 
// In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.


// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output : [[-1,-1,2],[-1,0,1]]
// Explanation : Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k


// Example 2:

// Input : nums=[-1,0,1,0]
// Output : [[-1,0,1],[-1,1,0]]
// Explanation : Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
    
    // ==================================== Brute Force Approach ===========================================

        public static List<List<Integer>> threeSum(int[] nums){
        
            int length =  nums.length;

            Set<List<Integer>> unqTriplets = new HashSet<>();

            for(int index_1 = 0 ; index_1 < length - 2 ; index_1++){
                for(int index_2 = index_1+1 ; index_2 < length - 1 ; index_2++){
                    for(int index_3 = index_2+1 ; index_3 < length ; index_3++){         // T.C = O(N^3 * Log(no of unique triplets))
	                    if(nums[index_1]+nums[index_2]+nums[index_3] == 0){              // S.C = 2 * O(no of triplets)
	    	                List<Integer> triplets = Arrays.asList(nums[index_1],nums[index_2],nums[index_3]);
	    	                Collections.sort(triplets);
	                        unqTriplets.add(triplets);
                        }
                    }
                }
            }
            return new ArrayList<>(unqTriplets);	
        }

    // ==================================== Better Approach ===========================================

        public static List<List<Integer>> threeSum_1(int[] nums){
	        int length = nums.length;
	        Set<List<Integer>> unqTriplets = new HashSet<>();
	        Set<Integer> elements = new HashSet<>();
    
	        for(int index_1 = 0 ; index_1 < length ; index_1++){                     // T.C = O(N^2 *Log(M))
		        for(int index_2 = index_1+1 ; index_2 < length ; index_2++){        //  S.C = O(N) + 2*O(no of triplets)
		    	    int k = -(nums[index_1]+nums[index_2]);          
		        	if(elements.contains(k)){
		    		    List<Integer> triplets = Arrays.asList(nums[index_1],nums[index_2],k);
		    		    Collections.sort(triplets);
		    		    unqTriplets.add(triplets);
		    		    elements.add(nums[index_2]);
		    	    }else{
		    	        elements.add(nums[index_2]);	
                    }
		        }
		        elements.clear();
	        }
	        return new ArrayList<>(unqTriplets);
        }

    // ==================================== Optimal Approach ===========================================

        public static List<List<Integer>> threeSum_2(int[] nums){
        
        	List<List<Integer>> triplets = new ArrayList<>();
	        int length = nums.length;	
	        Arrays.sort(nums);
    
            for(int index_1 = 0 ; index_1 < length ; index_1++){
                if(index_1>0 && nums[index_1] == nums[index_1-1]){
                    continue;
                }
                int index_2 = index_1+1;
	            int index_3 = length - 1;

        	    while(index_2 < index_3){
	    	        int sum = nums[index_1] +nums[index_2]+nums[index_3];           //T.C = O(N log N)+O(N*N), S.C = O(no of unique triplets)
    
	    	        if(sum < 0){
	    			    index_2++;
                    }else if(sum > 0){
	    			    index_3--;
                    }else{
                        List<Integer> elementList = Arrays.asList(nums[index_1],nums[index_2],nums[index_3]);
	    	            triplets.add(elementList);
                        index_2++;
                        index_3--;
	    	            while(index_2 < index_3 && nums[index_2] == nums[index_2-1]){
	    		            index_2++;
                        }
	    	            while(index_2 < index_3 && nums[index_3] == nums[index_3+1]){
	    		            index_3--;
                        }
                    }
        	    }
            }
            return triplets;
        }


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        for(List<Integer> ans :  res){
            System.out.println(ans);
        }
        
    }
}