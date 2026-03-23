// Problem Statement: The beauty of a string is defined as the difference between the frequency of the most frequent character and 
// the least frequent character (excluding characters that do not appear) in that string.
// Given a string s, return the sum of beauty values of all possible substrings of s.

// Given a string s, return the longest palindromic substring in s.
// A palindromic substring is a contiguous sequence of characters within the string that reads the same forward and backward.

import java.util.*;

class Main {

        static int sumOfAllSubstrings(String s){
            int length = s.length();

            if(length == 0){
                return 0;
            }

            if(length == 1){
                return 1;
            }

            Map<Character,Integer> freqCount = new HashMap<>();

            int totalSum = 0;                                                   //T.C = O(N^3), S.C = O(1)

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


    public static void main(String[] args) {
        String s = "aabcbaa";
        int result = sumOfAllSubstrings(s);
        System.out.println(result);
    }
}