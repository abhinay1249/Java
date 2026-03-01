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

    public static void main(String[] args) {
        int[][] matrix = {{4,2,5,1,4,5},{2,9,3,2,3,2},{1,7,6,0,1,3},{3,6,2,3,7,2}};
        int[] result = peakElement2_1(matrix);
        for(int indices : result){
            System.out.print(indices+" ");   
        }
    }
}