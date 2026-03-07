
class Main {

    // ======================= Brute-Force Approach ===============================

        static String longestCommonPrefix(String[] s){

            int elementLength = s[0].length();
            
            if(elementLength == 0){
                return "";
            }

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

    // ======================= Optimal Approach ===============================

        static String longestCommonPrefix_1(String[] s){

            int elementLength = s[0].length();
            if(elementLength == 0){
                return "";
            }
            int length = s.length;
            Arrays.sort(s);

            int index = 0;
            int firstElementLength = s[0].length();
            int lastElementLength = s[length-1].length();                   // T.C = O(N Log (M+N)), S.C = O(1)

            int minLength = Math.min(lastElementLength,firstElementLength);

            while(index < minLength){
                char ch = s[0].charAt(index);
                char ch_1 = s[length-1].charAt(index);

                if(ch == ch_1){
                    index++;
                }else{
                    return s[0].substring(0,index);
                }
            }
            return s[0].substring(0,minLength);
        }
        
    public static void main(String[] args) {
       String[] strings = {"zebra", "zen", "zealot"};
       String[] strings_1 = {"zea", "zea", "zea"};
       String result = longestCommonPrefix_1(strings);
       System.out.println(result);
    }
}