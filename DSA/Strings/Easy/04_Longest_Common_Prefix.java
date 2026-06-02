// Problem Statement: Write a function to find the longest common prefix string amongst an array of strings. 
// If there is no common prefix, return an empty string "".

// Example 1

// Input: str = ["flower", "flow", "flight"]
// Output: "fl"
// Explanation: All strings in the array begin with the common prefix "fl".

// Example 2

// Input: str = ["apple", "banana", "grape", "mango"]
// Output: ""
// Explanation: None of the strings share a common starting sequence, so the result is an empty string.


import java.util.*;

class Main {

    // ======================= Brute-Force Approach ===============================

        public static String longestCommonPrefix(String[] s){

            int elementLength = s[0].length();
            
            if(elementLength == 0){
                return "";
            }

            int length = s.length;

            StringBuilder prefix = new StringBuilder();                             // T.C = O(M * N-1) , S.C = O(Characters)=O(M)

            for(int character = 0 ; character < elementLength ; character++){
                char ch = s[0].charAt(character);

                for(int strings = 1 ; strings < length ; strings++){
                   if(character >= s[strings].length() || s[strings].charAt(character) != ch){
                        return prefix.toString();
                    }
                }
                prefix.append(ch);                      
            }
            return prefix.toString();
        }

    // ======================= Optimal Approach ===============================

        public static String longestCommonPrefix_1(String[] s){

            int elementLength = s[0].length();
            if(elementLength == 0){
                return "";
            }
            int length = s.length;
            Arrays.sort(s);

            int index = 0;
            int firstElementLength = s[0].length();
            int lastElementLength = s[length-1].length();                   

            int minLength = Math.min(lastElementLength,firstElementLength);

            while(index < minLength){
                char ch = s[0].charAt(index);
                char ch_1 = s[length-1].charAt(index);

                if(ch == ch_1){                                        // T.C = O(N Log (M+N)), S.C = O(1)
                    index++;
                }else{
                    return s[0].substring(0,index);
                }
            }
            return s[0].substring(0,minLength);
        }
        
    public static void main(String[] args) {
       String[] strings = {"zebra", "zen", "zealot"};
       String[] strings_1 = {"zea", "zea", "zea"};
       String result = longestCommonPrefix_1(strings);
       System.out.println(result);
    }
}