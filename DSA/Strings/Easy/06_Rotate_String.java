// Problem Statement: Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position. 
// For example, if s = "abcde", then it will be "bcdea" after one shift.

// Example 1:

// Input: s = "rotation", goal = "tionrota"
// Output: true
// Explanation: After multiple left shifts on "rotation", we get:
//     1st shift → "otationr"
//     2nd shift → "tationro"
//     3rd shift → "ationrot"
//     4th shift → "tionrota"
//     So the goal string can be obtained by rotating the original string.

// Example 2:
// Input: s = "hello", goal = "lohelx"
// Output: false
// Explanation: Even after all possible rotations of "hello", we cannot form "lohelx" due to the presence of an extra character 'x'. 
// Hence, it's not possible.
            

class Main{

    // ======================= Brute-Force Approach ===============================

        static boolean rotateString(String s, String goal){

            if(s.length() != goal.length()){
                return false;
            }

            StringBuilder word = new StringBuilder(s);

            int length = s.length();

            for(int index = 0 ; index < length ; index++){
                char ch = s.charAt(index);                                  // T.C = O(N^2), S.C = O(N)  
                word.append(ch);
            }

            if(word.toString().contains(goal)){
                return true;
            }

            return false;
        }
    
    // ======================= Brute-Force Approach (Reduced Code) ===============================

        static boolean rotateString_1(String s, String goal){

            if(s.length() != goal.length()){
                return false;
            }

            String word = s+s;

            if(word.contains(goal)){                        // T.C = O(N*M), S.C = O(N)
                return true;
            }

            return false;
        }

    // ======================= Optimal Approach - KMP ALgorithm ===============================
        
        static boolean rotateString_2(String s, String goal){

            int length = s.length();
            int goalLength = goal.length();

            StringBuilder word = new StringBuilder(s);

            word.append(s);

            int len = 0;

            int index = 1;

            int[] lsp = new int[goalLength];

            while(index < goalLength){
                if(goal.charAt(index) == goal.charAt(len)){
                    len++;
                    lsp[index]=len;
                    index++;
                }else{
                    if(len != 0){
                        len = lsp[len-1];
                    }else{                                          // T.C = O(N) + O(N) + O(N), S.C = O(N)
                        lsp[index] = 0;
                        index++;
                    }
                }
            }
            int pointer_1 = 0; 
            int pointer_2 = 0; 

            while(pointer_1 < word.length()){
                if(word.charAt(pointer_1) == goal.charAt(pointer_2)){
                    pointer_1++;
                    pointer_2++;
                }

                if(pointer_2 == goalLength){
                    return true;
                }else if(pointer_1 < word.length() && word.charAt(pointer_1) != goal.charAt(pointer_2)){
                    if(pointer_2 != 0){
                        pointer_2 = lsp[pointer_2-1];
                    }else{
                        pointer_1++;
                    }
                }        
            }
            return false;
        }

    public static void main(String[] args){
        String s = "rotation";
        String goal = "tionrota";

        boolean result = rotateString(s, goal);

        System.out.println(result);
    }
}