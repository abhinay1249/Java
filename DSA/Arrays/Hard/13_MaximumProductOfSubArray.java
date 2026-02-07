class Main {
    
    // ==================================== Brute Force Approach ===========================================

        static int maxProduct(int[] nums){

            int length = nums.length;
            int maxProduct = 0;

            if(length == 0){
                return maxProduct;
            }else if(length == 1){
                return nums[0];                                   // T.C = O(N^3) S.C = O(1)         
            } 

            for(int idx = 0 ; idx < length ; idx++){                
                if(nums[idx]==0){   
                    continue;
                }
                for(int idx1 = idx ; idx1 < length ; idx1++){
                    if(nums[idx1]==0){
                        continue;
                    }
                    int product = 1;
                    for(int idx2 = idx ; idx2 <= idx1 ; idx2++){

                        if(nums[idx2]!=0){
                            product *= nums[idx2];
                        }else{
                            break;
                        }
                    }
                    maxProduct = Math.max(maxProduct,product);
                }
            }
            return maxProduct;
        }

    // =============================== Better Approach =====================================

        static int maxProduct_1(int[] nums){

            int length = nums.length;
            int maxProduct = 0;

            if(length == 0){
                return maxProduct;
            }else if(length == 1){
                return nums[0];
            } 

            for(int idx = 0 ; idx < length ; idx++){                            // T.C = O(N^2) S.C = O(1
                if(nums[idx]==0){
                    continue;
                }
                int product = 1;

                for(int idx1 = idx ; idx1 < length ; idx1++){
                    if(nums[idx1]!=0){
                        product *= nums[idx1];
                    }else{
                        break;
                    }
                    maxProduct = Math.max(maxProduct,product);
                }

            }
            return maxProduct;
        }
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int result = maxProduct_1(nums);
        System.out.println(result);
    }
}