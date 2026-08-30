// Problem Statement : Given a string s and a dictionary of strings wordDict, 
// Return true if s can be segmented into a space-separated sequence of one or more dictionary words otherwise return false.

// Example 1

// Input : s = "takeuforward", wordDict = [ "take", "forward", "you", "u" ]
// Output : true
// Explanation : Return true because "takeuforward" can be segmented as "take", "u", "forward".

// Example 2

// Input : s = "applepineapple", wordDict = [ "apple" ]
// Output : false
// Explanation : Return false because "applepineapple" can be segmented as "apple", "pine", "apple" 
// but here we do not have "pine" word in dictionary.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {

    // ================================ Brute Force Approach ==========================================

        private static boolean recursiveWordBreak(int index, String s, List<String> wordDict){

            if(index == s.length()){
                return true;
            }

            for(int runningIndex = index ; runningIndex < s.length() ; runningIndex++){
                if(wordDict.contains(s.substring(index, runningIndex+1))){
                    if(recursiveWordBreak(runningIndex+1, s, wordDict)){
                        return true;
                    }
                }   
            }

            return false;                                                       // T.C = O(2^N * N^2), S.C = O(N)

        }

        public static boolean wordBreak(String s, List<String> wordDict){

            int index = 0;

            return recursiveWordBreak(index, s, wordDict);

        }

    // ================================ Optimal Approach ==============================================

        public static boolean wordBreak_1(String s, List<String> wordDict){

            Set<String> hs = new HashSet<>(wordDict);

            int maxLength = 0;

            for(String word : wordDict){
                maxLength = Math.max(maxLength, word.length());
            }
         
            boolean[] dp = new boolean[s.length()+1];                          // T.C = O(N^2) + O(N), S.C = O(N + D) + O(N)
            
            dp[0] = true;

            for(int index_1 = 1 ; index_1 <= s.length() ; index_1++){

                for(int index_2 = index_1 - 1 ; index_2 >= Math.max(0, index_1 - maxLength) ; index_2--){
                    if(dp[index_2] && hs.contains(s.substring(index_2,index_1))){
                        dp[index_1] = true;
                        break;
                    }
                }
            }

            return dp[s.length()];

        }

    public static void main(String[] args) {
        
        String s = "takeuforward";

        List<String> wordDict = new ArrayList<>(Arrays.asList("take", "forward", "u", "you"));

        boolean result = wordBreak(s, wordDict);

        System.out.println(result);

        boolean result_1 = wordBreak_1(s, wordDict);

        System.out.println(result_1);

    }
}


