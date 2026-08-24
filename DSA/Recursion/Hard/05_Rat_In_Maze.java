
import java.util.ArrayList;
import java.util.List;

class Main{

    // ===================================== Only Approach ===========================================

        private static void recursionPaths(List<String> al, int[][] grid, int n){

        }

        public static List<String> ratInMaze(int n, int[][] grid){

            if(grid[0][0] == 0 || grid[n-1][n-1] == 0){
                return new ArrayList<>();
            }

            List<String> al = new ArrayList<>();

            recursionPaths(al, grid, n);

            return al;

        }

    public static void main(String[] args){
        
        int n = 4;
        int[][] grid = {{1,0,0,0}, {1,1,0,1}, {1,1,0,0}, {0,1,1,1}};

        ratInMaze(n, grid);

    }
}