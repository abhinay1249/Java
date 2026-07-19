// Problem Description: Given a string, find all the possible subsequences of the string.

// Example 1:

// Input: str = "abc"
// Output: [a, ab, abc, ac, b, bc, c]
// Explanation: Given string has 7 subsequences.

// Example 2:

// Input: str = "aa"
// Output: [a, a, aa] 
// Explanation: Given string has 3 subsequences.

import java.util.ArrayList;
import java.util.List;

class Main{

    // ==================================== Brute Force [Recursive] Approach ===========================================

        private static List<String> recursiveStrings(String words, int index, List<String> al, String str){

            int length = str.length();
            
            if(index == length){
                al.add(words);
                return al;
            }

            words += str.charAt(index);
            recursiveStrings(words,index+1,al,str);
            words = words.substring(0,words.length()-1);            // T.C = O(2^N * N), S.C = O(N)
            recursiveStrings(words,index+1,al,str);

            return al;

        }
    
        public static List<String> powerSet(String str){
            
            int index = 0;
            List<String> al = new ArrayList<>();
            String words = "";
            
            return recursiveStrings(words,index,al,str);
        
        }

    // ================================= Optimal [Bit Manipulation] Approach ===========================================

        public static List<String> powerSet_1(String str){

            int length = str.length();
            List<String> subsequences = new ArrayList<>();

            int total = 1<<length;

            for(int number = 0 ; number < total ; number++){
                StringBuilder st = new StringBuilder();

                for(int index = 0 ; index < length ; index++){                      // T.C = O(2^N * N), S.C = O(1)
                    if((number & (1<<index)) != 0){
                        st.append(str.charAt(index));
                    }
                }
                subsequences.add(st.toString());
            }

            return subsequences;

        }


    public static void main(String[] args) {
        
        String s = "abc";
        List<String> ds = powerSet(s);
        
        for(int i = 0 ; i < ds.size(); i++){
            System.out.print(ds.get(i)+ " ");
        }

        System.out.println();
        
        List<String> ds_1 = powerSet_1(s);

        for(int i = 0 ; i < ds.size(); i++){
            System.out.print(ds_1.get(i)+ " ");
        }
    }
}