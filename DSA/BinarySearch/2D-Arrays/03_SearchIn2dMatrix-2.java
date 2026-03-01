class Main {

    // =========================== Brute Force Approach ==============================

        static int[] searchIn2DMatrix2(int[][] matrix, int target){


            for(int rows = 0 ; rows < matrix.length ; rows++){
                for(int cols = 0 ; cols < matrix[rows].length ; cols++){
                    if(matrix[rows][cols]==target){
                        return new int[]{rows,cols};                                // T.C = O(M*N) , S.C = O(1)
                        
                    }
                }
            }
            return new int[]{-1,-1};
        }

    // =========================== Better Approach ==============================
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int target = 8;
        int[] result = searchIn2DMatrix2(matrix,target);
        for(int index : result)
        System.out.print(index+" ");
    }
}