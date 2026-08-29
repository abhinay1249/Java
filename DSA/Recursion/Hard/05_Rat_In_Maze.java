// Problem Statement: Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1). 
// Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). 
// The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).
// The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, 
// whereas value 1 represents that rat can travel through the cell. 
// If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.

// Example 1:

// Input: n = 4, grid = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
// Output: ["DDRDRR" , "DRDDRR"]
// Explanation: The rat has two different path to reach (3, 3).
// The first path is (0, 0) => (1, 0) => (2, 0) => (2, 1) => (3, 1) => (3, 2) => (3, 3).
// The second path is (0,0) => (1,0) => (1,1) => (2,1) => (3,1) => (3,2) => (3,3).

// Example 2:

// Input: n = 2, grid = [[1, 0], [1, 0]]
// Output: []
// Explanation: There is no path that rat can choose to travel from (0,0) to (1,1).

import java.util.ArrayList;
import java.util.List;

class Main{

    // ===================================== Only Approach ===========================================

        private static List<String> recursiveRatInMaze(int row, int col, List<String> ans, int n, int[][] grid, StringBuilder sb, int[][] dup){

            // Down

            if(row+1 < n && dup[row+1][col]==1 && grid[row+1][col]==1){
                sb.append("D");
                dup[row][col] = 1;
                recursiveRatInMaze(row+1, col, ans, n, grid, sb, dup);
                dup[row][col] = 0;
            }

            // Left

            if(col-1 >= 0 && dup[row+1][col]==1 && grid[row+1][col]==1){
                sb.append("L");
                dup[row][col] = 1;
                recursiveRatInMaze(row, col-1, ans, n, grid, sb, dup);
                dup[row][col] = 0;
            }

            // Right

            if(col+1 <= n && dup[row+1][col]==1 && grid[row+1][col]==1){
                sb.append("R");
                dup[row][col] = 1;
                recursiveRatInMaze(row, col+1, ans, n, grid, sb, dup);
                dup[row][col] = 0;
            }

            // Up

            if(){
                sb.append("U");
                dup[row][col] = 1;
                recursiveRatInMaze(row-1, col, ans, n, grid, sb, dup);
                dup[row][col] = 0;
            }

            return ans;

        }



        public static void ratInMaze(int n, int[][] grid){

            List<String> ans = new ArrayList<>();

            int row = 0, col = 0;

            int[][] dup = grid.clone();

            StringBuilder sb = new StringBuilder();

            recursiveRatInMaze(row, col, ans, n, grid, sb, dup);

            System.out.println(ans);

        }

    public static void main(String[] args){
        
        int n = 4;
        int[][] grid = {{1,0,0,0}, {1,1,0,1}, {1,1,0,0}, {0,1,1,1}};

        if(grid[0][0] == 1){
            ratInMaze(n, grid);
        }
    }
}