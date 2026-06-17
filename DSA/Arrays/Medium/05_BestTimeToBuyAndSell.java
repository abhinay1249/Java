// Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day. 
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note: That buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.

class Main{

    // ======================= Brute Force Approach =======================================

        public static int buyAndSell(int[] nums){
            int maxProfit = 0;

            for(int i = 0 ; i < nums.length ; i++){
                for(int j = i+1 ; j < nums.length ; j++){                       // T.C = O(N^2), S.C = O(1)
                    if(nums[j]>nums[i]){
                        maxProfit = Math.max(maxProfit,nums[j]-nums[i]);
                    }
                }
            }
            if(maxProfit == 0) return 0;
            return maxProfit;
        }

    // ======================= Optimal Approach - 1 =======================================
    
        public static int buyAndSell_1(int[] nums){
            int maxProfit = 0;
            int minCost = nums[0];
            int cost = 0;

            for(int i = 1; i < nums.length ; i++){                      // T.C = O(N), S.C = O(1)

                cost = nums[i] - minCost;
                maxProfit = Math.max(maxProfit, cost);

                minCost = Math.min(minCost,nums[i]);
            }
            return maxProfit;
        }

    // ======================= Optimal Approach - 2 =======================================

        public static int buyAndSell_2(int[] nums){

            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            for(int i = 0 ; i < nums.length ; i++){                     // T.C = O(N), S.C = O(1)

                if(nums[i]<minPrice){
                    minPrice=nums[i];
                }else{
                    maxProfit = Math.max(maxProfit, nums[i] - minPrice);
                }
            }

            return maxProfit;
        }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};

        int result = buyAndSell(prices);
        System.out.println(result);

        int result_1 = buyAndSell_1(prices);
        System.out.println(result_1);
        
        int result_2 = buyAndSell_2(prices);
        System.out.println(result_2);
    }
}






