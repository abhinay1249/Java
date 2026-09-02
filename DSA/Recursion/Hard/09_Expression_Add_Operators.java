// Problem Statement: Given a string num that contains only digits and an integer target, 
// return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num 
// so that the resultant expression evaluates to the target value.

// Note that operands in the returned expressions should not contain leading zeros.

// Note that a number can contain multiple digits.

// Example 1:

// Input: num = "123", target = 6
// Output: ["1*2*3","1+2+3"]
// Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

// Example 2:

// Input: num = "232", target = 8
// Output: ["2*3+2","2+3*2"]
// Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.

import java.util.ArrayList;
import java.util.List;

class Main{

    // ========================================== Only Approach ===================================

        private static List<String> recursiveExpression(int index, List<String> al, String numStr, int target, String currStr, long prev, long residual){

            if(index == numStr.length()){
                if(residual == target){
                    al.add(currStr);
                }
                return al;
            }

            String curr = "";
            long num = 0;

            for(int index_1 = index ; index_1 < numStr.length() ; index_1++){

                if(index_1 > index && numStr.charAt(index) == '0') break;

                curr += numStr.charAt(index_1);
                num = num * 10 + numStr.charAt(index_1) - '0';

                if(index == 0){
                    recursiveExpression(index_1+1, al, numStr, target, curr, num, num);
                }else{
                    recursiveExpression(index_1+1, al, numStr, target, currStr + "+" + curr, num, residual+num);
                    recursiveExpression(index_1+1, al, numStr, target, currStr + "-" + curr, -num, residual-num);
                    recursiveExpression(index_1+1, al, numStr, target, currStr + "*" + curr, prev * num, (residual - prev) + (prev * num));
                }

            }
            return al;
        }

        public static void addOperators(String num, int target){

            List<String> al = new ArrayList<>();

            int index = 0;                                                  // T.C = O(4^(N-1) * N), S.C = O(N)

            recursiveExpression(index, al, num, target, num, index, index);

            System.out.println(al);

        }

    public static void main(String[] args) {

        String num = "123";
        int target = 6;
        
        addOperators(num, target);
        
    }
}