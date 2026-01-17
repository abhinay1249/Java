// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix..


class Main {
    
    // ======================= Brute Force Approach =======================================

        static void markRow(int i,int[][] nums){
            int m = nums[0].length;
        	for(int j = 0 ; j < m ; j++){
        		if(nums[i][j]!=0){
        			nums[i][j] = -1;
        		}
        	}
        }

        static void markCol(int j,int[][] nums){
            int n = nums.length;
        	for(int i = 0 ; i < n ; i++){
        		if(nums[i][j]!=0){
        			nums[i][j] = -1;
        		}
        	}
        }

        static int[][] setMatrixZeros(int[][] nums){
        
        	int n = nums.length;
        	int m = nums[0].length;

        	for(int i = 0 ; i < n ; i++){
        		for(int j = 0 ; j < m ; j++){
                
        			if(nums[i][j] == 0){
                    
        				markRow(i,nums);
        				markCol(j,nums);
        			}
        		}
        	}

        	for(int i = 0 ; i < n ; i++){
        		for(int j = 0 ; j < m ; j++){
        			if(nums[i][j]==-1){
        				nums[i][j]=0;
        			}
        		}
        	}
        	return nums;
        }
    
    // ======================= Better Approach =======================================

        static int[][] setMatrixZeros_1(int[][] nums){

	        int n = nums.length;
	        int m = nums[0].length;

	        int[] mapRows = new int[n];
	        int[] mapCols = new int[m];

	        for(int i = 0 ; i < n ; i++){
	    	    for(int j = 0 ; j < m ; j++){
                
	    		    if(nums[i][j] == 0){
	    			    mapRows[i] = 1;
	    			    mapCols[j] = 1;
	    		    }
	    	    }
	        }
    

	        for(int i = 0 ; i < n ; i++){
	    	    for(int j = 0 ; j < m ; j++){
                
	    		    if(mapRows[i]==1 || mapCols[j]==1){
	    			    nums[i][j] = 0;
	    		    }
	    	    }
	        }
	        return nums;
        }

    // ======================= Optimal Approach =======================================  

        static int[][] setMatrixZeros_2(int[][] nums){
            int n = nums.length;
            int m = nums[0].length;
            int col0 = nums[0][0];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(nums[i][j] == 0){
                        nums[i][0] = 0;
                        if(j!=0){
                            nums[0][j] = 0;
                        }else{
                            col0=0;
                        }

                    }
                }
            }

            for(int i = 1 ; i < n ; i++){
                for(int j = 1 ; j < m ; j++){
                    if(nums[i][j]!=0){
                        if(nums[0][j]==0 || nums[i][0]==0){
                            nums[i][j] = 0;
                        }
                    }
                }
            }

            if(nums[0][0] == 0){
                for(int j = 0 ; j < m ; j++) nums[0][j] = 0;
            }

            if(col0 == 0){
                for(int i = 0 ; i < n ; i++){
                    nums[i][0] = 0;
                }
            }
            return nums;
        }
    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix_1={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix_2={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] res = setMatrixZeros(matrix);
        int[][] res_1 = setMatrixZeros_1(matrix_1);
        int[][] res_2 = setMatrixZeros_2(matrix_2);
        for(int i = 0 ; i < res_2.length ; i++){
            for(int j = 0 ; j < res_2[0].length ; j++){
                System.out.print(res_2[i][j]+" ");
            }
        }
    }
}