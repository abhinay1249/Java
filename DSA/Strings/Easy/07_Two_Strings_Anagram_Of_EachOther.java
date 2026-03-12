// Problem Statement: Given two strings, check if two strings are anagrams of each other or not.

import java.util.*;

class Main{

    // ======================= Brute-Force Approach ===============================

        static boolean validateStringsAsAnagram(String s1, String s2){
            int sLength = s.length();
            int tLength = t.length();

            if(sLength != tLength){
                return false;
            }

            char[] char_1 = s.toCharArray();
            char[] char_2 = t.toCharArray();

            Arrays.sort(char_1);
            Arrays.sort(char_2);                                // T.C = O(2 N LOG N) + O(N) , S.C = O(2N)

            int index_1 = 0, index_2 = 0;

            while(index_1 < sLength && index_2 < tLength){

                if(char_1[index_1] != char_2[index_2]){
                    return false;
                }

                index_1++;
                index_2++;
            }
            return true;                      
        }

    // ======================= Optimal Approach ===============================

        static boolean validateStringsAsAnagram_1(String s1, String s2){
                      
        }

    public static void main(String[] args){
        String s = "caac";
        String t = "ccaa";
        boolean result = twoStringsAnagram_1(s,t);
        System.out.println(result);
    }
}
