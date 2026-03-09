// Problem Statement: Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position. 
// For example, if s = "abcde", then it will be "bcdea" after one shift.

class Main{

    static boolean rotateString(String s, String goal){

        if(s.length() != goal.length()){
            return false;
        }
        
        StringBuilder word = new StringBuilder(s);
        
        int length = s.length();
        
        for(int index = 0 ; index < length ; index++){
            char ch = s.charAt(index);                                  // T.C = O(N^2), S.C = O(N)  
            word.append(ch);
        }
        
        if(word.toString().contains(goal)){
            return true;
        }
        
        return false;
    }

    static boolean rotateString_1(String s, String goal){

        if(s.length() != goal.length()){
            return false;
        }
        
        String word = s+s;
        
        if(word.contains(goal)){                        // T.C = O(N^2), S.C = O(N)
            return true;
        }
        
        return false;
    }

    public static void main(String[] args){
        String s = "rotation";
        String goal = 'tionrota';

        boolean result = rotateString(s, goal);

        System.out.println(result);
    }
}