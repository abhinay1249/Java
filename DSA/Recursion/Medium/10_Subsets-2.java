// Problem Statement: Given an integer array nums, which can have duplicate entries, provide the power set. 
// Duplicate subsets cannot exist in the solution set. Return the answer in any sequence.  

// Example 1:

// Input: array[] = [1,2,2]
// Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]
// Explanation: We can have subsets ranging from  length 0 to 3. which are listed above. 
// Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.

// Example 2:

// Input: array[] = [1]
// Output: [ [ ], [1] ]
// Explanation: Only two unique subsets are available.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main{

    // =================================== Brute Force Approach =======================================
    
        private static Set<List<Integer>> recursiveSubsets(int index, Set<List<Integer>> hs, int[] nums, List<Integer> ds){

            if(index == nums.length){
                List<Integer> sortedList = new ArrayList<>(ds);
                Collections.sort(sortedList);
                hs.add(sortedList);
                return hs;
            }

            ds.add(nums[index]);
            recursiveSubsets(index+1, hs, nums, ds);
            ds.remove(ds.size()-1);
            recursiveSubsets(index+1, hs, nums, ds);

            return hs;                                                        // T.C = O(2^N * N LOG N), S.C = O(N * 2^N)

        }

        public static void subsetsWithDup(int[] nums) {

            int index = 0;
            Set<List<Integer>> hs = new HashSet<>();

            List<Integer> ds = new ArrayList<>();

            recursiveSubsets(index, hs, nums, ds);

            List<List<Integer>> al = new ArrayList<>(hs);

            System.out.println(al);        
        }

    // =================================== Optimal Approach =======================================


        private static List<List<Integer>> recursiveSubsets_1(int index, List<List<Integer>> al, int[] nums, List<Integer> ds){

            al.add(new ArrayList<>(ds));

            for(int i = index ; i < nums.length ; i++){
                
                if(i != index && nums[i] == nums[i-1]){
                    continue;
                }

                ds.add(nums[i]);
                recursiveSubsets_1(i+1, al, nums, ds);              
                ds.remove(ds.size()-1);

            }

            return al;

        }
    
        public static void subsetsWithDup_1(int[] nums) {

            int index = 0;

            List<List<Integer>> al = new ArrayList<>();

            List<Integer> ds = new ArrayList<>();

            Arrays.sort(nums);

            recursiveSubsets_1(index, al, nums, ds);

            System.out.println(al);        
        }

    public static void main(String[] args){

        int[] nums = {1,2,2,3,2,3};

        subsetsWithDup(nums);

        subsetsWithDup_1(nums);

    }
}
 