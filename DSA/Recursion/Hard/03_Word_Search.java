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

        private static boolean recursiveWordSearch(int rowIdx, int colIdx, char[][]){


        }


        public static boolean wordSearch(char[][] board, String word){

            int rowLength = board.length;
            int colLength = board[0].length;

            for(int row = 0 ; row < rowLength ; row++){
                for(int col = 0 ; col < colLength ; col++){
                    if () {
                        return true;
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