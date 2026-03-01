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

        static int binarySearch(int[] mat, int target){
            int length = mat.length;

            int low = 0, high = length -1;

            while(low <= high){
                int mid = low+((high-low)/2);

                if(mat[mid]==target){
                    return mid;
                }else if(mat[mid]<target){                              // T.C = O(Rows * Log(Cols)) , S.C = O(1)
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return -1;
        }

        static int[] searchIn2DMatrix2_1(int[][] matrix, int target){

            int cols = matrix[0].length;

            for(int rows = 0 ; rows < matrix.length ; rows++){

                int elementIndex = binarySearch(matrix[rows],target);            // T.C = O(Rows * Log(Cols)) , S.C = O(1)
                
                if(elementIndex!=-1){
                    return new int[]{rows,elementIndex};
                }
            }
            return new int[]{-1,-1};
        }
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int target = 8;
        int[] result = searchIn2DMatrix2_1(matrix,target);
        for(int index : result)
        System.out.print(index+" ");
    }
}