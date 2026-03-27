// Problem Statement: You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.
// If two or more characters have same frequency then arrange them in alphabetic order.

// Example 1:
// Input:
//  s = "tree"
// Output:
//  ['e', 'r', 't']
// Explanation:

// e → 2
// r → 1
// t → 1
// Since 'r' and 't' have the same frequency, they are sorted alphabetically → 'r' comes before 't'.

// Example 2:
// Input:
//  s = "raaaajj"
// Output:
//  ['a', 'j', 'r']
// Explanation:

// a → 4
// j → 2
// r → 1
// Characters are sorted by decreasing frequency. In case of ties, alphabetically.




import java.util.*;

class Main{

    // ======================= Brute-Force Approach ===============================

        static String sortCharactersByFrequency(String s){

            Map<Character,Integer> charCount = new HashMap<>();

            int length = s.length();

            for(int index = 0 ; index < length ; index++){
                char ch = s.charAt(index);
                charCount.put(ch,charCount.getOrDefault(ch,0)+1);            // T.C = O(N)+O(K)+O(K LOG K)+O(N), S.C = O(K)+O(K)+O(N) 
            }

            List<Map.Entry<Character,Integer>> chars = new ArrayList<>(charCount.entrySet());

            Collections.sort(chars, (charCount_1,charCount_2) -> charCount_2.getValue().compareTo(charCount_1.getValue()));

            StringBuilder word = new StringBuilder();

            for(Map.Entry<Character,Integer> letters : chars){
                int letterCount = letters.getValue();
                for(int number = 0 ; number < letterCount ; number++){
                    word.append(letters.getKey());
                }
            }

            return word.toString();

        }

    // ======================= Optimal Approach [BUCKET SORT ALGORITHM ] ===============================

        static String sortCharactersByFrequency_1(String s){

            int length = s.length();

            Map<Character,Integer> charCount = new HashMap<>();

            for(char ch : s.toCharArray()){
                charCount.put(ch,charCount.getOrDefault(ch,0)+1);  
            }

            List<Character>[] buckets = new ArrayList[length+1];

            for(int index = 0 ; index <= length ; index++){
                buckets[index] = new ArrayList<>();                             // T.C = O(N), S.C = O(N)
            }

            for(Map.Entry<Character,Integer> chars : charCount.entrySet()){
                char ch = chars.getKey();
                int count = chars.getValue();

                buckets[count].add(ch);
            }

            StringBuilder word = new StringBuilder();

            for(int index = length; index >= 1 ; index--){
                for(char ch : buckets[index]){
                
                    for(int count = 0 ; count < index ; count++){
                        word.append(ch);
                    }
                }
            }

            return word.toString();
        } 

    public static void main(String[] args){
        String s = "Aabb";
        String result = sortCharactersByFrequency_1(s);
        System.out.println(result);
    }
}