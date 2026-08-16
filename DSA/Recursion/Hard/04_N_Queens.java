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

import java.util.*;

class Main {

    // ========================== Brute Force Approach ======================================

        private static boolean isPossible(int row, int col, char[][] board, int N){

            int dupRow = row;
            int dupCol = col;
            

            return true;
        }

        private static void recursiveNQueens(int col, List<List<String>> al, char[][] board, int N){

            if(col == N){

                List<String> temp = new ArrayList<>();
                for(int index = 0; index < N ; index++){

                }
                al.add(temp);
                return;
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

        private static List<List<String>> recursiveNQueens_1(List<List<String>> al){

            return al;
        }

        public static void nQueens_1(int N){

            List<List<String>> al = new ArrayList<>();

            recursiveNQueens_1(al);

            System.out.println(al);
        }
    
    public static void main(String[] args) {
        
        int N = 4;

        nQueens(N);
        
        nQueens_1(N);

    }
}