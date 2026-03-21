// Given a string s, return the longest palindromic substring in s.
// A palindromic substring is a contiguous sequence of characters within the string that reads the same forward and backward.

class Main {

    // ======================= Brute-Force Approach ===============================
    
        static String longestPalindromeSubstring(String s){

            int length = s.length();

            if(length == 1){
                return s;
            }

            String lps = "";

            for(int index = 1 ; index < length ; index++){
                int low = index;
                int high = index;

                while(s.charAt(low) == s.charAt(high)){
                    low--;
                    high++;

                    if(low == -1 || high == length){                        // T.C = O(N^2), S.C = O(1)
                        break;
                    }
                }

                String palindrome = s.substring(low+1,high);
                if(palindrome.length() > lps.length()){
                    lps = palindrome;
                }

                low = index - 1;
                high = index;

                while(s.charAt(low) == s.charAt(high)){
                    low--;
                    high++;

                    if(low == -1 || high == length){
                        break;
                    } 
                }

                palindrome = s.substring(low+1,high);
                if(palindrome.length() > lps.length()){
                    lps = palindrome;
                }
            }
            return lps;
        }
    
    public static void main(String[] args) {
        String s = "aaaa";
        String result = longestPalindromeSubstring(s);
        StringBuilder ans = new StringBuilder(result);
        System.out.println(ans);
    }
}