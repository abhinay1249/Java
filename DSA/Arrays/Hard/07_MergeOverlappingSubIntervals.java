// Problem Statement: Given an array of intervals where intervals[i] = [starti, endi], 
// merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.


import java.util.*;


class Main{


    // ==================================== Brute Force Approach ===========================================

        static  List<List<Integer>> mergeOverlapIntervals(int[][]nums){
        
            int length = nums.length;
            List<List<Integer>> mergeInterval = new ArrayList<>();

            if(length == 0) return mergeInterval;

            if(length == 1){
                mergeInterval.add(Arrays.asList(nums[0][0],nums[0][1]));
            }

            Arrays.sort(nums, (left,right) -> Integer.compare(left[0],right[0]));                        

            for(int idx_1 = 0 ; idx_1 < length ; idx_1++){                              //T.C = O(N LOG N) + O(2N), S.C = O(N)
                int start = nums[idx_1][0];
                int end = nums[idx_1][1];

                if(!mergeInterval.isEmpty()){
                    List<Integer> lastMerged = mergeInterval.get(mergeInterval.size()-1);
                    if(lastMerged.get(1) >= end){
                        continue;
                    }
                }
                for(int idx_2 = idx_1+1 ; idx_2 < length ; idx_2++){
                    if(end>=nums[idx_2][0]){
                        end = Math.max(end, nums[idx_2][1]);
                    }else{
                        break;
                    }
                }
                mergeInterval.add(Arrays.asList(start,end));
            }
            return mergeInterval;
        }

    public static void main(String[] args) {

        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        List<List<Integer>> res = mergeOverlapIntervals(nums);
        for(List<Integer> value: res){
            System.out.println(value);   
        }
    }
}