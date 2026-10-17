// Problem Statement: You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
// You have to divide the intervals into one or more groups such that each interval is in exactly one group
// and no two intervals that are in the same group intersect each other.
// Return the minimum number of groups you need to make.
// Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.

// Example 1:

// Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
// Output: 3
// Explanation: We can divide the intervals into the following groups:
// - Group 1: [1, 5], [6, 8], Group 2: [2, 3], [5, 10], Group 3: [1, 10]. 
// It can be proven that it is not possible to divide the intervals into fewer than 3 groups.

// Example 2:

// Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
// Output: 1
// Explanation: None of the intervals overlap, so we can put all of them in one group.

class Main {

    // ============================ Brute Force Approach =================================== 

        public static int minimumGroups(int[][] intervals){

            int minNumberOfGroups = 0;

            for(int interval_1 = 0 ; interval_1 < intervals.length ; interval_1++){
                
                int possibleGroups = 0;
                int currentLeft = intervals[interval_1][0];

                for(int interval_2 = 0 ; interval_2 < intervals.length ; interval_2++){

                    if(currentLeft >= intervals[interval_2][0] && intervals[interval_2][1] >= intervals[interval_1][0]){
                        possibleGroups++;
                    }
                }
                minNumberOfGroups = Math.max(minNumberOfGroups, possibleGroups);
            }

            return minNumberOfGroups;
        }

        public static int minimumGroups_1(int[][] intervals){

        }

    public static void main(String[] args) {
        
        int[][] intervals = {{5, 10},{6, 8},{1, 5},{2, 3}, {1, 10}};

        int result = minimumGroups(intervals);

        System.out.println(result);
        
        int result_1 = minimumGroups_1(intervals);

        System.out.println(result_1);
    }
}