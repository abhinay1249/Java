import java.util.*;

class Main {

    // Give me the Exact Value For the Row And Column Provided

    // ==================================== Brute Force Approach =====================================

        static int pascalValue(int row, int col){
            int num = 1, denom = 1, sub = 1, result = 1;

            for(int i = row-1 ; i > 0 ; i--){
                num *= i;
            }

            for(int i = col-1; i > 0 ; i--){
                denom *= i;
            }

            for(int i = row-col; i > 0 ; i--){
                sub*=i;
            }

            result = num/(denom*sub);
            return result;
        }

    // ==================================== Optimal Approach =========================================
        
        static int pascalValue_1(int row, int col){
            int result = 1;

            for(int i = 0 ; i < col ; i++){
                result = result * (row-i-1);
                result= result / (i+1);
            }
            return result;
        }

    // Print the Entire Row of the Given Nth Row Of Pascal's Triangle

    // ==================================== Brute Force Approach ========================================

        static int permute(int nthrow, int col){
            int value = 1;

            for(int row = 0; row < col ; row++){
                value*=(nthrow-row-1);
                value/=(row+1);
            }
            return value;
        }

        static void nthRowValues(int nthRow){
            
            List<Integer> values = new ArrayList<>();

            int value = 1;

            for(int row = 0 ; row < nthRow ; row++){
                values.add(permute(nthRow, row));
            }

            for(int i : values){
                System.out.print(i+" ");
            }
        }

    // ==================================== Optimal Approach ===========================================

        static void nthRowValues_1(int nthRow){

	        List<Integer> values = new ArrayList<>();
	        int value = 1;
	        values.add(value);

	        for(int row = 1 ; row < nthRow ; row++){
		        value *= (nthRow - 1);
		        value /= (row);
	            values.add(value);
            }

            for(int nthRowValues : values){
    	        System.out.print(nthRowValues+" ");
            }
        }

    // Print the entire Pascal Triangle.

        static List<Integer> nthRowsValues(int nthRow){
	
	        List<Integer> values = new ArrayList<>();
	        int value = 1;
            values.add(value);

	        for(int row = 1 ; row < nthRow ; row++){
	        	value *= (nthRow - 1);
	        	value /= (row);
	            values.add(value);
            }

            return values;
        }


        static void pascalTriangle(int size){
        
        	List<List<Integer>> pascalTriangle = new ArrayList<>();

        	for(int rows = 1 ; rows <= size; rows++){
        		List<Integer> row = nthRowsValues(rows);
        		pascalTriangle.add(row);
            }
            for(List<Integer> pascalTriangleRows : pascalTriangle){
            	System.out.print(pascalTriangleRows+" ");
            }
        }

    public static void main(String[] args) {
        int n = 6;
        int row = 6;
        int col = 3;
        // int result = pascalValue(row, col);
        // int result_1 = pascalValue_1(row, col);
        // System.out.println(result);
        // System.out.println(result_1);
        // nthRowValues(n);
        // nthRowValues_1(n);
        pascalTriangle(n);
    }
}
