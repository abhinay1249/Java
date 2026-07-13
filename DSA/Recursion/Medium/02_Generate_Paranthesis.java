// Problem Statement: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:

// Input: n = 3
// Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
// Explanation : Need to generate a list of parantheses of that n size and inserted into the list.

// Example 2:

// Input: n = 1
// Output: ["()"]
// Explanation : Need to generate a list of parantheses of that n size and inserted into the list.

import java.util.ArrayList;
import java.util.List;

class Main{

    // ============================== Brute Force [Recursive] Approach ====================================

        private static boolean validStrings(String s){
            int counter = 0;

            for(char ch : s.toCharArray()){
                if(ch == '('){
                    counter++;
                }else{
                    counter--;
                }

                if(counter < 0){
                    return false;                                   // T.C = O(), S.C = O()
                }
            }

            return counter == 0;
        }

        public static void generateParanthesis(String s, List<String> paranthesis, int n){

            if(s.length() == 2 * n){
                if(validStrings(s)){
                    paranthesis.add(s);
                }
                return;
            }

            generateParanthesis(s+'(', paranthesis, n);
            generateParanthesis(s+')', paranthesis, n);

        }

    public static void main(String[] args) {

        int n = 3;
        List<String> paranthesis = new ArrayList<>();
        generateParanthesis("", paranthesis, n);

        for(int index = 0 ; index < paranthesis.size() ; index++){
            System.out.print(paranthesis.get(index)+" ");
        }

    }
}