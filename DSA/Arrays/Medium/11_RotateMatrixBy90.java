// Problem Statement: Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise. 
// The rotation must be done in place, meaning the input 2D matrix must be modified directly.


class Main {
    
    // ======================= Brute Force Approach =======================================

        static int[][] rotateMatrix(int[][] nums){
        
	        int n = nums.length;
	        int[][] transpose = new int[n][n];

	        for(int i = 0 ; i < n ; i++){
	    	    for(int j = 0 ; j < n ; j++){
	    		    transpose[j][n-1-i] = nums[i][j];
	    	    }
	        }
	        return transpose;
        }

    // ======================= Optimal Approach =======================================

        static void reverse(int left, int right, int row, int[][]rotated){
        
	        while(left<right){
	    	    int temp = rotated[row][left];
	    	    rotated[row][left] = rotated[row][right];
	    	    rotated[row][right] = temp;
	    	    left++;
	    	    right--;
        	}
        }

        static void swap(int left, int right, int[][] nums){
            int temp = nums[left][right];                                   // T.C = O(N/2 * N/2) + O(N * N/2), S.C = O(1)
            nums[left][right] = nums[right][left];
            nums[right][left] = temp;
        }

        static int[][] rotateMatrix_1(int[][] nums){
        
	        int n = nums.length;

	        for(int i = 0 ; i < n-2 ; i++){
	    	    for(int j = i+1 ; j < n; j++){
	    		    swap(i,j,nums);
	    	    }
	        }
    
	        for(int i = 0 ; i < n ; i++){
	            reverse(0,nums[0].length-1,i,nums);
	        }
	        return nums;
        }

    // ======================= FOLLOW UP  FOR (N * M) MATRIX =======================================

        static int[][] rotateMatrix_2(int[][] nums){
        
	        int n = nums.length;
	        int m = nums[0].length;
	        int[][] transpose = new int[m][n];

	        for(int i = 0 ; i < n ; i++){
	    	    for(int j = 0 ; j < m ; j++){
	    		    transpose[j][i] = nums[i][j];
	    	    }
	        }
	       	for(int i = 0 ; i < m ; i++){
	    		reverse(0,transpose[i].length-1,i,transpose);
	    	}
	        return transpose;
        }
        
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] res = rotateMatrix_2(matrix);
        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0 ; j < res[0].length ; j++){
                System.out.print(res[i][j]+" ");
            }
        }
        
    }
}