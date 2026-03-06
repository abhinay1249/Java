// Problem Statement: Given a string s, representing a large integer, the task is to return 
// the largest-valued odd integer (as a string) that is a substring of the given string s.
// The number returned should not have leading zero's. But the given input string may have leading zero.

class Main {

    // ======================= Brute-Force Approach ===============================

    static String largestOddNumberInString(String s){
        
        int pointer = s.length()-1;
        int idx = -1;
        
        while(pointer >= 0){
            char ch = s.charAt(pointer);
            int number = Integer.valueOf(ch);
            
            if(number % 2 == 0){
                pointer--;
            }else{
                idx = pointer;
                break;
            }
        }
        String word = "";
        for(int index = 0 ; index <= idx ; index++){
            char ch = s.charAt(index);
            word+=ch;
        }
        return word;
        
    }

    // ======================= Optimal Approach ===============================

    static String largestOddNumberInString_1(String s){
        
    }

    public static void main(String[] args) {
       String s =  s = "5347";
       String result = largestOddNumberInString_1(s);
    }
}