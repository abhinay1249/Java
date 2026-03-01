class Main {

    // =========================== Brute Force Approach ==============================

        static boolean searchIn2DMatrix(int[][] matrix, int target){

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

    // =========================== Better Approach ==============================

        static boolean binarySearch(int[] mat, int target){
            int length = mat.length;

            int low = 0, high = length -1;

            while(low <= high){
                int mid = low+((high-low)/2);

                if(mat[mid]==target){
                    return true;
                }else if(mat[mid]<target){                              // T.C = O(Rows * Log(Cols)) , S.C = O(1)
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return false;
        }

        static boolean searchIn2DMatrix_1(int[][] matrix, int target){

            boolean elementFound = false;
            int cols = matrix[0].length;

            for(int rows = 0 ; rows < matrix.length ; rows++){
                    if(matrix[rows][0]<=target && target <= matrix[rows][cols-1]){
                        elementFound = binarySearch(matrix[rows],target);
                        break;
                    }
            }
            return elementFound;
        }

    // =========================== Optimal Approach ==============================

        static boolean searchIn2DMatrix_2(int[][] matrix, int target){
        
            boolean elementFound = false;
            int noOfRows = matrix.length;
            int noOfCols = matrix[0].length;
            int low = 0 ;
            int high = (noOfRows * noOfCols)-1;

            while(low <= high){
                int mid = low + ((high-low)/2);

                int row = mid / noOfCols;                   // T.C = O(Log(Rows * Cols)) , S.C = O(1)                                   
                int col = mid % noOfCols;                       

                if(matrix[row][col]==target){
                    elementFound = true;                
                    break;
                }else if(matrix[row][col]<target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
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