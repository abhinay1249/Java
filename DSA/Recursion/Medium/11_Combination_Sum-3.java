// Problem Statement: Determine all possible set of k numbers that can be added together to equal n while meeting the following requirements:

// 1. There is only use of numerals 1 through 9.
// 2. A single use is made of each number.

// Return list of every feasible combination that is allowed. 
// The combinations can be returned in any order, but the list cannot have the same combination twice.

// Example 1:

// Input: k = 3, n = 7
// Output: [[1, 2, 4]]
// Explanation: 1 + 2 + 4 = 7. There are no other valid combinations.

// Example 2:

// Input: k = 3, n = 9
// Output: [[1, 2, 6],[1, 3, 5],[2, 3, 4]]
// Explanation: 1 + 2 + 6 = 9, 1 + 3 + 5 = 9, 2 + 3 + 4 = 9. There are no other valid combinations.


import java.util.ArrayList;
import java.util.List;

class Main{

    private List<List<Integer>> recursiveCombination3(int index, List<List<Integer>> al, int sum, int counter, int k, int n, List<Integer> ds){

        if(n < sum || index > 9){
            return al;
        }

        if(ds.size() > k) return al;

        if(counter == k){
            if(sum == n){
                al.add(new ArrayList<>(ds));
                return al;
            }else{
                return al;
            }
        }

        ds.add(index);
        recursiveCombination3(index+1, al, sum + index, counter+1, k, n, ds);
        ds.remove(ds.size()-1);
        recursiveCombination3(index+1, al, sum, counter, k, n, ds);

        return al;

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        int index = 1;
        List<List<Integer>> al = new ArrayList<>();
        int sum = 0, counter = 0;

        recursiveCombination3(index, al, sum, counter, k, n, new ArrayList<>());

        return al;
        
    }
    public static void main(String[] args) {
        
        int  k = 3;
        int n = 9;

        combinationSum3(k, n);
    }
}