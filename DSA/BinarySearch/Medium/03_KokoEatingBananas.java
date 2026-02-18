import java.util.*;

class Main {
    
    // =========================== Brute Force Approach ==============================

        static long calculateMinBananas(int[] piles, int minBananas){
            int length = piles.length;
            int bananasPerHour = 0;
            long minSpeed = 0;

            for(int index = 0 ; index < length ; index++){
                bananasPerHour = (int) Math.ceil((double)piles[index]/minBananas);
                minSpeed += bananasPerHour;
            }
            return minSpeed;                                                        // T.C = O(max(piles)* N), S.C = O(1)
        }

        static int kokoEatingBananas(int[] piles, int hours){

            int length = piles.length;

            int maxBananas = Arrays.stream(piles).max().getAsInt();             

            for(int index = 1 ; index <= maxBananas ; index++){
                 long result = calculateMinBananas(piles, index);

                 if(result <= hours){
                    return index;
                 }
            }
            return maxBananas;
        }



    public static void main(String[] args) {
        int[] piles = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int hours = 823855818;
        int minimumSpeed = kokoEatingBananas_1(piles,hours);
        System.out.println(minimumSpeed);
    }
}