// Problem Statement: You are given a strictly increasing array ‘vec’ and a positive integer 'k'. 
// Find the 'kth' positive integer missing from 'vec'.


class Main {
    
    // =========================== Brute Force Approach ==============================

        public static int kthMissingElement(int[] nums, int k){
            int missingElement = -1;
            int length = nums.length;

            if(nums[0]>k){
                missingElement = k;
                return missingElement;                            // T.C = O(N) , S.C = O(1)
            }
            for(int index = 0 ; index < length ; index++){
                if(nums[index]>k){
                    missingElement = k;
                    break;
                }
                k++;
            }
            return missingElement;
        }

    // =========================== Optimal Approach ==============================

        public static int kthMissingElement_1(int[] nums, int k){
            int length = nums.length;

            int low = 0, high = length - 1;

            while(low <= high){
                int mid = low + ((high-low)/2);
                int missing = nums[mid]-(mid+1);            // T.C = O(Log N) , S.C = O(1)

                if(missing < k){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return low + k;
        }

    public static void main(String[] args) {
        int[] nums = {1,3,5,10,15};
        int k = 9;
        int result = kthMissingElement(nums,k);
        System.out.println(result);
        int result1 = kthMissingElement_1(nums,k);
        System.out.println(result1);
    }
}