class Main{

    static int buyAndSell(int[] nums){
        int maxProfit = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[j]>nums[i]){
                    maxProfit = Math.max(maxProfit,nums[j]-nums[i]);
                }
            }
        }
        if(maxProfit == 0) return 0;
        return maxProfit;
    }

    static int buyAndSell_1(int[] nums){
        int maxProfit = 0;
        int minCost = nums[0];
        int cost = 0;
        
        for(int i = 1; i < nums.length ; i++){
            cost = nums[i] - minCost;
            maxProfit = Math.max(maxProfit, cost);
            
            minCost = Math.min(minCost,nums[i]);
        }
        return maxProfit;
    }

    static int buyAndSell_2(int[] nums){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0 ; i < nums.length ; i++){
            
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
        int result_1 = buyAndSell_1(prices);
        int result_2 = buyAndSell_2(prices);
        System.out.println(result);
        System.out.println(result_1);
        System.out.println(result_2);
    }
}