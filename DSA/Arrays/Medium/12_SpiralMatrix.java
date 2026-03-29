// Problem Statement: Given a Matrix, print the given matrix in spiral order.

//Examples

// Input: Matrix[][] = { { 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 } }
// Output: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
// Explanation: The output of matrix in spiral form.

// Input: Matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 },{ 7, 8, 9 } }
// Output: 1, 2, 3, 6, 9, 8, 7, 4, 5.
// Explanation: The output of matrix in spiral form.

import java.util.*;

class Main {

    // ======================= Only Approach =======================================

        static List<Integer> spiralMatrix(int[][] nums){
        
	        int n = nums.length;
	        int m = nums[0].length;
	        int left = 0, right = m - 1, top = 0, bottom = n - 1;
    
	        List<Integer> spiralMatrix = new ArrayList<>();


	        while(top <= bottom && left <= right){
	    		for(int i = left ; i <= right ; i++){
	    		    spiralMatrix.add(nums[top][i]);             // T.C = O(n *m), S.C = O(n * m)
	    		}
	    		top++;
	    		for(int i = top ; i <= bottom ; i++){
	    		    spiralMatrix.add(nums[i][right]);
	    		}
	    		right--;
	    		if(top <= bottom){
	    		    for(int i = right ; i >= left ; i--){
	    			    spiralMatrix.add(nums[bottom][i]);
	    		    }
	    		    bottom--;
	    		}	

	    		if(left <= right){
	    		    for(int i = bottom ; i >= top ; i--){
	    			    spiralMatrix.add(nums[i][left]);
	    		    }
	    		    left++;
	        	}
	        }

		    return spiralMatrix;	
        }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 } };
        List<Integer> result = spiralMatrix(matrix);
        for(int i : result){
            System.out.print(i+" ");   
        }
    }
}