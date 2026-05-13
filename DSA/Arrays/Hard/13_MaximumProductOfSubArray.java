// Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.

// Examples

// Input: Nums = [1,2,3,4,5,0]
// Output: 120
// Explanation: In the given array, 1×2×3×4×5 gives maximum product value.

// Input: Nums = [1,2,-3,0,-4,-5]
// Output: 20
// Explanation : In the given array, (-4)×(-5) gives maximum product value.


class Main {
    
    // ==================================== Brute Force Approach ===========================================

        public static int maxProduct(int[] nums){

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

            for(int idx = 0 ; idx < length ; idx++){                            // T.C = O(N^2) S.C = O(1)
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

    // =============================== Optimal Approach =====================================

        public static int maxProduct_2(int[] nums) {
            int length = nums.length;
            int maxProduct = 0;

            if(length == 0){
                return maxProduct;
            }else if(length == 1){
                return nums[0];
            } 

            int prefix = 1;
            int suffix = 1;                                                         // T.C = O(N) S.C = O(1)

            for(int idx = 0 ; idx < length ; idx++){

                if(prefix == 0){
                    prefix = 1;
                }

                if(suffix == 0){
                    suffix = 1;
                }

                prefix *= nums[idx];
                suffix *= nums[length-idx-1];

                maxProduct = Math.max(maxProduct,Math.max(prefix,suffix));
            }
            return maxProduct;
        }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int result = maxProduct_1(nums);
        System.out.println(result);
    }
}