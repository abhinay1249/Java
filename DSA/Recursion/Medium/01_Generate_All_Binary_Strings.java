// Problem Statement: Given an integer n, return all binary strings of length n that do not contain consecutive 1s. 
// Return the result in lexicographically increasing order.

// A binary string is a string consisting only of characters '0' and '1'.

// Example 1:

// Input: n = 3  
// Output: ["000", "001", "010", "100", "101"]  
// Explanation: All binary strings of length 3 that do not contain consecutive 1s.

// Example 2:

// Input: n = 2  
// Output: ["00", "01", "10"]  
// Explanation: All binary strings of length 2 that do not contain consecutive 1s.

import java.util.ArrayList;
import java.util.List;

class Main{


    private static List<String> recursiveStrings(String s, List<String> validStrings, int lastDigit, int n){
        
        if(s.length() == n){
            validStrings.add(s);
            return validStrings;
        }

        recursiveStrings(s+'0', validStrings, 0, n);
        if(lastDigit == 0){
            recursiveStrings(s+'1', validStrings, 1, n);
        }
        
        return validStrings; 

    }

    public static List<String> validStrings(int n){

        String s = "";
        List<String> validStrings = new ArrayList<>();
        int lastDigit = 0;
        
        return recursiveStrings(s,validStrings,lastDigit,n);

    } 

    public static void main(String[] args) {
        int n = 4;

        List<String> strings = validStrings(n);

        System.out.print("[");

        for(int index = 0 ; index < strings.size() ; index++){
            if(index == strings.size()-1){
                System.out.print(strings.get(index));
            }else{
                System.out.print(strings.get(index) + ", ");
            }
            
        }

        System.out.print("]");
    }
}