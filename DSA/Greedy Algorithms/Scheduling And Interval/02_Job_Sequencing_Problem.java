// Problem Statement: Given an 2D array Jobs of size Nx3, 
// where Jobs[i][0] represents JobID , Jobs[i][1] represents Deadline , Jobs[i][2] represents Profit associated with that job.
// Each Job takes 1 unit of time to complete and only one job can be scheduled at a time.
// The profit associated with a job is earned only if it is completed by its deadline. Find the number of jobs and maximum profit.

// Example 1:

// Input : Jobs = [ [1, 4, 20] , [2, 1, 10] , [3, 1, 40] , [4, 1, 30] ]
// Output : 2 60
// Explanation : Job with JobID 3 can be performed at time t=1 giving a profit of 40.
// Job with JobID 1 can be performed at time t=2 giving a profit of 20. No more jobs can be scheduled, So total Profit = 40 + 20 => 60.
// Total number of jobs completed are two, JobID 1, JobID 3. So answer is 2 60.

// Example 2:

// Input : Jobs = [ [1, 2, 100] , [2, 1, 19] , [3, 2, 27] , [4, 1, 25] , [5, 1, 15] ]
// Output : 2 127
// Explanation : Job with JobID 1 can be performed at time time t=1 giving a profit of 100.
// Job with JobID 3 can be performed at time t=2 giving a profit of 27. No more jobs can be scheduled, So total Profit = 100 + 27 => 127.
// Total number of jobs completed are two, JobID 1, JobID 3. So answer is 2 127.

import java.util.Arrays;

class Main {

    // ============================== Greedy Algorithm Approach - 1 ==================================

        public static int[] jobSequencing(int[][] jobs){

            int maxDeadline = 0;

            for(int index = 0 ; index < jobs.length ; index++){
                maxDeadline = Math.max(maxDeadline, jobs[index][2]);
            }

            Arrays.sort(jobs, (a, b) -> Integer.compare(b[2],a[2]));

            boolean[] hash = new boolean[maxDeadline+1];

            int maxProfit = 0, noOfJobs = 0;

            for(int row = 0 ; row < jobs.length ; row++){                   // T.C = O(N) + O(N Log N) + O(N*D), S.C = O(D)

                int deadline = jobs[row][1];                                // where D is maxDeadline
                int profit = jobs[row][2];  

                for(int col = deadline ; col >= 1 ; col--){
                    if(!hash[col]){
                        hash[col]=true;
                        noOfJobs++;
                        maxProfit+=profit;
                        break;
                    }
                }
            }

            return new int[]{noOfJobs, maxProfit};

        }

    // ============================== Greedy Algorithm Approach - 2 ==================================

    public static void main(String[] args) {
        
        int[][] jobs = {{1,2,100}, {2,1,19}, {3,2,27}, {4,1,25},{5,1,15}};

        int[] result = jobSequencing(jobs);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}