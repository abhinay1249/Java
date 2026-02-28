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
                if(rowCount < count){                               // T.C = O(Rows X Cols) S.C = O(1)
                    rowCount = count;
                    row = rows;
                }
            }
            if(rowCount == 0){
                return -1;
            }
            return row;
        }

    // =========================== Optimal Approach ==============================

        static int rowWithMaximumOne_1(int[][]mat,int rowsLength,int colsLength){
        
            int rowCount = -1;
            int row = -1;

            for(int rows = 0 ; rows < rowsLength; rows++){
                int count = 0;
                int low = 0, high = colsLength-1;

                while(low <= high){
                    int mid = low + ((high-low)/2);             // T.C = O(Rows log (Cols)) S.C = O(1)

                    if(mat[rows][mid]==1){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
                int countOfOne = colsLength - low;

                if(rowCount < countOfOne){
                    rowCount = countOfOne;
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