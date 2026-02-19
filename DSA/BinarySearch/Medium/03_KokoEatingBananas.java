// Problem Statement: A monkey Koko is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘a[i]’ bananas. 
// An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.

// Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. 
// If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.

// Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.


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

    // =========================== Optimal Approach ==============================

        static long calculateMinBananas_1(int[] piles, int minBananas){
            int length = piles.length;
            int bananasPerHour = 0;
            long minSpeed = 0;

            for(int index = 0 ; index < length ; index++){
                bananasPerHour = (int) Math.ceil((double)piles[index]/minBananas);
                minSpeed += bananasPerHour;
            }
            return minSpeed;                                                    // T.C = O(log2(max[piles])) * O(N), S.C = O(1)
        }
    
        static int kokoEatingBananas_1(int[] piles, int hours){

            int maxBananas = Arrays.stream(piles).max().getAsInt();
            int low = 1 , high = maxBananas;

            while(low <= high){
                int mid = low + ((high - low)/2);
                long result = calculateMinBananas_1(piles, mid);

                if(result <= hours){
                   high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return low;
        }

    public static void main(String[] args) {
        int[] piles = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int hours = 823855818;
        int minimumSpeed = kokoEatingBananas_1(piles,hours);
        System.out.println(minimumSpeed);
    }
}