// Problem Statement: Given an input string, containing upper-case and lower-case letters, digits, and spaces( ' ' ). 
// A word is defined as a sequence of non-space characters. The words in s are separated by at least one space. 
// Return a string with the words in reverse order, concatenated by a single space.

import java.util.*;

class Main {

    // ======================= Brute-Force Approach ===============================

        static String reverseWordsInString(String s){

            int length = s.length();

            if(length == 1){
                return s;
            }
            String word = "";                           

            List<String> words = new ArrayList<>();                         

            for(int character = 0 ; character < length ; character++){

                while(character < length && s.charAt(character) != ' '){
                    word+=s.charAt(character);
                    character++;                
                }                                           // T.C = O(N^2) + O(N) + O(N) , S.C = O(words in sentence)

                if(word.length() > 0){
                    words.add(word);
                    word="";
                }
            }

            Collections.reverse(words);
            String reverseWords = String.join(" ",words);

            return reverseWords; 
        }

    // ======================= Better Approach ===============================

        static String reverseWordsInString_1(String s){

            int length = s.length();

            if(length == 1){
                return s;
            }

            StringBuilder word = new StringBuilder();

            List<String> words = new ArrayList<>();

            for(int character = 0 ; character < length ; character++){

                while(character < length && s.charAt(character) != ' '){
                    word.append(s.charAt(character));
                    character++;
                }

                if(word.length() > 0){                       // T.C = O(N) + O(N) + O(N) , S.C = O(words in sentence)
                    words.add(word.toString());
                    word.setLength(0);                              
                }
            }
            Collections.reverse(words);
            String reverseWords = String.join(" ",words);

            return reverseWords; 
        }
    
    // ======================= Optimal Approach ===============================

        static String reverse(String s){
            StringBuilder sb = new StringBuilder(s);
            return  sb.reverse().toString();
        }

        static String reverseWordsInString_1(String s){
            int length = s.length();
            StringBuilder word = new StringBuilder();
            StringBuilder reverseWords = new StringBuilder();

            s = reverse(s);

            for(int character = 0 ; character < length ; character++){

                while(character < length && s.charAt(character) != ' '){
                    word.append(s.charAt(character));
                    character++;
                }

                if(word.length() > 0){
                    word.reverse();
                    reverseWords.append(" ").append(word);
                    word.setLength(0);
                }
            }

            return reverseWords.substring(1);
        }


    public static void main(String[] args) {
       String s = "Hi I am Abhinay";
       String result = reverseWordsInString(s);
    }
}