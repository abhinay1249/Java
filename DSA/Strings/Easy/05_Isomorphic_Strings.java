// Problem Statement: Given two strings s and t, determine if they are isomorphic. 
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. 
// No two characters may map to the same character, but a character may map to itself.

import java.util.*;

class Main{

    // ======================= Brute-Force Approach ===============================

        static boolean isIsomorphic(String s, String t) {
            int firstLength = s.length();
            int secondLength = t.length();

            for(int index = 0 ; index < firstLength ; index++){
                for(int character = index+1 ; character < secondLength ; character++){
                    char firstCharacter_s = s.charAt(index);
                    char secondCharacter_s = s.charAt(character);
                    char firstCharacter_t = t.charAt(index);
                    char secondCharacter_t = t.charAt(character);           // T.C = O(N^2), S.C = O(1)

                    if(firstCharacter_s == secondCharacter_s){
                        if(firstCharacter_t != secondCharacter_t){
                            return false;
                        }
                    }else{
                        if(firstCharacter_t == secondCharacter_t){
                            return false;
                        }
                    }
                }
            }
            return true;
        }

    // ======================= Better Approach ===============================

        static boolean isIsomorphic_1(String s, String t) {

            int sLength = s.length();
            int tLength = t.length();

            if(s.length() != t.length()){
                return false;
            }

            Map<Character,Character> charMap= new HashMap<>();

            for(int index = 0 ; index < sLength ; index++){
                char firstString = s.charAt(index);
                char secondString = t.charAt(index);                // T.C = O(N), S.C = O(N)

                if(charMap.containsKey(firstString)){
                    if(charMap.get(firstString) != secondString){
                        return false;
                    }
                }else{
                    if(charMap.containsValue(secondString)){
                        return false;
                    }else{
                        charMap.put(firstString,secondString);
                    }
                }
            }
            return true;
        }
        
    // ======================= Optimal Approach ===============================

        static boolean isIsomorphic_2(String s, String t) {

            int[] mapS = new int[256];
            int[] mapT = new int[256];

            int length = s.length();

            if(s.length() != t.length()){
                return false;
            }

            for(int index = 0 ; index < length ; index++){

                char c1 = s.charAt(index);
                char c2 = t.charAt(index);                          // T.C = O(N), S.C = O(1)


                if(mapS[c1] != mapT[c2]){
                    return false;
                }

                mapS[c1] = index + 1;
                mapT[c2] = index + 1;
            }
            return true;
        }

    public static void main(String[] args){
        String s = "kite";
        String t = "tart";
        boolean result = isIsomorphic(s,t);
        
        System.out.println(result);

    }
}