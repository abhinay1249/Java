// Problem Statement: You are given a string s and a positive integer k.
// Return the number of substrings that contain exactly k distinct characters.

// Example 1:

// Input:
//  s = "pqpqs", k = 2  
// Output:
//  7  
// Explanation:
//   All substrings with exactly 2 distinct characters:  
// "pq", "pqp", "pqpq", "qp", "qpq", "pqs", "qs"  
// Total = 7.

// Example 2:
// Input:
//  s = "abcbaa", k = 3  
// Output:
//  5  
// Explanation:
//   All substrings with exactly 3 distinct characters:  
// "abc", "abcb", "abcba", "bcba", "cbaa"  
// Total = 5.


class Main {
    
    // ======================= Optimal Approach ===============================

        public static int atmost(String s, int k){

            int length = s.length();

            int[] nums = new int[26];

            int distinct = 0, left = 0;
            int atmostPossible = 0;

            for(int index = 0 ; index < length ; index++){
                char ch = s.charAt(index);

                nums[ch - 'a']++;

                if(nums[ch - 'a'] == 1){
                    distinct++;                                         // T.C = O(N), S.C = O(1)
                }

                while(distinct > k){
                    char leftch = s.charAt(left);

                    nums[leftch - 'a']--;

                    if(nums[leftch - 'a'] == 0){
                        distinct--;
                    }
                    left++;
                }
                atmostPossible += (index - left +1);
            }
            return atmostPossible;
        }

        public static int countNumberOfStrings(String s, int k){
            return atmost(s,k) - atmost(s,k-1);
        }

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        int result = countNumberOfStrings(s,k);
        System.out.println(result);
    }
}