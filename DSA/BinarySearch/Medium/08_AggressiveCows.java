import java.util.*;

class Main {
    
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
        
        static int maxPossibleOfMinDistance(int[] stalls, int cows){
            int length = stalls.length;

            if(cows <= 1) return -1;

            Arrays.sort(stalls);

            int min = stalls[0];
            int max = stalls[length-1];

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
    
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int cows = 3;
        int result = maxPossibleOfMinDistance(stalls,cows);
        System.out.println(result);
    }
}