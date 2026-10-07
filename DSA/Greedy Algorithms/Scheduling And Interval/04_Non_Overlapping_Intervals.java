// Problem Statement: Given an array of N intervals in the form of (start[i], end[i]), 
// where start[i] is the starting point of the interval and end[i] is the ending point of the interval, 
// return the minimum number of intervals that need to be removed to make the remaining intervals non-overlapping.

// Note: Intervals which only touch at a point are also considered as non-overlapping. For example, [1, 3] and [3, 4] are non-overlapping.


// Example 1:

// Input : Intervals = [ [1, 2] , [2, 3] , [3, 4] ,[1, 3] ]
// Output : 1
// Explanation : You can remove the interval [1, 3] to make the remaining interval non overlapping.

// Example 2:

// Input : Intervals = [ [1, 3] , [1, 4] , [3, 5] , [3, 4] , [4, 5] ]
// Output : 2
// Explanation : You can remove the intervals [1, 4] and [3, 5] and the remaining intervals becomes non overlapping.

import java.util.Arrays;

class Main{

    public static int nonOverlappingIntervals(int[][] intervals){

        int minIntervals = 0, endTime = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] interval : intervals){
            if(interval[0] >= endTime){
                endTime = interval[1];
            }else{
                endTime = Math.min(endTime, interval[1]);
                minIntervals++;
            }
        }

        return minIntervals;

    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        int result = nonOverlappingIntervals(intervals);

        System.out.println(result);
        
    }
}