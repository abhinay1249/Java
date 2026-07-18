// Problem Description: Given a string, find all the possible subsequences of the string.

// Example 1:

// Input: str = "abc"
// Output: [a, ab, abc, ac, b, bc, c]
// Explanation: Given string has 7 subsequences.

// Example 2:

// Input: str = "aa"
// Output: [a, a, aa] 
// Explanation: Given string has 3 subsequences.

import java.util.*;

class Main{

    // ==================================== Brute Force [Recursive] Approach ===========================================

        private static List<String> recursiveStrings(int index, List<String> al, String str){

            int length = str.length();
            String words = "";

            
            if(index == length){
                al.add(words);
                return al;
            }

            words += str.charAt(index);
            recursiveStrings(index+1,al,str);
            words = words.substring(0,words.length()-1);
            recursiveStrings(index+1,al,str);

            return al;

        }
    
        public static List<String> powerSet(String str){
            
            int index = 0;
            List<String> al = new ArrayList<>();
            
            return recursiveStrings(index,al,str);
        
        }

    // ================================= Optimal [Bit Manipulation] Approach ===========================================


        public static List<Integer> powerSet_1(String str){

        
        }



    public static void main(String[] args) {
        
        String s = "abc";
        powerSet(s);
        powerSet_1(s);

    }
}