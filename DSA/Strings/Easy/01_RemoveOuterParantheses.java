// Problem Statement: A valid parentheses string is defined by the following rules:

// It is the empty string "".
// If A is a valid parentheses string, then so is "(" + A + ")".
// If A and B are valid parentheses strings, then A + B is also valid.

// A primitive valid parentheses string is a non-empty valid string that cannot be split into two or more non-empty valid parentheses strings.

// Given a valid parentheses string s, your task is to remove the outermost parentheses from every primitive component of s and return the resulting string.


class Main {

    // =========================== Brute Force Approach ==============================

        static String removeOuterParantheses(String s){

            String result = "";
            int counter = 0;

            for(char ch : s.toCharArray()){

                if(ch == '('){
                    if(counter > 0){
                        result+='(';                                // T.C = O(N^2), S.C = O(1)
                    }
                    counter++;
                }else if(ch == ')'){
                    counter--;
                    if(counter > 0){
                        result+=')';
                    }
                }
            }
            return result;
        }

    // =========================== Optimal Approach ==============================

        static int removeOuterParantheses_1(String s){
            
            StringBuilder result = new StringBuilder();
            int counter = 0;

            for(int index = 0 ; index < s.length() ; index++){

                char ch = s.charAt(index);

                if(ch == '('){
                    if(counter > 0){
                        result.append('(');                            // T.C = O(N), S.C = O(1)
                    }
                    counter++;
                }else if(ch == ')'){
                    counter--;
                    if(counter > 0){
                        result.append(')');
                    }
                }
            }
            return result;
        }

    public static void main(String[] args) {

        String s = "(()())(())";
        String result = removeOuterParantheses_1(s);
        System.out.println(result);
    }
}