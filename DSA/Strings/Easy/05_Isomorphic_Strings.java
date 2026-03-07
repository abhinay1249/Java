class Main{

    // ======================= Brute-Force Approach ===============================

        static boolean isIsomorphic(String s, String t) {
            int firstLength = s.length();
            int secondLength = t.length();

            for(int index = 0 ; index < firstLength ; index++){
                for(int character = index+1 ; character < secondLength ; character++){
                    char firstCharacter_s = s.charAt(index);
                    char secondCharacter_s = s.charAt(character);
                    char firstCharacter_t = t.charAt(index);
                    char secondCharacter_t = t.charAt(character);           // T.C = O(N^2), S.C = O(1)

                    if(firstCharacter_s == secondCharacter_s){
                        if(firstCharacter_t != secondCharacter_t){
                            return false;
                        }
                    }else{
                        if(firstCharacter_t == secondCharacter_t){
                            return false;
                        }
                    }
                }
            }
            return true;
        }

    public static void main(String[] args){
        String s = "kite";
        String t = "tart";
        boolean result = isIsomorphic(s,t);
        
        System.out.println(result);

    }
}