// Problem Statement: A line of N kids is standing there. The rating values listed in the integer array ratings are assigned to each kid.
// These kids are receiving candy, according to the following criteria:
// There must be at least one candy for every child.
// Kids whose scores are higher than their neighbours receive more candies than their neighbours.
// Return the minimum number of candies needed to distribute among children.

// Example 1:

// Input : ratings = [1, 0, 5]
// Output : 5
// Explanation : The distribution of candies will be 2 , 1 , 2 to first , second , third child respectively.

// Example 2:

// Input : ratings = [1, 2, 2]
// Output : 4
// Explanation : The distribution of candies will be 1 , 2 , 1 to first , second , third child respectively.
// The third gets only 1 candy because it satisfy above two criteria.

class Main {

    // ================================= Brute Force Approach =================================

        public static int candies(int[] ratings){

           int length = ratings.length;

            int[] leftCheck = new int[length]; 
            int[] rightCheck = new int[length];

            int leftCounter = 1;
            leftCheck[0] = leftCounter;

            for(int index = 1 ; index < length ; index++){

                if(ratings[index-1] < ratings[index]){
                    leftCounter++;
                    leftCheck[index] = leftCounter; 
                }else{
                    leftCounter = 1;
                    leftCheck[index] = leftCounter;
                }
            }

            int rightCounter = 1;
            rightCheck[length-1] = rightCounter;                            // T.C = O(3N), S.C = O(2N)

            for(int index = length - 2 ; index >= 0 ; index--){
                if(ratings[index] > ratings[index+1]){
                    rightCounter++;
                    rightCheck[index] = rightCounter;

                }else{
                    rightCounter = 1;
                    rightCheck[index] = rightCounter;
                }
            } 

            int leftPtr = 0, rightPtr = 0;
            int minCandies = 0;

            while(leftPtr < length && rightPtr < length){
 
                minCandies += Math.max(leftCheck[leftPtr], rightCheck[rightPtr]);

                leftPtr++;
                rightPtr++;
            }

            return minCandies;

        }

    // ================================ Brtue - Better Approach ======================================

        public static int candies_1(int[] ratings){

            int length = ratings.length;

            int[] leftCheck = new int[length]; 
            int[] rightCheck = new int[length];

            leftCheck[0] = 1;
            rightCheck[length-1] = 1;

            for(int index = 1 ; index < length ; index++){

                if(ratings[index-1] < ratings[index]){
                    leftCheck[index] = leftCheck[index-1]+1;                                     // T.C = O(2N), S.C = O(2N) 
                }else{
                    leftCheck[index] = 1;
                }

                if(ratings[(length-index)-1] > ratings[(length-index)]){
                    rightCheck[(length-index)-1] = rightCheck[(length-index)]+1;
                }else{
                    rightCheck[(length-index)-1] = 1;
                }
            }

            int leftPtr = 0, rightPtr = 0;
            int minCandies = 0;

            while(leftPtr < length && rightPtr < length){

                minCandies += Math.max(leftCheck[leftPtr], rightCheck[rightPtr]);

                leftPtr++;
                rightPtr++;
            }

            return minCandies;

        }

    // ================================ Better Approach ==================================

        public static int candies_2(int[] ratings){

            int length = ratings.length;

            int[] leftCheck = new int[length]; 

            leftCheck[0] = 1;

            for(int index = 1 ; index < length ; index++){

                if(ratings[index-1] < ratings[index]){
                    leftCheck[index] = leftCheck[index-1]+1; 
                }else{
                    leftCheck[index] = 1;
                }
            }

            int minCandies = Math.max(leftCheck[length-1],1);                       // T.C = O(2N), S.C = O(N)

            int currPtr = 1;
            int rightPtr = 1;

            for(int index = length - 2 ; index >= 0 ; index--){
                if(ratings[index] > ratings[index+1]){
                    currPtr = rightPtr+1;
                    rightPtr = currPtr;
                }else{
                    currPtr = 1;
                    rightPtr = 1;
                }
                minCandies += Math.max(leftCheck[index], currPtr);
            } 

            return minCandies;

        }

    // ============================= Greedy Algorithm Approach =============================

        public static int candies_3(int[] ratings) {

            int length = ratings.length;

            int index = 1;

            int minCandies = 1;

            while(index < length){

                if(ratings[index] == ratings[index-1]){
                    minCandies += 1;
                    index++;
                    continue;                                                           
                }

                int peak = 1;                                                       // T.C = O(N), S.C = O(1)

                while(index < length && ratings[index] > ratings[index-1]){
                    peak+=1;
                    minCandies+=peak;
                    index++;
                }

                int down = 1;

                while(index < length && ratings[index] < ratings[index-1]){
                    minCandies+=down; 
                    down++;  
                    index++;
                }

                if(down > peak) minCandies += (down-peak);

            }

            return minCandies;
            
        }
    
    public static void main(String[] args) {
    
        int[] ratings = {1, 0, 5};

        int result = candies(ratings);
        System.out.println(result);

        int result_1 = candies_1(ratings);
        System.out.println(result_1);

        int result_2 = candies_2(ratings);
        System.out.println(result_2);

        int result_3 = candies_3(ratings);

        System.out.println(result_3);
        
    }
}