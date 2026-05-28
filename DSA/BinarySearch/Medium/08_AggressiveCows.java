// Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls. 
// You are also given an integer 'k' which denotes the number of aggressive cows.
// You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible. 
// Find the maximum possible minimum distance.

// Example 1:

// Input Format: N = 6, k = 4, arr[] = {0,3,4,7,10,9}
// Result: 3
// Explanation: The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}.
// Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

// Example 2:

// Input Format: N = 5, k = 2, arr[] = {4,2,1,3,6}
// Result: 5
// Explanation: The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}. 

import java.util.*;

class Main {
    
    // =========================== Brute Force Approach ==============================    

        private static boolean possibleCows(int[] stalls,int distance,int cows){

            int countOfCows = 1;
            int lastCow = stalls[0];
            int length = stalls.length;

            for(int index = 1 ; index < length ; index++){

                if(stalls[index]-lastCow >= distance){
                    countOfCows++;
                    lastCow = stalls[index];                            
                }
                if(countOfCows >= cows){
                    return true;
                }
            }
            return false;
        }

        public static int maxPossibleOfMinDistance(int[] stalls, int cows){
            int length = stalls.length;

            if(cows <= 1) return -1;

            Arrays.sort(stalls);

            int min = stalls[0];
            int max = stalls[length-1];                                // T.C = O(N log N) + O(max-min) * O(N) , S.C = O(1)

            if(cows == 2){
                return (max-min);
            }

            for(int distance = 1 ; distance <= (max-min) ; distance++){

                if(possibleCows(stalls,distance,cows)==true){
                    continue;
                }else{
                    return (distance-1);
                }
            }
            return -1;
        }

    // =========================== Optimal Approach ==============================

        private static boolean possibleCows_1(int[] stalls,int distance,int cows){
        
            int countOfCows = 1;
            int lastCow = stalls[0];
            int length = stalls.length;

            for(int index = 1 ; index < length ; index++){

                if(stalls[index]-lastCow >= distance){
                    countOfCows++;
                    lastCow = stalls[index];
                }
                if(countOfCows >= cows){
                    return true;
                }
            }
            return false;
        }
        
        static int maxPossibleOfMinDistance_1(int[] stalls, int cows){
            int length = stalls.length;

            if(cows <= 1) return -1;

            Arrays.sort(stalls);

            int min = stalls[0];                                      // T.C = O(N log N) + O(log(max-min)) * O(N) , S.C = O(1)
            int max = stalls[length-1];

            int low = 1, high = (max-min);

            if(cows == 2){
                return (max-min);
            }

            while(low <= high){
                int mid = (low  + (high-low)/2);

                if(possibleCows_1(stalls,mid,cows)==true){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return high;
        }
    
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int cows = 3;
        int result = maxPossibleOfMinDistance(stalls,cows);
        System.out.println(result);
    }
}