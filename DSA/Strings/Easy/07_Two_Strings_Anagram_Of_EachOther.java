// Problem Statement: Given two strings, check if two strings are anagrams of each other or not.


class Main{

    // ======================= Brute-Force Approach ===============================

        static boolean validateStringsAsAnagram(String s1, String s2){
            int sLength = s.length();
            int tLength = t.length();

            if(sLength != tLength){
                return false;
            }

            char[] arr = s.toCharArray();
            char[] arr_1 = t.toCharArray();

            Arrays.sort(arr);
            Arrays.sort(arr_1);                                         // T.C = O(2 N Log N) + O(N), S.C = O(N)

            String word = new String(arr);
            String word_1 = new String(arr_1);

            int index_1 = 0, index_2 = 0;

            while(index_1 < sLength && index_2 < tLength){
                char ch = word.charAt(index_1);
                char sh = word_1.charAt(index_2);

                if(ch != sh){
                    return false;
                }
                index_1++;
                index_2++;
            }
            return true;                        
        }

    public static void main(String[] args){
        String s = "caac";
        String t = "ccaa";
        boolean result = twoStringsAnagram(s,t);
        System.out.println(result);
    }
}
