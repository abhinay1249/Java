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

import java.util.*;

class Main {



        public static boolean wordBreak(String s, List<String> wordBreak){
        
            int index = 0;
        
            return recursiveWordBreak(index, s, wordBreak);
        
        
        }
    public static void main(String[] args) {
        
        String s = "takeuforward";

        List<String> wordDict = new ArrayList<>(Arrays.asList("take", "forward", "u", "you"));

        boolean result = wordBreak(s, wordDict);

        System.out.println(result);
    }
}


