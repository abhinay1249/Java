// Problem Statement: Given a 2D array Intervals, where Intervals[i] = [start[i], end[i]] 
// represents the start and end of the ith interval, the array represents non-overlapping intervals sorted in ascending order by start[i]. 

// Given another array newInterval, where newInterval = [start, end] represents the start and end of another interval,
// merge newInterval into Intervals such that Intervals remain non-overlapping and sorted in ascending order by start[i].

// Return Intervals after the insertion of newInterval.

// Example 1:

// Input : Intervals = [ [1, 3] , [6, 9] ] , newInterval = [2, 5]
// Output : [ [1, 5] , [6, 9] ]
// Explanation : After inserting the newInterval the Intervals array becomes [ [1, 3] , [2, 5] , [6, 9] ].
// So to make them non overlapping we can merge the intervals [1, 3] and [2, 5]. So the Intervals array is [ [1, 5] , [6, 9] ].

// Example 2:

// Input : Intervals = [ [1, 2] , [3, 5] , [6, 7] , [8,10] ] , newInterval = [4, 8]
// Output : [ [1, 2] , [3, 10] ]
// Explanation : The Intervals array after inserting newInterval is [ [1, 2] , [3, 5] , [4, 8] , [6, 7] , [8, 10] ].
// We merge the required intervals to make it non overlapping. So final array is [ [1, 2] , [3, 10] ].

import java.util.*;

class Main {

        public static int[][] insertInterval(int[][] intervals, int[] newInterval){
        
            int index = 0;

            List<int[]> timeIntervals = new ArrayList<>();

            int length = intervals.length;

            while(index < length && intervals[index][1] < newInterval[0]){
                timeIntervals.add(intervals[index]);
                index+=1;
            }

            while(index < length && intervals[index][0] <= newInterval[1]){
                newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[index][1]);

                index+=1;
            }
            
            timeIntervals.add(intervals[index]);

            while(index < length){
                timeIntervals.add(intervals[index]);
                index+=1;
            }

            int[][] newIntervals = new int[timeIntervals.size()][2];

            for(int timeIntervalIndex = 0 ; timeIntervalIndex < timeIntervals.size() ; timeIntervalIndex++){
                newIntervals[timeIntervalIndex] = timeIntervals.get(timeIntervalIndex);
            }
        
        }

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] newIntervals = insertInterval(intervals, newInterval);
        
    }
}
