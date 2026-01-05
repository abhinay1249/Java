// Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array..


class Main {

    // ======================= Brute Force Approach =======================================
        
        static int maxConsecutiveOne(int[] nums){

            int maxConsecutive = Integer.MIN_VALUE;
            int count = 0;

            for(int i = 0; i < nums.length ; i++){
                for(int j = i ; j < nums.length ; j++){

                    boolean allOnes = true;

                    for(int k = i ; k <= j ; k++){
                        if(nums[k]==0){
                            allOnes = false;
                            break;
                        }
                    }

                    if(allOnes){
                        maxConsecutive = Math.max(maxConsecutive, j-i+1);
                    }
                }
            }
            return maxConsecutive;
        }


    // ======================= Better Approach =======================================

    static int maxConsecutiveOne_1(int[] nums){

        int maxConsecutive = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i ; j < nums.length; j++){
                if(nums[j]==1){
                    maxConsecutive = Math.max(maxConsecutive,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxConsecutive;
    }

    // ======================= Optimal Approach =======================================

    static int maxConsecutiveOne_2(int[] nums){
        int arrayLength = nums.length;
        int count = 0;
        int maxConsecutive = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < arrayLength ; i++){
            if(nums[i]==1){
                count++;
            }else{
                count = 0;
            }
            maxConsecutive = Math.max(count,maxConsecutive);
        }
        return maxConsecutive;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int result = maxConsecutiveOne(nums);
        int result_1 = maxConsecutiveOne_1(nums);
        int result_2 = maxConsecutiveOne_2(nums);
        System.out.println(result);
        System.out.println(result_1);
        System.out.println(result_2);
    }
}