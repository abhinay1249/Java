// Problem Statement: Given two strings, check if two strings are anagrams of each other or not.

// Example 1:

// Input: CAT, ACT
// Output: true
// Explanation: Since the count of every letter of both strings are equal.

// Example 2:

// Input: RULES, LESRT 
// Output: false
// Explanation: Since the count of U and T  is not equal in both strings.
            
import java.util.*;

class Main{

    // ======================= Brute-Force Approach ===============================

        static boolean validateStringsAsAnagram(String s1, String s2){
            int sLength = s1.length();
            int tLength = s2.length();

            if(sLength != tLength){
                return false;
            }

            char[] char_1 = s1.toCharArray();
            char[] char_2 = s2.toCharArray();

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
            int sLength = s1.length();
            int tLength = s2.length();

            if(sLength != tLength){
                return false;
            }

            int[] charCount = new int[26];

            s1=s1.toLowerCase();
            s2=s2.toLowerCase();

            s1= s1.replace(" ","");                                       // T.C = O(N), S.C = O(1)
            s2= s2.replace(" ","");

            for(int index = 0 ; index < sLength ; index++){
                char ch = s1.charAt(index);
                int idx = ch - 'a';
                charCount[idx]++;
            }

            for(int index = 0 ; index < tLength ; index++){
                char ch = s2.charAt(index);
                int idx = ch - 'a';
                charCount[idx]--;
            }

            for(int value : charCount){
                if(value != 0){
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args){
        String s = "caac";
        String t = "ccaa";
        boolean result = validateStringsAsAnagram_1(s,t);
        System.out.println(result);
    }
}
