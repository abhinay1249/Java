// Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. 
// The elements of each row and each column are sorted in non-decreasing order. 
// But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists). 
// You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

// Example 1:

// Matrix=
// 1   4   7   11
// 2   5   8   12
// 3   6   9   16
// 10 13  14  17

// Target: 9
// Output: Found at (2,2) (0-indexed)


// Example 2:

// Matrix=
// 5   10  15
// 6   12  18
// 8   16  20

// Target: 7
// Output: Not Found


class Main {

    // =========================== Brute Force Approach ==============================

        public static int[] searchIn2DMatrix2(int[][] matrix, int target){


            for(int rows = 0 ; rows < matrix.length ; rows++){
                for(int cols = 0 ; cols < matrix[rows].length ; cols++){
                    if(matrix[rows][cols]==target){
                        return new int[]{rows,cols};                                // T.C = O(M*N) , S.C = O(1)
                        
                    }
                }
            }
            return new int[]{-1,-1};
        }

    // =========================== Better Approach ==============================

        public static int binarySearch(int[] mat, int target){
            int length = mat.length;

            int low = 0, high = length -1;

            while(low <= high){
                int mid = low+((high-low)/2);

                if(mat[mid]==target){
                    return mid;
                }else if(mat[mid]<target){                              // T.C = O(Rows * Log(Cols)) , S.C = O(1)
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return -1;
        }

        public static int[] searchIn2DMatrix2_1(int[][] matrix, int target){

            int cols = matrix[0].length;

            for(int rows = 0 ; rows < matrix.length ; rows++){

                int elementIndex = binarySearch(matrix[rows],target);           
                if(elementIndex!=-1){
                    return new int[]{rows,elementIndex};
                }
            }
            return new int[]{-1,-1};
        }

    // =========================== Optimal Approach ==============================

        public static int[] searchIn2DMatrix2_2(int[][] matrix, int target){
        
            int noOfRows = matrix.length;
            int noOfCols = matrix[0].length;
            int row = 0 ;
            int col = noOfCols-1;

            while(row < noOfRows && col >=0){

                if(matrix[row][col]==target){
                    return new int[]{row,col};                  // T.C = O(Rows + Cols) , S.C = O(1)
                }else if(matrix[row][col]<target){
                    row++;
                }else{
                    col--;
                }
            }
            return new int[]{-1,-1};
        }
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int target = 8;
        int[] result = searchIn2DMatrix2_1(matrix,target);
        for(int index : result)
        System.out.print(index+" ");
    }
}