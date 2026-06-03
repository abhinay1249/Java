// Problem Statement: Given a valid parentheses string s, return the nesting depth of s. 
// The nesting depth is the maximum number of nested parentheses.

// Example 1:
// Input:
//  s = "(1+(2*3)+((8)/4))+1"
// Output:
//  3
// Explanation:
//  Digit 8 is inside of 3 nested parentheses in the string.

// Example 2:
// Input:
//  s = "(1)+((2))+(((3)))"
// Output:
//  3
// Explanation:
//  Digit 3 is inside of 3 nested parentheses in the string.


class Main {

    // ======================= Optimal Approach ===============================
    
        public static int maxNestingDepth(String s){
            
            int length = s.length();

            int count = 0;
            int maxNesting = Integer.MIN_VALUE;

            for(int index = 0 ; index < length ; index++){
                char ch = s.charAt(index);

                if(ch == '('){                                      // T.C = O(N), S.C = O(1)
                    count++;
                }else if(ch == ')'){
                    count--;
                }
                maxNesting=Math.max(maxNesting,count);
            }
            return maxNesting;
        }

    public static void main(String[] args){
        String s = "(1+(2*3)+((8)/4))+1";
        int result = maxNestingDepth(s);
        System.out.println(result);
    }
}