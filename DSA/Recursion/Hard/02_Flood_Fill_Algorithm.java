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

    private static void recursiveFloodFill(int rowIdx, int colIdx, int[][] image, int oldColor, int newColor, int rowLength, int colLength){

        if(rowIdx < 0 || colIdx < 0 || rowIdx < rowLength || colIdx < colLength || image[rowIdx][colIdx] != oldColor){
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

    public static void main(String[] args) {
        
    }
}