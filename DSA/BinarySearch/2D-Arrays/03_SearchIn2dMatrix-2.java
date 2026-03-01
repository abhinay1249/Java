class Main {

    // =========================== Brute Force Approach ==============================

        static boolean searchIn2DMatrix2(int[][] matrix, int target){

            boolean elementFound = false;

            for(int rows = 0 ; rows < matrix.length ; rows++){
                for(int cols = 0 ; cols < matrix[rows].length ; cols++){
                    if(matrix[rows][cols]==target){
                        elementFound = true;                                // T.C = O(M*N) , S.C = O(1)
                        break;
                    }
                }
            }
            return elementFound;
        }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int target = 8;
        boolean result = searchIn2DMatrix(matrix,target);
        System.out.println(result);
    }
}