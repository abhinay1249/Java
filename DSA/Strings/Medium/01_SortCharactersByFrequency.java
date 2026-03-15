// Problem Statement: You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.
// If two or more characters have same frequency then arrange them in alphabetic order.

import java.util.*;

class Main{

    static String sortCharactersByFrequency(String s){
                
        Map<Character,Integer> charCount = new HashMap<>();

        int length = s.length();

        for(int index = 0 ; index < length ; index++){
            char ch = s.charAt(index);
            charCount.put(ch,charCount.getOrDefault(ch,0)+1);            // T.C = O(N)+O(K)+O(K LOG K)+O(N), S.C = O(K)+O(K)+O(N) 
        }

        List<Map.Entry<Character,Integer>> chars = new ArrayList<>(charCount.entrySet());

        Collections.sort(chars, (charCount_1,charCount_2) -> charCount_2.getValue().compareTo(charCount_1.getValue()));

        StringBuilder word = new StringBuilder();

        for(Map.Entry<Character,Integer> letters : chars){
            int letterCount = letters.getValue();
            for(int number = 0 ; number < letterCount ; number++){
                word.append(letters.getKey());
            }
        }

        return word.toString();

    } 

    public static void main(String[] args){
        String s = "Aabb";
        String result = sortCharactersByFrequency(s);
        System.out.println(result);
    }
}