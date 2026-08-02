// Problem Statement: You are given an image represented by an m x n grid of integers image, where image[i][j] represents
// the pixel value of the image. You are also given three integers sr, sc, and color. 
// Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill:

// ** Begin with the starting pixel and change its color to color.
// ** Perform the same process for each pixel that is directly adjacent 
//      (pixels that share a side with the original pixel, either horizontally or vertically) and 
//      shares the same color as the starting pixel.
// ** Keep repeating this process by checking neighboring pixels of the updated pixels 
//       and modifying their color if it matches the original color of the starting pixel.
// ** The process stops when there are no more adjacent pixels of the original color to update.

// Return the modified image after performing the flood fill.


class Main{

    // =========================== Recursive Approach - 1 ====================================

        private static void recursiveFloodFill(int rowIdx, int colIdx, int[][] image, int oldColor, int newColor, int rowLength, int colLength){

            if(rowIdx < 0 || colIdx < 0 || rowIdx == rowLength || colIdx == colLength || image[rowIdx][colIdx] != oldColor){
                return;
            }

            image[rowIdx][colIdx] = newColor;

            recursiveFloodFill(rowIdx+1, colIdx, image, oldColor, newColor, rowLength, colLength);
            recursiveFloodFill(rowIdx-1, colIdx, image, oldColor, newColor, rowLength, colLength);
            recursiveFloodFill(rowIdx, colIdx+1, image, oldColor, newColor, rowLength, colLength);
            recursiveFloodFill(rowIdx, colIdx-1, image, oldColor, newColor, rowLength, colLength);

        }

        public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){

            int oldColor = image[sr][sc];

            int rowLength = image.length;
            int colLength = image[0].length;

            recursiveFloodFill(sr, sc, image, oldColor, newColor, rowLength, colLength);

            return image;
        }

    // ================================== Recursive Approach - 2 ======================================

        private static void recursiveFloodFill_1(int rowIdx, int colIdx, int[][] image, int oldColor, int newColor, int[] rowOperations, int[] colOperations){

            image[rowIdx][colIdx] = newColor;

            int rowLength = image.length;
            int colLength = image[0].length;

            for(int counter = 0 ; counter < 4; counter++){
                int nRow = rowIdx + rowOperations[counter]; 
                int nCol = colIdx + colOperations[counter];
                
                if(nRow >= 0 && nRow < rowLength && nCol >= 0 && nCol < colLength && image[nRow][nCol] == oldColor && image[nRow][nCol] != newColor){
                    recursiveFloodFill_1(nRow, nCol, image, oldColor, newColor, rowOperations, colOperations);
                }
            }
        
        }

        public static int[][] floodFill_1(int[][] image, int sr, int sc, int newColor){
            
            int oldColor = image[sr][sc];
            int[] rowOperations = {0,1,0,-1};
            int[] colOperations = {1,0,-1,0};                               // T.C = O(4(N * M)), S.C = O(N * M) + O(N * M)

            recursiveFloodFill_1(sr, sc, image, oldColor, newColor, rowOperations, colOperations);

            return image;

        }

    public static void main(String[] args) {

        int[][] image = {{1,0,1},{0,1,0},{1,1,1}};

        int[][] image_1 = image.clone();

        int sr = 2;
        int sc = 0;

        int newColor = 4;

        floodFill_1(image_1, sr, sc, newColor);

        for(int index_1 = 0; index_1 < image_1.length ; index_1++){
            for(int index_2 = 0 ; index_2 < image[0].length ; index_2++){
                System.out.println(image[index_1][index_2]);
            }
        }

    }
}