// Problem Statement: Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise. 
// The rotation must be done in place, meaning the input 2D matrix must be modified directly.


// Examples

// Input :matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
// Output : matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
// Explanation : First, we transpose the matrix: rows become columns. 
// Then, we reverse each row to simulate 90° clockwise rotation. 
// So element at (0,0) goes to (0,2), (0,1) goes to (1,2), and so on, achieving the rotated layout.

// Input : matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]
// Output : matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]
// Explanation : First, the matrix is transposed: rows become columns. 
// Then, each row is reversed. 
// This moves the last column to the first row, the second last column to the second row, and so on. 
// The original position of each element is rotated 90° clockwise into its new location.



class Main {
    
    // ======================= Brute Force Approach =======================================

        static int[][] rotateMatrix(int[][] nums){
        
	        int n = nums.length;
	        int[][] transpose = new int[n][n];

	        for(int i = 0 ; i < n ; i++){
	    	    for(int j = 0 ; j < n ; j++){						// T.C = O(N * M), S.C = O(N * M)
	    		    transpose[j][n-1-i] = nums[i][j];
	    	    }
	        }
	        return transpose;
        }

    // ======================= Optimal Approach =======================================

        private static void reverse(int left, int right, int row, int[][]rotated){
        
	        while(left<right){
	    	    int temp = rotated[row][left];
	    	    rotated[row][left] = rotated[row][right];
	    	    rotated[row][right] = temp;
	    	    left++;
	    	    right--;
        	}
        }

        private static void swap(int left, int right, int[][] nums){
            int temp = nums[left][right];                                   // T.C = O(N/2 * N/2) + O(N * N/2), S.C = O(1)
            nums[left][right] = nums[right][left];
            nums[right][left] = temp;
        }

        public static int[][] rotateMatrix_1(int[][] nums){
        
	        int n = nums.length;

	        for(int i = 0 ; i < n-1 ; i++){
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