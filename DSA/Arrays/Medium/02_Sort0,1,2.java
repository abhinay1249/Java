// Problem Statement: Given an array nums consisting of only 0, 1, or 2. 
// Sort the array in non-decreasing order. The sorting must be done in-place, without making a copy of the original array.

// Examples 

// Input: nums = [1, 0, 2, 1, 0]
// Output: [0, 0, 1, 1, 2]
// Explanation: The nums array in sorted order has 2 zeroes, 2 ones and 1 two

// Input: nums = [0, 0, 1, 1, 1]
// Output: [0, 0, 1, 1, 1]
// Explanation: The nums array in sorted order has 2 zeroes, 3 ones and zero twos.


import java.util.Arrays;

class Main {

    // ======================= Brute Force Approach =======================================

        static int[] sortZeroOneTwo(int[] nums){
            Arrays.sort(nums);

            for(int i = 0 ; i <nums.length;i++){            // T.C = O(N LOG N), S.C = O(1)
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
                else if(i==1) countOfOne++;                         // T.C = O(4N), S.C = O(1)
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
	        		swap(low,mid,nums);                                 // T.C = O(N), S.C = O(1)
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