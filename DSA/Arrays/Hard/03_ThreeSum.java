// Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. 
// In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.


import java.util.*;

class Main {
    
    // ==================================== Brute Force Approach ===========================================

        static List<List<Integer>> threeSum(int[] nums){
        
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

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        for(List<Integer> ans :  res){
            System.out.println(ans);
        }
        
    }
}