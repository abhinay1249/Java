// Problem Statement: Given a 0-indexed n x m matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the array [i, j]. 
// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbours to the left, right, top, and bottom.
// Assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

// Note: As there can be many peak values, 1 is given as output if the returned index is a peak number, otherwise 0.


import java.util.*;

class Main {

    // =========================== Brute Force Approach ==============================

        static int[] searchElement(int[][] matrix, int target){

            for(int row = 0 ; row < matrix.length; row++){
                for(int col = 0 ; col < matrix[0].length ; col++){
                    if(matrix[row][col] == target){
                        return new int[]{row,col};
                    }
                }                                                       // T.C = O(Rows * Cols) + O(Rows * Cols), S.C = O(1)
            }
            return new int[]{-1,-1};
        }

        static int[] peakElement2(int[][] matrix){

            int largestElement = Arrays.stream(matrix).flatMapToInt(Arrays::stream).max().getAsInt();
            int[] indices = searchElement(matrix,largestElement);

            return indices;
        }
    
    // =========================== Optimal Approach ==============================

        static int largestElementIndex(int[][] matrix, int rowLength, int col){

            int maxValue = -1;
            int index = -1;

            for(int row = 0 ; row < rowLength ; row++){
                if(matrix[row][col] > maxValue){
                    maxValue = matrix[row][col];
                    index = row;
                }
            }
            return index;
        }

        static int[] peakElement2_1(int[][] matrix){
            int rowLength = matrix.length;
            int colLength = matrix[0].length;

            int low = 0, high = colLength - 1;

            while(low <= high){
                int mid = low + ((high-low)/2);

                int row = largestElementIndex(matrix,rowLength,mid);        // T.C = O(Rows Log(Cols)) , S.C = O(1)

                int left = (mid-1)>=0 ? matrix[row][mid-1] : -1;
                int right = (mid+1)<colLength ? matrix[row][mid+1] : -1;

                if(left < matrix[row][mid] && matrix[row][mid] > right){
                    return new int[]{row,mid};
                }else if(matrix[row][mid] < right){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return new int[]{-1,-1};
        }

    public static void main(String[] args) {
        int[][] matrix = {{4,2,5,1,4,5},{2,9,3,2,3,2},{1,7,6,0,1,3},{3,6,2,3,7,2}};
        int[] result = peakElement2_1(matrix);
        for(int indices : result){
            System.out.print(indices+" ");   
        }
    }
}