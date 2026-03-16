


import java.util.*;

class Main {
    
    static int romanToInteger(String s){
        int length = s.length();
        
        Map<Character,Integer> romanValues = new HashMap<>();
        
        romanValues.put('I',1);
        romanValues.put('V',5);
        romanValues.put('X',10);
        romanValues.put('L',50);
        romanValues.put('C',100);
        romanValues.put('D',500);
        romanValues.put('M',1000);
        
        int index = 0;
        int number = 0;
        
        while(index < length){
            
            if(index+1 < length && romanValues.get(s.charAt(index)) < romanValues.get(s.charAt(index+1))){
                int difference = romanValues.get(s.charAt(index+1)) - romanValues.get(s.charAt(index));
                number += difference;
                index+=2;
            }else{
                number += romanValues.get(s.charAt(index));
                index++;
            }
        }
        return number;
    }
    public static void main(String[] args) {
        String romanNumber = "LVIII";
        int result = romanToInteger(romanNumber);
        System.out.println(result);
    }
}