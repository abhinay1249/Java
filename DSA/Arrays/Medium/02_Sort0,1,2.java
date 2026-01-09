// Problem Statement: Given an array nums consisting of only 0, 1, or 2. 
// Sort the array in non-decreasing order. The sorting must be done in-place, without making a copy of the original array.


import java.util.*;

class Main {

    // ======================= Brute Force Approach =======================================

        static int[] sortZeroOneTwo(int[] nums){
            Arrays.sort(nums);

            for(int i = 0 ; i <nums.length;i++){
                System.out.print(nums[i]+" ");
            }
            return nums;
        }

    // ======================= Better Approach  ============================================

    static int[] sortZeroOneTwo_1(int[] nums){
        int countOfZero = 0;
        int countOfOne = 0;
        int countOfTwo = 0;
        
        for(int i : nums){
            if(i==0) countOfZero++;
            else if(i==1) countOfOne++;
            else countOfTwo++;
        }
        
        for(int i = 0 ; i < countOfZero ; i++){
            nums[i] = 0;
        }
        for(int i = countOfZero ; i < countOfZero+countOfOne ; i++){
            nums[i] = 1;
        }
        for(int i = countOfZero+countOfOne ; i < nums.length ; i++){
            nums[i] = 2;
        }
        for(int i = 0 ; i <nums.length;i++){
            System.out.print(nums[i]+" ");
        }
       return nums; 
    }

    // ======================= Optimal Approach [DUTCH NATIONAL FLAG ALGORITHM] =======================================
    
    static void swap(int num1, int num2, int[] nums){
	    int temp = nums[num1];
	    nums[num1] = nums[num2];
	    nums[num2] = temp;
    }

    static int[] sortZeroOneTwo_2(int[] nums){
	
	    int low = 0;
	    int high = nums.length - 1;
	    int mid = 0;
    
	    while(mid<=high){
	    	if(nums[mid]==0){
	    		swap(low,mid,nums);
	    		low++;
	    		mid++;
	    	}else if(nums[mid]==1){
	    		mid++;
	    	}else{
	    		swap(mid,high,nums);
	    		high--;
	    	}
	    }
        for(int i = 0 ; i <nums.length;i++){
            System.out.print(nums[i]+" ");
        }
	    return nums;
    }   
    
    public static void main(String[] args) {
        int[] nums = {2,1,2,1,2,0,0,0,1};
        sortZeroOneTwo(nums);
        System.out.println();
        sortZeroOneTwo_1(nums);
        System.out.println();
        sortZeroOneTwo_2(nums);
    }
}