// Problem Statement: The n-queens is the problem of placing n queens on n × n chessboard such that no two queens can attack each other.
// Given an integer n, return all distinct solutions to the n -queens puzzle. 
// Each solution contains a distinct boards configuration of the queen's placement, where ‘Q’ and ‘.’ indicate queen and empty space respectively.

// Example 1 :

// Input : N = 4
// Output : [[".Q..","...Q","Q...","..Q."], ["..Q.","Q...","...Q",".Q.."]]
// Explanation : There exist two distinct solutions to the 4-queens puzzle as shown below

// Example 2 :

// Input : N = 1
// Output : [["Q"]]
// Explanation : There is only one way to place 1 queen on 1 x 1 chessboard.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    // ========================== Brute Force Approach ======================================

        private static boolean isPossible(int row, int col, char[][] board, int N){

            int dupRow = row;
            int dupCol = col;

            while(row >= 0 && col >= 0){
                if(board[row][col] == 'Q'){
                    return false;
                } 
                row--;
                col--;
            }

            row = dupRow;
            col = dupCol;

            while(col >= 0){
                if(board[row][col] == 'Q'){
                    return false;
                }
                col--;
            }

            row = dupRow;                                           // T.C = O(N^2 + N^2 * N! + S * N^2) + O(3N) , S.C = O(N^2) + O(N)
            col = dupCol;

            while(row < N && col >= 0){
                if(board[row][col] == 'Q'){
                    return false;
                }
                row++;
                col--;
            }

            return true;

        }

        private static void recursiveNQueens(int col, List<List<String>> al, char[][] board, int N){

            if(col == N){
                List<String> temp = new ArrayList<>();
                
                for(int index = 0; index < N ; index++){
                    temp.add(new String (board[index]));
                }
                
                al.add(temp);

                return;
            }

            for(int row = 0 ; row < N ; row++){
                
                if(isPossible(row, col, board , N)){
                    board[row][col] = 'Q';
                    recursiveNQueens(col+1, al, board, N);
                    board[row][col] = '.';
                }
                
            }
        }
    
        public static void nQueens(int N){

            List<List<String>> al = new ArrayList<>();

            char[][] board = new char[N][N];

            for(int index = 0 ; index < N ; index++){
                Arrays.fill(board[index],'.');
            }

            recursiveNQueens(0, al, board, N);

            System.out.println(al);

        }

    // ============================== Optimal Approach ========================================

        private static void recursiveNQueens_1(int col, List<List<String>> al, char[][] board, int N, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal){

            
            if(col == N){
                List<String> temp = new ArrayList<>();

                for(int index = 0 ; index < N  ; index++){
                    temp.add(new String(board[index]));                 // T.C = O(N^2 + N * N! + S* N^2) +  , S.C = O(N^2) + O(2N)
                }

                al.add(temp);

                return;
            }


            for(int row = 0 ; row < N ; row++){
                if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[(N - 1)+(col - row)] == 0){

                    board[row][col] = 'Q';

                    leftRow[row] = 1;
                    lowerDiagonal[row+col] =  1;
                    upperDiagonal[(N - 1)+(col - row)] = 1;
                    
                    recursiveNQueens_1(col+1, al, board, N, leftRow, upperDiagonal, lowerDiagonal);
                    
                    board[row][col]='.';
                    
                    leftRow[row] = 0;
                    lowerDiagonal[row+col] =  0;
                    upperDiagonal[(N - 1)+(col - row)] = 0;

                }
            }
        }

        public static void nQueens_1(int N){

            List<List<String>> al = new ArrayList<>();

            char[][] board = new char[N][N];

            for(int index = 0 ; index < N ; index++){
                Arrays.fill(board[index],'.');
            }

            int[] leftRow = new int[N];
            int[] upperDiagonal = new int[(2*N)-1];
            int[] lowerDiagonal = new int[(2*N)-1];


            recursiveNQueens_1(0, al, board, N, leftRow, upperDiagonal, lowerDiagonal);

            System.out.println(al);
        }
    
    public static void main(String[] args) {
        
        int N = 4;

        nQueens(N);
        
        nQueens_1(N);

    }
}