// Problem Statement : Given the arrival and departure times of all trains reaching a particular railway station, 
// determine the minimum number of platforms required so that no train is kept waiting. 
// Consider all trains arrive and depart on the same day.

// In any particular instance, the same platform cannot be used for both the departure of one train and the arrival of another train,
// necessitating the use of different platforms in such cases.
// Note: Time intervals are in the minutes , Leading zeros for minutes less than 1000 are optional (e.g., 0900 is the same as 900).

// Example 1:

// Input : Arrival = [900, 940, 950, 1100, 1500, 1800] , Departure = [910, 1200, 1120, 1130, 1900, 2000]
// Output : 3
// Explanation : The first , second , fifth number train can use the platform 1.
// The third and sixth train can use the platform 2. The fourth train will use platform 3.
// So total we need 3 different platforms for the railway station so that no train is kept waiting.

// Example 2:

// Input : Arrival = [900, 1100, 1235] , Departure = [1000, 1200, 1240]
// Output : 1
// Explanation : All the three trains can use the platform 1. So we required only 1 platform.

import java.util.Arrays;

class Main {

    // ============================ Brute Force Approach ===================================

        public static int minimumNumberOfPlatforms(int[] arrivals, int[] departures){

            int arrivalLength = arrivals.length;
            int departureLength = departures.length;

            int minimumPlatforms = 0;

            for(int interval_1 = 0 ; interval_1 < arrivalLength ; interval_1++){
                
                int platformCount = 0;                                                  
                
                for(int interval_2 = 0 ; interval_2 < departureLength ; interval_2++){
                    if(arrivals[interval_1] >= arrivals[interval_2] && departures[interval_2] >= arrivals[interval_1]){
                        platformCount++;
                    }
                }

                minimumPlatforms = Math.max(platformCount, minimumPlatforms);                       // T.C = O(N^2), S.C = O(1)

            }

            return minimumPlatforms;

        }

    // ============================ Greedy Algorithm Approach =================================

        public static int minimumNumberOfPlatforms_1(int[] arrivals, int[] departures){

            int length = arrivals.length;
        
            int arrivalPtr = 0;
            int deptPtr = 0;

            int possiblePlatforms = 0, minimumPlatforms = 0;

            Arrays.sort(arrivals);
            Arrays.sort(departures);


            while(arrivalPtr < length && deptPtr < length){
                if(arrivals[arrivalPtr] <= departures[deptPtr]){
                    possiblePlatforms++;                                    // T.C = O(N)
                    arrivalPtr+=1;

                }else{
                    possiblePlatforms--;
                    deptPtr+=1;                                                 
                }

                minimumPlatforms = Math.max(possiblePlatforms, minimumPlatforms);
            }

            return minimumPlatforms;

        }

    public static void main(String[] args) {
        
        int[] arrivals = {900, 940, 950, 1100, 1500, 1800};
        int[] departures = {910, 1200, 1120, 1130, 1900, 2000};

        int result = minimumNumberOfPlatforms(arrivals, departures);

        System.out.println(result);

        int result_1 = minimumNumberOfPlatforms_1(arrivals, departures);

        System.out.println(result_1);

    }
}
