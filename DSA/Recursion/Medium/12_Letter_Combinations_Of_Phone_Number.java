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

    private static void recursiveLetterCombinations(int index, String digits, List<String> al, Map<Character,String> phoneNumbers, StringBuilder temp){
    
        if(index == digits.length()){
            al.add(temp.toString());
            return;
        }

        String str = phoneNumbers.get(digits.charAt(index));

        for(int characterIndex = 0 ; characterIndex < str.length() ; characterIndex++){
            temp.append(str.charAt(characterIndex));
            recursiveLetterCombinations(index+1, digits, al, phoneNumbers, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    
    }

    public static List<String> letterCombinations(String digits, List<String> al){

        Map<Character, String> phoneNumbers = new HashMap<>();
        
        phoneNumbers.put('2',"abc");
        phoneNumbers.put('3',"def");
        phoneNumbers.put('4',"ghi");
        phoneNumbers.put('5',"jkl");
        phoneNumbers.put('6',"mno");
        phoneNumbers.put('7',"pqrs");
        phoneNumbers.put('8',"tuv");
        phoneNumbers.put('8',"wxyz");

        recursiveLetterCombinations(0, digits, al, phoneNumbers, new StringBuilder(""));

        return al;
        
    }
    public static void main(String[] args) {
        
        String s = "34";

        List<String> al = new ArrayList<>();

        letterCombinations(s,al);

        System.out.println(al);

    }
}