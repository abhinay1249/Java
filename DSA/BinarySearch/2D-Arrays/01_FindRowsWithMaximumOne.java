class Main {

    // =========================== Brute Force Approach ==============================
    
        static int rowWithMaximumOne(int[][]mat,int rowsLength,int colsLength){

            int rowCount = -1;
            int row = -1;

            for(int rows = 0 ; rows < rowsLength; rows++){
                int count = 0;
                for(int cols = 0 ; cols < colsLength ; cols++){
                    if(mat[rows][cols]==1){
                        count++;
                    }
                }
                if(rowCount < count){                               // T.C = O(N^2) S.C = O(1)
                    rowCount = count;
                    row = rows;
                }
            }
            if(rowCount == 0){
                return -1;
            }
            return row;
        }

    public static void main(String[] args) {
        int[][] mat = {{0,0,1,1,1},{0,0,0,0,0},{0,1,1,1,1},{0,0,0,0,0},{0,1,1,1,1}};
        int rows = 5;
        int cols = 5;
        int result = rowWithMaximumOne(mat,rows,cols);
        System.out.println(result);
    }
}