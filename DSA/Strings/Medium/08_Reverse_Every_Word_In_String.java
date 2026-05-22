// Problem Statement: Given an input string, containing upper-case and lower-case letters, digits, and spaces( ' ' ). 
// A word is defined as a sequence of non-space characters. 
// The words in s are separated by at least one space. 
// Return a string with the words in reverse order, concatenated by a single space.


// Input: s = "welcome to the jungle"
// Output: "jungle the to welcome"
// Explanation: The words in the input string are "welcome", "to", "the", and "jungle". 
// Reversing the order of these words gives "jungle", "the", "to", and "welcome". 
// The output string should have exactly one space between each word.

// Input: s = " amazing coding skills "
// Output: "skills coding amazing"
// Explanation: The input string has leading and trailing spaces, as well as multiple spaces between the words "amazing", "coding", and "skills". 
// After trimming the leading and trailing spaces and reducing the multiple spaces between words to a single space, the words are "amazing", "coding", and "skills". 
// Reversing the order of these words gives "skills", "coding", and "amazing". The output string should not have any leading or trailing spaces and should have exactly one space between each word.


import java.util.*;

class Main {

    // ======================= Brute-Force Approach ===============================

        public static String reverseWordsInString(String s){
            
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

        public static String reverseWordsInString_1(String s){
        
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