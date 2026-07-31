// Problem Statement: Given a string consisting of digits from 2 to 9 (inclusive). 
// Return all possible letter combinations that the number can represent.

// Example 1:

// Input: digits = "34"
// Output: [ "dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi" ]
// Explanation: The 3 is mapped with "def" and 4 is mapped with "ghi".
// So all possible combinations by replacing the digits with characters are shown in the output.

// Example 2:

// Input: digits = "3"
// Output: [ "d", "e", "f" ]
// Explanation: The 3 is mapped with "def".

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main{

    private static List<String> recursiveLetterCombinations(String s, List<String> al){


        return al;
    }

    public static List<String> letterCombinations(String s, List<String> al){

        Map<Character, String> phoneNumbers = new HashMap<>();




        return al;
    }
    public static void main(String[] args) {
        
        String s = "34";

        List<String> al = new ArrayList<>();

        letterCombinations(s,al);


    }
}