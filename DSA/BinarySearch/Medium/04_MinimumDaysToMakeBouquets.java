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
    public static void main(String[] args) {
        int[] days = {7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2;
        int k = 3;
        int result = minimumNumberOfDays(days,m,k);
        System.out.println(result);
    }
}