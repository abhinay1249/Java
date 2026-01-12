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

    







    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int result = buyAndSell(prices);
        System.out.println(result);
    }
}