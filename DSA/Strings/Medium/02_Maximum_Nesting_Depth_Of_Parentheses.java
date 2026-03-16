// Problem Statement: Given a valid parentheses string s, return the nesting depth of s. 
// The nesting depth is the maximum number of nested parentheses.

class Main {

    // ======================= Optimal Approach ===============================
    
        static int maxNestingDepth(String s){
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