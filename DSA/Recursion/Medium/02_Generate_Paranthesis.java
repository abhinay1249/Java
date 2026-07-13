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

    private static boolean validStrings(String s){
        int counter = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                counter++;
            }else{
                counter--;
            }

            if(counter < 0){
                return false;
            }
        }

        return counter == 0;
    }

    public static List<String> generateParanthesis(String s, List<String> paranthesis, int n){

        if(s.length() == n){
            if(validStrings(s)){
                paranthesis.add(s);
            }
            return paranthesis;
        }

        generateParanthesis(s+'(', paranthesis, n);
        generateParanthesis(s+')', paranthesis, n);

        return paranthesis;
    }

    public static void main(String[] args) {

        int n = 3;
        List<String> paranthesis = new ArrayList<>();
        List<String> result = generateParanthesis("", paranthesis, n);

        for(int index = 0 ; index < result.size() ; index++){
            System.out.print(result.get(index)+" ");
        }

    }
}