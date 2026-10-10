// Problem Statement : You are given an array intervals where intervals[i] = [startᵢ, endᵢ] represents the inclusive interval startᵢ ≤ x ≤ endᵢ.
// Your task is to merge every pair of intervals that overlap and return all the non-overlapping intervals that completely cover the same ranges as the original array.
// Two intervals overlap if they share at least one common point (i.e. start₂ ≤ end₁ and start₁ ≤ end₂).
// Return the merged intervals in any order.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: [1,3] and [2,6] overlap --> merge to [1,6].

// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Because the end of [1,4] equals the start of [4,5], they are considered overlapping.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    // ============================= Brute Force Approach ==================================

        public static int[][] mergeIntervals(int[][] intervals){
        
            int length = intervals.length;
        
            if(length == 1) return intervals;
        
            List<List<Integer>> mergedIntervals = new ArrayList<>();
        
            Arrays.sort(intervals, (start, end) -> Integer.compare(start[0], end[0]));
        
            for(int interval_1 = 0; interval_1 < length ; interval_1++){
                int start = intervals[interval_1][0];
                int end = intervals[interval_1][1];                                 // T.C = O(N Log N) + O(N^2), S.C = O(N)
            
                if(!mergedIntervals.isEmpty()){
                    List<Integer> lastInterval = mergedIntervals.get(mergedIntervals.size()-1);
                    if(lastInterval.get(1) >= end){
                        continue;
                    }
                }
            
                for(int interval_2 = interval_1+1 ; interval_2 < length ; interval_2++){
                
                    if(end >= intervals[interval_2][0]){
                        end = Math.max(end, intervals[interval_2][1]);
                    }else{
                        break;
                    }

                }

                mergedIntervals.add(Arrays.asList(start, end));
            
            }
        
            return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        
        }

    public static void main(String[] args) {
        
    }
}