import java.util.*;

class Main {

    // =========================== Brute Force Approach ==============================

        static int medianOf2dMatrix(int[][] matrix){

            int rowLength = matrix.length;
            int colLength = matrix[0].length;

            List<Integer> sortedArray = new ArrayList<>();  

            for(int row = 0 ; row < rowLength ; row++){         
                for(int col = 0 ; col < colLength ; col++){
                    sortedArray.add(matrix[row][col]);
                }
            }
            Collections.sort(sortedArray);                       // T.C = O(Rows * Cols) + O(Rows * Cols log (Rows * Cols)), S.C = O(1)

            int medianValue = sortedArray.get((rowLength * colLength)/2);

            return medianValue;
        }

    // =========================== Optimal Approach ==============================

        static int medianOf2dMatrix(int[][] matrix){
        
        }


    public static void main(String[] args) {
        int[][] matrix = {{1,5,7,9,11},{2,3,4,5,10},{9,10,12,14,16}};
        int result = medianOf2dMatrix(matrix);
        System.out.println(result);
    }
}