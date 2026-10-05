// Problem Statement: Given one meeting room and N meetings represented by two arrays, start and end, 
// where start[i] represents the start time of the ith meeting and end[i] represents the end time of the ith meeting, 
// determine the maximum number of meetings that can be accommodated in the meeting room if only one meeting can be held at a time.
// A meeting starting at the same time another meeting ends is considered overlapping.

// Example 1:

// Input : Start = [1, 3, 0, 5, 8, 5] , End = [2, 4, 6, 7, 9, 9]
// Output : 4
// Explanation : The meetings that can be accommodated in meeting room are (1,2) , (3,4) , (5,7) , (8,9).

// Example 2:

// Input : Start = [10, 12, 20] , End = [20, 25, 30]
// Output : 1
// Explanation : Given the start and end time, only one meeting can be held in meeting room.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Meetings{
    int start;
    int end;
    int position;

    Meetings(int s, int e, int p){
        this.start = s;
        this.end = e;
        this.position = p;
    }
}

class Main {

    // ============================== Greedy Algorithm Approach - 1 ================================

        public static int meetingsInOneRoom(int[] start, int[] end){

            int[][] meetings = new int[start.length][3];

            for(int index = 0 ; index < start.length ; index++){
                meetings[index][0] = start[index];
                meetings[index][1] = end[index];
                meetings[index][2] = index + 1;                                 // T.C = , S.C = 
            }

            Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));               

            int countOfMeetings = 0, freeTime = 0;

            for(int[] meeting : meetings){
                if(meeting[0] > freeTime){
                    freeTime = meeting[1];
                    countOfMeetings+=1;
                }
            }

            return countOfMeetings;

        }

    // ============================== Greedy Algorithm Approach - 2 ================================

        public static List<Integer> meetingsInOneRoom_1(int[] start, int[] end){
        
            Meetings[] meet = new Meetings[start.length];

            for(int index = 0 ; index < start.length ; index++){
                meet[index] = new Meetings(start[index], end[index], index+1);
            }

            Arrays.sort(meet, (a,b) -> Integer.compare(a.end,b.end));

            int countOfJobs = 0, freeTime = 0;                                      // T.C = , S.C = 

            List<Integer> jobPositions = new ArrayList<>();

            for(Meetings meeting : meet){
                if(meeting.start >= freeTime){
                    jobPositions.add(meeting.position);
                    freeTime = meeting.end;
                    countOfJobs++;
                }
            }
            return jobPositions;
        }
    public static void main(String[] args) {
        
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        
        int result = meetingsInOneRoom(start, end);

        System.out.println(result);

        List<Integer> result_1 = meetingsInOneRoom_1(start, end);

        System.out.println(result_1);

    }
}