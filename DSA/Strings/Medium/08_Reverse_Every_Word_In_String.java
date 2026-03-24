// Problem Statement: Given an input string, containing upper-case and lower-case letters, digits, and spaces( ' ' ). 
// A word is defined as a sequence of non-space characters. 
// The words in s are separated by at least one space. 
// Return a string with the words in reverse order, concatenated by a single space.


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

    public static void main(String[] args) {
        String s = " amazing coding skills ";
        String result = reverseWordsInString(s);
        System.out.println(result);
    }
}