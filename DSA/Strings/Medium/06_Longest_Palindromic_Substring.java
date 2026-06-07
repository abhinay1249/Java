// Given a string s, return the longest palindromic substring in s.
// A palindromic substring is a contiguous sequence of characters within the string that reads the same forward and backward.

// Example 1

// Input: s = "babad"
// Output: "bab"
// Explanation: Both "bab" and "aba" are valid palindromic substrings of length 3. Return either.

// Example 2

// Input: s = "cbbd"
// Output: "bb"
// Explanation: The longest palindrome is "bb" of length 2.


class Main {

    // ======================= Brute-Force Approach ===============================

        private static boolean isPalindrome(String s, int left, int right){

            while(left < right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    
        public static String longestPalindromeSubstring(String s){

            int length = s.length();

            if(length == 1){                                                    // T.C = O(N^2) * O(N/2), S.C = O(1)
                return s;
            }

            String resultString = "";

            for(int index = 1 ; index < length ; index++){
                for(int j = index ; j < length ; j++){
                    String substring = s.substring(index-1,j+1);
                    if(isPalindrome(s,index,j) && substring.length() > resultString.length()){
                        resultString = s.substring(index,j+1);
                    }
                }
            }
            return resultString;
        }

    // ======================= Better Approach ===============================

        private static int expand(String s, int left, int right){

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            return right - left - 1;
        }
    
        public static String longestPalindromeSubstring_1(String s){
            int length = s.length();

            if(length == 1){                                                    // T.C = O(N^2), S.C = O(1)
                return s;
            }

            int start = 0, end = 0;

            for(int index = 0 ; index < length ; index++){
                int odd = expand(s,index,index);
                int even = expand(s,index,index+1);
                int maxLength = Math.max(odd,even);

                if(maxLength > end - start + 1){
                    start = index - (maxLength - 1) / 2;
                    end = index + maxLength / 2;
                }
            }
            return s.substring(start,end+1);
        }
    
    // ======================== Optimal Approach ===============================

        public static String longestPalindromeSubstring_2(String s){

            int length = s.length();
        
            StringBuilder newString = new StringBuilder("#");

            for(int index = 0 ; index < length ; index++){
                char ch = s.charAt(index);
                newString.append(ch);
                newString.append('#');
            }

            int center = 0, rightBoundary = 0;              // T.C = O(N), S.C = O(N)

            int[] p = new int[newString.length()];

            int longestCenter = 0, longestLength = 0;

            for(int index = 0 ; index < newString.length() ; index++){

                int mirror = 2 * center - index;

                if(index < rightBoundary){
                    p[index] = Math.max(0,Math.min(rightBoundary - index,p[mirror]));
                }

                int left = index - (p[index] + 1);
                int right = index + (p[index] + 1);

                while(left >=0 && right < newString.length() && newString.charAt(left) == newString.charAt(right)){
                    left--;
                    right++;
                    p[index]++;
                }


                if(p[index] >= longestLength){
                    longestCenter = index;
                    longestLength = p[index];
                }

                if(index + p[index] > rightBoundary){
                    center = index;
                    rightBoundary = index + p[index];
                }

            }

            int start = (longestCenter - longestLength) / 2;
            
            return s.substring(start, start + longestLength);
            
            // return newString.substring(longestCenter - longestLength, longestCenter + longestLength).replace("#","");
            
        }


    public static void main(String[] args) {
        String s = "aaaa";
        String result = longestPalindromeSubstring(s);
        StringBuilder ans = new StringBuilder(result);
        System.out.println(ans);
    }
}