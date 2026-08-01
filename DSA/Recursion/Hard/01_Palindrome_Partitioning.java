// Problem Statement : Given a string s partition string s such that every substring of partition is palindrome. 
// Return all possible palindrome partition of string s.

// Example 1

// Input : s = "aabaa"
// Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , 
// [ "a", "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]
// Explanation : Above all are the possible ways in which the string can be partitioned so that each substring is a palindrome.

// Example 2

// Input : s = "baa"
// Output : [ [ "b", "a", "a"] , [ "b", "aa" ] ]
// Explanation : Above all are the possible ways in which the string can be partitioned so that each substring is a palindrome.

import java.util.ArrayList;
import java.util.List;

class Main{

    private static boolean isPalindrome(String str, int left, int right){

        while(left <= right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }

        return true;

    }

    private static void recursivePartition(String s, int index, List<List<String>>al, List<String> ds){
        
        if(index == s.length()){
            al.add(new ArrayList<>(ds));
            return;
        }

        for(int characterIdx = index ; characterIdx < s.length() ; characterIdx++){
            if(isPalindrome(s, index, characterIdx)){
                ds.add(s.substring(index, characterIdx+1));
                recursivePartition(s, characterIdx+1, al, ds);
                ds.remove(ds.size()-1);
            }
        }
    }


    public static List<List<String>> partition(String s, List<List<String>> al) {

        int index = 0;

        recursivePartition(s, index, al, new ArrayList<>());

        return al;
        
    }
    public static void main(String[] args) {

        String s = "aabaa";

        List<List<String>> al = new ArrayList<>();

        partition(s, al);

        System.out.println(al);
    }
}