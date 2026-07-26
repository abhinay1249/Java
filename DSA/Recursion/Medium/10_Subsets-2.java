// Problem Statement: Given an integer array nums, which can have duplicate entries, provide the power set. 
// Duplicate subsets cannot exist in the solution set. Return the answer in any sequence.  





import java.util.*;

class Main{
    
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

        return hs;

    }


    public static void subsetsWithDup(int[] nums) {

        int index = 0;
        Set<List<Integer>> hs = new HashSet<>();

        List<Integer> ds = new ArrayList<>();

        recursiveSubsets(index, hs, nums, ds);

        List<List<Integer>> al = new ArrayList<>(hs);

        System.out.println(al);        
    }

    public static void main(String[] args){

        int[] nums = {1,2,2};

        subsetsWithDup(nums);

    }
}
 