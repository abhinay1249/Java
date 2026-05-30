// Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. 
// The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row (if it exists). 
// You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

// Examples

// Input :mat = [ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12] ], target = 8
// Output :True.
// Explanation :The target = 8 exists in the 'mat' at index (1, 3).

// Input :mat = [ [1, 2, 4], [6, 7, 8], [9, 10, 34] ], target = 78
// Output :false.
// Explanation :The target = 78 does not exist in the 'mat'. Therefore in the output, we see 'false'.


class Main {

    // =========================== Brute Force Approach ========================

        public static boolean searchIn2DMatrix(int[][] matrix, int target){

            boolean elementFound = false;

            for(int rows = 0 ; rows < matrix.length ; rows++){
                for(int cols = 0 ; cols < matrix[rows].length ; cols++){
                    if(matrix[rows][cols]==target){
                        elementFound = true;                                // T.C = O(M*N) , S.C = O(1)
                        break;
                    }
                }
            }
            return elementFound;
        }

    // =========================== Better Approach ==============================

        private static boolean binarySearch(int[] mat, int target){
            int length = mat.length;

            int low = 0, high = length -1;

            while(low <= high){
                int mid = low+((high-low)/2);

                if(mat[mid]==target){
                    return true;
                }else if(mat[mid]<target){                              // T.C = O(Rows * Log(Cols)) , S.C = O(1)
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return false;
        }

        public static boolean searchIn2DMatrix_1(int[][] matrix, int target){

            boolean elementFound = false;
            int cols = matrix[0].length;

            for(int rows = 0 ; rows < matrix.length ; rows++){
                if(matrix[rows][0]<=target && target <= matrix[rows][cols-1]){
                    elementFound = binarySearch(matrix[rows],target);
                    break;
                }
            }
            return elementFound;
        }

    // =========================== Optimal Approach ==============================

        public static boolean searchIn2DMatrix_2(int[][] matrix, int target){
        
            boolean elementFound = false;
            int noOfRows = matrix.length;
            int noOfCols = matrix[0].length;
            int low = 0 ;
            int high = (noOfRows * noOfCols)-1;

            while(low <= high){
                int mid = low + ((high-low)/2);

                int row = mid / noOfCols;                   // T.C = O(Log(Rows * Cols)) , S.C = O(1)                                   
                int col = mid % noOfCols;                       

                if(matrix[row][col]==target){
                    elementFound = true;                
                    break;
                }else if(matrix[row][col]<target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return elementFound;
        }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int target = 8;
        boolean result = searchIn2DMatrix(matrix,target);
        System.out.println(result);
    }
}