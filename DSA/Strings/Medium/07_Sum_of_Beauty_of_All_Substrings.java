// Problem Statement: The beauty of a string is defined as the difference between the frequency of the most frequent character and 
// the least frequent character (excluding characters that do not appear) in that string.
// Given a string s, return the sum of beauty values of all possible substrings of s.

// Given a string s, return the longest palindromic substring in s.
// A palindromic substring is a contiguous sequence of characters within the string that reads the same forward and backward.


// Example 1:

// Input: s = "xyx"
// Output: 1
// Explanation:
//  The substrings with non-zero beauty are:
// "xyx" → frequencies: x:2, y:1 → beauty = 2 - 1 = 1
// "xy" → x:1, y:1 → beauty = 0
// "yx" → y:1, x:1 → beauty = 0
// "x" or "y" → beauty = 0
// Total sum = 1 (from "xyx") = 1

// Example 2:
// Input:
//  s = "aabcbaa"
// Output:
//  17
// Explanation:
//  Various substrings such as "aabc", "bcba", etc., have non-zero beauty values. Summing all gives 17.



import java.util.*;

class Main {

    // ======================= Brute-Force Approach ===============================

        public static int sumOfAllSubstrings(String s){
            int length = s.length();

            if(length == 0){
                return 0;
            }

            if(length == 1){
                return 1;
            }

            Map<Character,Integer> freqCount = new HashMap<>();

            int totalSum = 0;                                                           //T.C = O(N^3), S.C = O(1)

            for(int index = 0 ; index < length ; index++){
                for(int index_1 = index ; index_1 < length ; index_1++){
                    for(int value = index ; value <= index_1 ; value++){
                        char ch = s.charAt(value);                              
                        freqCount.put(ch,freqCount.getOrDefault(ch,0)+1);
                    }
                    int max = Collections.max(freqCount.values());
                    int min = Collections.min(freqCount.values());
                    int diff = max - min;
                    totalSum += diff;
                    freqCount.clear();
                }
            }
            return totalSum;
        }

    // ======================== Optimal Approach ===============================
   
        public static int sumOfAllSubstrings_1(String s) {

            int length = s.length();

            if(length == 1){
                return 0;
            }
            int totalSum = 0;

            for(int index = 0 ; index < length ; index++){
                int[] freq = new int[26];
                for(int index_1 = index ; index_1 < length ; index_1++){

                    freq[s.charAt(index_1) - 'a']++;

                    int min = Integer.MAX_VALUE;                                        // T.C = O(N^2), S.C = O(1)
                    int max = Integer.MIN_VALUE;

                    for(int value = 0 ; value < 26 ; value++){

                        if(freq[value]!=0){
                            max = Math.max(max,freq[value]);
                            min = Math.min(min,freq[value]);
                        }

                    }
                    totalSum+= max - min;
                }
            }
            return totalSum;
        }

    public static void main(String[] args) {
        String s = "aabcbaa";
        int result = sumOfAllSubstrings(s);
        System.out.println(result);
    }
}