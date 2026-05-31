// Problem Statement: You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. 
// All the rows are sorted in ascending order. Your task is to find the index of the row with the maximum number of ones. 
// Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least single 1, return -1

// Example 1:
// Input Format: n = 3, m = 3, 
// mat[] = 
// 1 1 1
// 0 0 1
// 0 0 0
// Result: 0
// Explanation: The row with the maximum number of ones is 0 (0 - indexed).

// Example 2:
// Input Format: n = 2, m = 2 , 
// mat[] = 
// 0 0
// 0 0
// Result: -1
// Explanation: The matrix does not contain any 1. So, -1 is the answer.

class Main {

    // =========================== Brute Force Approach ==============================
    
        public static int rowWithMaximumOne(int[][]mat,int rowsLength,int colsLength){

            int rowCount = -1;
            int row = -1;

            for(int rows = 0 ; rows < rowsLength; rows++){
                int count = 0;
                for(int cols = 0 ; cols < colsLength ; cols++){
                    if(mat[rows][cols]==1){
                        count++;
                    }
                }
                if(rowCount < count){                               // T.C = O(Rows X Cols) S.C = O(1)
                    rowCount = count;
                    row = rows;
                }
            }
            return row;
        }

    // =========================== Optimal Approach ==============================

        public static int rowWithMaximumOne_1(int[][]mat,int rowsLength,int colsLength){
        
            int rowCount = -1;
            int row = -1;

            for(int rows = 0 ; rows < rowsLength; rows++){
                int count = 0;
                int low = 0, high = colsLength-1;

                while(low <= high){
                    int mid = low + ((high-low)/2);            

                    if(mat[rows][mid]==1){
                        high = mid - 1;
                    }else{
                        low = mid + 1;                          // T.C = O(Rows log (Cols)) S.C = O(1)
                    }
                }
                int countOfOne = colsLength - low;

                if(rowCount < countOfOne){
                    rowCount = countOfOne;
                    row = rows;
                }
            }
            if(rowCount == 0){
                return -1;
            }
            return row;
        }

    public static void main(String[] args) {
        int[][] mat = {{0,0,1,1,1},{0,0,0,0,0},{0,1,1,1,1},{0,0,0,0,0},{0,1,1,1,1}};
        int rows = 5;
        int cols = 5;
        int result = rowWithMaximumOne(mat,rows,cols);
        System.out.println(result);
    }
}