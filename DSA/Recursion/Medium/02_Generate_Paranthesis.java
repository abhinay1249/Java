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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
                    return false;                                   // T.C = O(2^2N * N), S.C = O(N^2)
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

    // =================================== Optimal Approach ====================================

        public static List<String> generateParanthesis_1(String s, List<String> paranthesis, int n){

            Queue<String> ds = new LinkedList<>();

            ds.add(s);

            while(!ds.isEmpty()){
                String curr = ds.remove();

                if(curr.length() == 2 * n){
                    if(validStrings(curr)){
                        paranthesis.add(curr);                          // T.C = O(2^2N * N), S.C = O(N * 2^2N)
                    }
                    continue;
                }

                ds.add(curr+"(");
                ds.add(curr+")");
            }

            return paranthesis;
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