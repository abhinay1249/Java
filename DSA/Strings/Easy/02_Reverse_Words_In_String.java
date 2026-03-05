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
            }
            
            if(word.length() > 0){
                words.add(word);
                word="";
            }
        }
        Collections.reverse(words);
        String reverseWords = String.join(" ",words);
        
        return reverseWords; 
    }

    // ======================= Optimal Approach ===============================

    static String reverseWordsInString_1(String s){
        
    }

    public static void main(String[] args) {
       String s = "welcome to the jungle";
       String result = reverseWordsInString(s);
    }
}