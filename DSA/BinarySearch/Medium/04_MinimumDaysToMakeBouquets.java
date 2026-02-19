// Problem Statement: You are given 'N’ roses and you are also given an array 'arr' where 'arr[i]' denotes that the 'ith' rose will bloom on the 'arr[i]th' day. 
// You can only pick already bloomed roses that are adjacent to make a bouquet. 
// You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet. 
// Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses. Return -1 if it is not possible.


import java.util.*;

class Main {
    
    // =========================== Brute Force Approach ==============================

        static boolean possibleDay(int[] days, int day, int m , int k){

            int length = days.length;
            int countOfRoses = 0;
            int totalBouquets = 0; 

            for(int index = 0 ; index < length ; index++){
                if(days[index] <= day){
                    countOfRoses++;
                }else{
                    totalBouquets += (countOfRoses/k);
                    countOfRoses = 0;
                }
            }
            totalBouquets += (countOfRoses/k);

            if(totalBouquets>=m) return true;
            return false;
        }

        static int minimumNumberOfDays(int[] days,int m, int k){        // T.C = O((Max-Min)+1) * O(N) , S.C = O(1)

            int length = days.length;
            int minRosesRequired = m*k;

            if(length < minRosesRequired){
                return -1;
            }

            int minimumDay = Arrays.stream(days).min().getAsInt();
            int maximumDay = Arrays.stream(days).max().getAsInt();

            for(int day = minimumDay ; day <= maximumDay ; day++){
                if(possibleDay(days,day,m,k) == true){
                    return day;
                }
            }
            return -1;
        }
    
    // =========================== Optimal Approach ==============================

        static boolean possibleDay_1(int[] days, int day, int m , int k){
        
            int length = days.length;
            int countOfRoses = 0;
            int totalBouquets = 0; 

            for(int index = 0 ; index < length ; index++){
                if(days[index] <= day){
                    countOfRoses++;
                }else{
                    totalBouquets += (countOfRoses/k);
                    countOfRoses = 0;
                }
            }
            totalBouquets += (countOfRoses/k);                            // T.C = O(log(Max-Min)+1) * O(N) , S.C = O(1)

            if(totalBouquets>=m) return true;
            return false;
        }
    
        static int minimumNumberOfDays_1(int[] days,int m, int k){

            int length = days.length;
            long minRosesRequired = (long) m*k;
            int result = -1;

            if(length < minRosesRequired){
                return -1;
            }

            int low = Arrays.stream(days).min().getAsInt();
            int high = Arrays.stream(days).max().getAsInt();

            while(low <= high){
                int mid = low + ((high-low)/2);
                if(possibleDay(days,mid,m,k) == true){
                    result = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return result;
        }

    public static void main(String[] args) {

        int[] days = {7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2;
        int k = 3;
        int result = minimumNumberOfDays(days,m,k);
        System.out.println(result);
    }
}