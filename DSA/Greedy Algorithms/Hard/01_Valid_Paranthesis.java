// Problem Statement: Find the validity of an input string s that only contains the letters '(', ')' and '*'.
// A string entered is legitimate if
// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

// Example 1:

// Input : s = (*))
// Output : true
// Explanation : The * can be replaced by an opening '(' bracket. The string after replacing the * mark is "(())" and is a valid string.

// Example 2:

// Input : s = *(()
// Output : false
// Explanation : The * replaced with any bracket does not form a valid string.

class Main {

    // ============================= Brute Force Approach ===========================

        public static boolean validParanthesis(String str, int counter, int index){

            if(counter < 0) return false;

            if(index == str.length()) return (counter == 0);

            char ch = str.charAt(index);

            if(ch == '(')  return validParanthesis(str, counter+1, index+1);            // T.C = O(3^N), S.C = O(N)
            
            else if( ch == ')') return validParanthesis(str, counter-1, index+1);

            return validParanthesis(str, counter+1, index+1) || validParanthesis(str, counter-1, index+1) || validParanthesis(str, counter, index+1);

        }

    // ========================= Greedy Algorithm Approach ==============================

        public static boolean validParanthesis(String str){

            int minimum = 0;
            int maximum = 0;

            int length = str.length();

            for(int index = 0 ; index < length ; index++){
                
                char ch = str.charAt(index);

                if(ch == '('){
                    minimum += 1;
                    maximum += 1;
                }else if(ch == ')'){
                    minimum -= 1;
                    maximum -= 1;                    
                }else{
                    minimum -= 1;
                    maximum += 1;
                }
                
                if(minimum < 0) minimum = 0;

                if(maximum < 0) return false;

                
            }

        }
    
    public static void main(String[] args){

        String str = "(*))";

        boolean result = validParanthesis(str, 0, 0);

        System.out.println(result);

        boolean result_1 = validParanthesis_1(str);

        System.out.println(result_1);

    }
}