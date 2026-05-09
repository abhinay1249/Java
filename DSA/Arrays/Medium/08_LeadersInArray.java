// Problem Statement: Given an array of integers, find all the leaders in the array. 
// An element is a leader if it is greater than all the elements to its right side. 
// The rightmost element is always a leader.

// Example 1:
// Input: arr = [4, 7, 1, 0]  
// Output: 7 1 0  
// Explanation: The rightmost element (0) is always a leader.  
// 7 and 1 are greater than the elements to their right, making them leaders as well.

// Example 2:
// Input : arr = [10, 22, 12, 3, 0, 6]  
// Output: 22 12 6  
// Explanation: 6 is a leader because there are no elements after it.  
// 12 is greater than all the elements to its right (3, 0, 6), and 22 is greater than 12, 3, 0, 6, making them leaders as well.


import java.util.*;

class Main{
    
    // ======================= Brute Force Approach =======================================

        public static List<Integer> leaders(int[] nums){
        
	       int n = nums.length;
	       int idx = 0;
    
	       List<Integer> ans = new ArrayList<>();
    
	       if(n == 0) return ans;
    
	       for(int i = 0 ; i < n-1 ; i++){                          // T.C = O(N ^2), S.C = O(1)
	            boolean flag = true;
	       	    for(int j = i+1 ; j < n ; j++){
                
	       		    if(!(nums[i]>nums[j])){
	       			    flag = false;
	       			    break;
	       	    	}
	           	}
	       	    if(flag == true){
                    ans.add(nums[i]);
	       	    }
	        }
	        ans.add(nums[n-1]);
        	return ans;
        }

    // ======================= Optimal Approach =======================================

        public static List<Integer> leaders_1(int[] nums){
            List<Integer> ans = new ArrayList<>();
            int maxNum = Integer.MIN_VALUE;
            int n = nums.length;

            for(int i = n - 1 ; i >= 0 ; i--){                      // T.C = O(2N), S.C = O(1)
                if(nums[i]>maxNum){
                    ans.add(nums[i]);
                    maxNum = Math.max(maxNum,nums[i]);
                }
            }
            Collections.reverse(ans);

            return ans;
        }
        
    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};
        List<Integer> res = leaders(nums);
        List<Integer> res_1 = leaders_1(nums);
        for(int i : res_1){
            System.out.print(i+" ");
        }
    }
}