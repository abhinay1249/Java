// Problem Statement: Given a row-wise sorted matrix of size M*N, where M is no. of rows and N is no. of columns, find the median in the given matrix.
// Note: M*N is odd.

// Example 1:

// Input: matrix = [ [1, 3, 5], [2, 6, 9], [3, 6, 9] ]
// Output: 5
// Explanation: The sorted form of the matrix is [1,2,3,3,5,6,6,9,9]. So the median is 5.

// Example 2:

// Input: matrix = [ [1, 2, 3], [4, 5, 6], [7, 8, 9] ]
// Output: 5
// Explanation: The sorted form of the matrix is [1,2,3,4,5,6,7,8,9]. So the median is 5.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    // =========================== Brute Force Approach ==========================

        public static int medianOfRowSortedWise(int[][] matrix){

            int rowLength = matrix.length;
            int colLength = matrix[0].length;

            List<Integer> sortedArray = new ArrayList<>();  

            for(int row = 0 ; row < rowLength ; row++){         
                for(int col = 0 ; col < colLength ; col++){
                    sortedArray.add(matrix[row][col]);
                }
            }
            Collections.sort(sortedArray);                // T.C = O(Rows * Cols) + O(Rows * Cols log (Rows * Cols)), S.C = O(Rows + Cols)

            int medianValue = sortedArray.get((rowLength * colLength)/2);

            return medianValue;
        }

    // =========================== Optimal Approach ==============================

        private static int upperBound(int[] rows, int target){

            int length = rows.length;
            int ans = length;
            int low = 0;
            int high = length - 1;

            while(low <= high){
                int mid = low + ((high-low)/2);

                if(rows[mid]>target){
                    ans = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return ans;
        }

        private static int smallerElementsRequired(int[][] matrix,int target){

            int count = 0;
            int rowLength = matrix.length;

            for(int index = 0 ; index < rowLength ; index++){
                count += upperBound(matrix[index],target);
            }
            return count;
        }

        public static int medianOfRowSortedWise_1(int[][]matrix){
            int low = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;

            int rowLength = matrix.length;                     // T.C =O(log(10^9) * (RowLength * log(RowLength))), S.C = O(1)
            int colLength = matrix[0].length;

            for(int index = 0 ; index < rowLength ; index++){
                low = Math.min(low,matrix[index][0]);
                high = Math.max(high,matrix[index][colLength-1]);
            }

            int required = (rowLength * colLength)/2;

            while(low <= high){
                int mid = low + ((high-low)/2);

                int countOfElements = smallerElementsRequired(matrix,mid);

                if(countOfElements <= required){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return low;
        }

    public static void main(String[] args) {

        int[][] matrix = {{1,5,7,9,11},{2,3,4,5,10},{9,10,12,14,16}};

        int result = medianOfRowSortedWise_1(matrix);
        
        System.out.println(result);

    }
}