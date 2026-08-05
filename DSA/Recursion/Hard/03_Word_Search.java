// Problem Statement: Given an m x n grid of characters board and a string word, return true if the word exists in the grid. 
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
// The same letter cell may not be used more than once.

// Example 1:

// Input : [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]] word = "ABCCED"
// Output: true
// Explanation: We can easily find the given word in the matrix.

// Example 2:

// Input : [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]] word = "ABCB"
// Output: false
// Explanation: There is no such word in the given matrix.

class Main{

    // ============================= Recursive Approach =========================================

        private static boolean recursiveWordSearch(int rowIdx, int colIdx, char[][] board, int rowLength, int colLength, String word, int strIdx){

            if(strIdx == word.length()){
                return true;
            }

            if(rowIdx < 0 || colIdx < 0 || rowIdx == rowLength || colIdx == colLength || board[rowIdx][colIdx] != word.charAt(strIdx)){
                return false;
            } 

            if(word.charAt(strIdx) == board[rowIdx][colIdx]){
                strIdx+=1;
            }

            char ch = board[rowIdx][colIdx];

            board[rowIdx][colIdx] = '#';

            boolean operation_1 = recursiveWordSearch(rowIdx+1, colIdx, board, rowLength, colLength, word, strIdx);
            boolean operation_2 = recursiveWordSearch(rowIdx-1, colIdx, board, rowLength, colLength, word, strIdx);
            boolean operation_3 = recursiveWordSearch(rowIdx, colIdx+1, board, rowLength, colLength, word, strIdx);
            boolean operation_4 = recursiveWordSearch(rowIdx, colIdx-1, board, rowLength, colLength, word, strIdx);

            board[rowIdx][colIdx] = ch;

            return operation_1 || operation_2 || operation_3 || operation_4;

        }

        public static boolean wordSearch(char[][] board, String word){

            int rowLength = board.length;
            int colLength = board[0].length;

            for(int row = 0 ; row < rowLength ; row++){
                for(int col = 0 ; col < colLength ; col++){
                    if(board[row][col] == word.charAt(0)){
                        if(recursiveWordSearch(row, col, board, rowLength, colLength, word, 0)){
                            return true;
                        }
                    }
                }
            }

            return false;

        }
    
    public static void main(String[] args) {
        
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        String word = "ABCCED";

        boolean result = wordSearch(board, word);

        System.out.println(result);

    }
}