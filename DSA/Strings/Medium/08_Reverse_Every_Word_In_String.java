// Problem Statement: Given an input string, containing upper-case and lower-case letters, digits, and spaces( ' ' ). 
// A word is defined as a sequence of non-space characters. 
// The words in s are separated by at least one space. 
// Return a string with the words in reverse order, concatenated by a single space.

// Example 1:
// Input:
//  s = " -12345"  
// Output:
//  -12345  
// Explanation:
  
// Ignore leading whitespaces.  
// The sign '-' is encountered, indicating the number is negative.  
// Digits 12345 are read and converted to -12345.

// Example 2:
// Input:
//  s = "4193 with words"  
// Output:
//  4193  
// Explanation:
  
// Read the digits 4193 and stop when encountering the first non-digit character (w).



import java.util.*;

class Main {

    // ======================= Brute-Force Approach ===============================

        static String reverseWordsInString(String s){
            
            int length = s.length();

            if(length == 1 && s.charAt(0)!=' '){
                return s;
            }

            StringBuilder word = new StringBuilder();

            List<String> words = new ArrayList<>();                       // T.C = O(N) + O(N) + O(N), S.C = O(words in sentence)

            for(int character = 0 ; character < length ; character++){

                while(character < length && s.charAt(character)!=' '){
                    word.append(s.charAt(character));
                    character++;
                }

                if(word.length() > 0){
                    words.add(word.toString());
                    word.setLength(0);
                }
            }

            Collections.reverse(words);
            String reverseWord = String.join(" ",words);

            return reverseWord;
        }
    
    // ======================== Optimal Approach ===============================

        static String reverseWordsInString_1(String s){
        
            String str = reverse(s);

            StringBuilder words = new StringBuilder();
            StringBuilder reverseWord = new StringBuilder();

            for(int character = 0 ; character < str.length() ; character++){

                while(character < str.length() && str.charAt(character)!=' '){
                    words.append(str.charAt(character));
                    character++;
                }

                if(words.length() > 0){                                                 // T.C = O(N) + O(N) + O(N), S.C = O(1)
                    words.reverse();
                    reverseWord.append(" ").append(words);
                    words.setLength(0);
                }
            }

            return reverseWord.substring(1);
        }
        
    public static void main(String[] args) {
        String s = "  Love is Java ";
        String result = reverseWordsInString(s);
        System.out.println(result);
    }
}