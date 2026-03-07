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
                }else{                                               // T.C = O(N) +  O(N), S.C = O(N)
                    idx = pointer;
                    break;
                }
            }

            StringBuilder word = new StringBuilder();

            for(int index = 0 ; index <= idx ; index++){
                char ch = s.charAt(index);

                if(index ==0 && ch == '0'){
                    continue;
                }

                word.append(ch);
            }
            return word.toString().replaceFirst("^0+","");
        }

    // ======================= Optimal Approach ===============================

        static String largestOddNumberInString_1(String s){
            
            int index = -1;
            int pointer = s.length()-1;
            while(pointer >= 0){
                char ch = s.charAt(pointer);
                int num = ch - '0';
                if(num % 2 == 0){
                    pointer--;                                      // T.C = O(N), S.C = O(1)
                }else{
                    index = pointer;
                    break;
                }
            }    
            return s.substring(0,index+1).replaceFirst("^0+","");
        }

    public static void main(String[] args) {
       String s = "5347";
       String result = largestOddNumberInString_1(s);
       System.out.println(result);
    }
}