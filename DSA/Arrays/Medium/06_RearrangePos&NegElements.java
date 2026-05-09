// Problem Statement: There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. 
// Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.

// Example:- 1

// Input: arr[] = {1,2,-4,-5}, N = 4
// Output: 1 -4 2 -5
// Explanation: 
// Positive elements = 1,2
// Negative elements = -4,-5
// To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.


// Example 2:

// Input: arr[] = {1,2,-3,-1,-2,3}, N = 6
// Output: 1 -3 2 -1 3 -2
// Explanation: 
// Positive elements = 1,2,3
// Negative elements = -3,-1,-2

// To maintain relative ordering, 1 must occur before 2, and 2 must occur before 3.
// Also, -3 should come before -1, and -1 should come before -2.
            

import java.util.*;

class Main {
    
    // ======================= Brute Force Approach =======================================

        static int[] rearrangeElements(int[] nums){

	        int idx = 0, idx1 = 0;

	        int[] pos = new int[nums.length/2];
	        int[] neg = new int[nums.length/2];


	        for(int i = 0 ;  i < nums.length ; i++){            // T.C = O(N) + O(N/2), S.C = O(N/2)+O(N/2)
            
	    	    if(nums[i]<0){
	    		    neg[idx] = nums[i];
	    		    idx++;
	    	    }else if(nums[i]>0){
	    		    pos[idx1] = nums[i];
	    		    idx1++;
	    	    }
	        }

	        for(int i = 0 ; i < nums.length/2 ; i++){
            
	    	    nums[i*2] = pos[i];
	    	    nums[i*2+1] = neg[i];
	        }

	        return nums;
        }

    // ======================= Optimal Approach =======================================

        static int[] rearrangeElements_1(int[] nums){

            int[] arrangedArray = new int[nums.length];

            int posIdx = 0, negIdx = 1;

            for(int i = 0 ; i < nums.length ; i++){                          // T.C = O(N), S.C = O(1)

                if(nums[i]<0){
                    arrangedArray[negIdx]=nums[i];
                    negIdx+=2;
                }else{
                    arrangedArray[posIdx]=nums[i];
                    posIdx+=2;
                }
            }
            return arrangedArray;
        }

    // ======================= FOLLOW UP Question =======================================
        // If the length is not equal for the number of positive and negative elements  

        static int[] rearrangeElements_2(int[] nums){

            List<Integer> pos = new ArrayList<>();
            List<Integer> neg = new ArrayList<>();

            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i]<0){
                    neg.add(nums[i]);
                }else{
                    pos.add(nums[i]);
                }
            }

            if(pos.size()>neg.size()){
                for(int i = 0 ; i < neg.size() ; i++){                 // T.C = O(N) + O(min(pos,neg)) + O(left overs)
                    nums[i*2] = pos.get(i);                            //       O(N) + [ O(0) + (O(N){left overs})  + {0(N/2)+O(0)}]
                    nums[i*2+1] = neg.get(i);                          //       O(N) + O(N) = O(2N)
                }
                int idx = neg.size()*2;

                for(int i = neg.size() ; i < pos.size() ; i++){
                    nums[idx] = pos.get(i);
                    idx++;
                }
            }else{
                for(int i = 0 ; i < pos.size() ; i++){
                    nums[i*2] = pos.get(i);
                    nums[i*2+1] = neg.get(i);
                }

                int idx1 = pos.size()*2;

                for(int i = pos.size() ; i < neg.size() ; i++){
                    nums[idx1] = neg.get(i);
                    idx1++;
                }
            }
            return nums;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,-4,-5,-6};
        int[] nums_1 = {1,2,3,-4,-5,-6,1,2};
        int[] res = rearrangeElements(nums);
        int[] res_1 = rearrangeElements_1(nums);
        int[] res_2 = rearrangeElements_2(nums_1);
        for(int i = 0 ; i < res.length ; i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
        for(int i = 0 ; i < res_1.length ; i++){
            System.out.print(res_1[i]+" ");
        }
        System.out.println();
        for(int i = 0 ; i < res_2.length ; i++){
            System.out.print(res_2[i]+" ");
        }
    }
}