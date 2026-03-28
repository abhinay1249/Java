// Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
// If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).


// Examples

// Input: Arr[] = {1,3,2}
// Output: {2,1,3}
// Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. 
// So, the next permutation just after {1,3,2} is {2,1,3}.

// Input : Arr[] = {3,2,1}
// Output: {1,2,3}
// Explanation : As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. 
// So, we have to return the lowest permutation.


import java.util.*;

class Main {
        
    // ======================= Brute Force Approach =======================================

        static List<Integer> permute(int[] nums){
        
            List<List<Integer>> ans = new ArrayList<>();
        
            // Arrays.sort(nums);  --> Ony if the array is the first permutation this should be used.
        
            nextPermutation(nums,0,ans);
        
            List<Integer> current = new ArrayList<>();
        
            for(int i : nums) current.add(i);
        
            for(int i = 0 ; i < ans.size() ; i++){
                if(ans.get(i).equals(current)){                 // T.C = O(N! * N), S.C = O(N!)  
                    if(i == ans.size()-1){
                        return ans.get(0);
                    }
                    return ans.get(i+1);
                }
            }
            return current;
        }
    
        private static void swapNum(int left, int right, int[] nums){
        
	        int temp = nums[left];
	        nums[left] = nums[right];
	        nums[right] = temp;
        }

        private static void nextPermutation(int[] nums,int index,List<List<Integer>> ans){

            int n = nums.length;

            if(index == n){

                List<Integer> ds = new ArrayList<>();

                for(int i = 0 ; i < n ; i++){
                    ds.add(nums[i]);    
                }
                ans.add(new ArrayList<>(ds));
                return;
            }

            for(int i = index ; i < n ; i++){
                swapNum(i,index,nums);
                nextPermutation(nums,index+1,ans);
                swapNum(i,index,nums);
            }
        }

    // ======================= Optimal Approach =======================================

        private static void reverse(int start, int end, int[] nums){
        
	        while(start < end){
                swap(start, end, nums);
	    	    start++;
	    	    end--;
	        }
        }

        private static void swap(int left, int right, int[] nums){
        
	        int temp = nums[left];
	        nums[left] = nums[right];                                           // T.C = O(3N), S.C = O(1) 
	        nums[right] = temp;
        }

        static int[] nextPermutation(int[] nums){
        
	        int n = nums.length;
	        int index = -1;

	        for(int i = n-2 ; i >= 0 ; i--){
            
	    	    if(nums[i] < nums[i+1]){
	    		    index = i;
	    		    break;
	    	    }
	        }

	        if(index == -1){
	    	    reverse(0,n-1,nums);
	    	    return nums;
	        }

	        for(int i = n-1 ; i > index ; i--){
            
	    	    if(nums[i]>nums[index]){
                
	    		    swap(i, index, nums);
	    		    break;		
	    	    }
	        }
	        reverse(index+1,n-1,nums);
    
	        return nums;
        }


    public static void main(String[] args) {
        int[] nums = {2,1,5,4,3,0,0};
        int[] res = nextPermutation(nums);
        for(int i : res){
            System.out.print(i+" ");  
        }

    }
}