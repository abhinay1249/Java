// Problem Statement: Write a program to generate Pascal's triangle. 
// In Pascal’s triangle, each number is the sum of the two numbers directly 


// Examples

// Input: N = 5, r = 5, c = 3 
// Output: Element at position (r, c): 6
// N-th row of Pascal’s triangle: 1 4 6 4 1
// First n rows of Pascal’s triangle:
// 1 
// 1 1 
// 1 2 1 
// 1 3 3 1 
// 1 4 6 4 1  
// Explanation: Pascal triangle for first 5 rows is shown above.

// Input: N = 1, r = 1, c = 1
// Output: Element at position (r, c): 1
// N-th row of Pascal’s triangle: 1
// First n rows of Pascal’s triangle:
// 1  
// Explanation: N = 1 is the base case fof a pascal's triangle.


import java.util.*;

class Main {

    // GIVE ME THE EXACT VALUE FOR THE ROW AND COLUMN PROVIDED

    // ==================================== Brute Force Approach =====================================

        static int pascalValue(int row, int col){

            int num = 1, denom = 1, sub = 1, result = 1;

            for(int i = row-1 ; i > 0 ; i--){
                num *= i;
            }

            for(int i = col-1; i > 0 ; i--){                                //T.C = O(row!)+ O(col!) + O((row-col)!), S.C = O(1)
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
                result = result * (row-i);                                //T.C = O(N), S.C = O(1)
                result= result / (i+1);
            }
            return result;
        }

    // PRINT THE ENTIRE ROW OF THE GIVEN NTH ROW OF PASCAL’S TRIANGLE

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

            int value = 1;                                                  //T.C = O(N * R), S.C = O(1)
                                                                            
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

	        for(int row = 0 ; row < nthRow-1 ; row++){
		        value *= (nthRow - row - 1);
		        value /= (row+1);                                               //T.C = O(N), S.C = O(1)
	            values.add(value);
            }

            for(int nthRowValues : values){
    	        System.out.print(nthRowValues+" ");
            }
        }


    // PRINT THE ENTIRE PASCAL TRIANGLE

    // ==================================== Brute-Force Approach ===========================================

        static int permutation(int row, int col){
            int value = 1;
            for(int valueidx = 0 ; valueidx < col ; valueidx++){
                value *= row-valueidx;
                value /= valueidx+1;
            }
            return value;
        }

        static void pascalTriangle(int nthRows){
        
            List<List<Integer>> pascalTriangle = new ArrayList<>();
        
            for(int row = 0 ; row < nthRows ; row++){

                List<Integer> temp = new ArrayList<>();

                for(int col = 0 ; col <= row ; col++){                          //T.C = O(N^3), S.C = O(1)
                    temp.add(permutation(row, col));
                }
                pascalTriangle.add(temp);
            }
            for(List<Integer> res : pascalTriangle){
                System.out.println(res+" ");
            }    
        }

    // ==================================== Optimal Approach ===========================================


        static List<Integer> nthRowsValues(int nthRow){
	
	        List<Integer> values = new ArrayList<>();
	        int value = 1;
            values.add(value);

	        for(int row = 1 ; row < nthRow; row++){
	        	value *= (nthRow - row);                                    //T.C = O(N^2), S.C = O(1)
	        	value /= (row);
	            values.add(value);
            }
            return values;
        }


        static void pascalTriangle_1(int size){
        
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
        int n = 7;
        int row = 6;
        int col = 3;
        int result = pascalValue(row, col);
        int result_1 = pascalValue_1(row, col);
        System.out.println(result);
        System.out.println(result_1);
        nthRowValues(n);
        nthRowValues_1(n);
        pascalTriangle(n);
        pascalTriangle_1(n);
    }
}
