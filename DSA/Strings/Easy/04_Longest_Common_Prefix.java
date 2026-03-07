
class Main {

    // ======================= Brute-Force Approach ===============================

        static String longestCommonPrefix(String[] s){

            int elementLength = s[0].length();
            int length = s.length;
            StringBuilder prefix = new StringBuilder();                 // T.C = O(N * M) , S.C = O(Characters)=O(M)

            for(int character = 0 ; character < elementLength ; character++){
                char ch = s[0].charAt(character);

                for(int strings = 1 ; strings < length ; strings++){
                   if(character >= s[strings].length() || s[strings].charAt(character) != ch){
                        return prefix.toString();
                    }
                }
                prefix.append(ch);                      
            }
            return prefix.toString();
        }

    public static void main(String[] args) {
       String[] strings = {"flower", "flow", "flight"};
       String result = longestCommonPrefix(strings);
       System.out.println(result);
    }
}