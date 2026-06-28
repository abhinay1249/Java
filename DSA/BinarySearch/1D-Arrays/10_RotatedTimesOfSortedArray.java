// Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). 
// Now the array is rotated between 1 to N times which is unknown. 
// Find how many times the array has been rotated.

// Example 1:

// Input : arr = [4,5,6,7,0,1,2,3]
// Result: 4
// Explanation: The original array should be [0,1,2,3,4,5,6,7]. So, we can notice that the array has been rotated 4 times.

// Example 2:

// Input : arr = [3,4,5,1,2]
// Output : 3
// Explanation: The original array should be [1,2,3,4,5]. So, we can notice that the array has been rotated 3 times.


class Main {
    
    // ======================= Brute Force Approach ===================================
    
        public static int rotatedTimes(int[] nums){

            int length = nums.length;
            int minValue = Integer.MAX_VALUE;

            for(int index = 0; index < length ; index++){           // T.C = O(2N), S.C = O(1)
                minValue = Math.min(nums[index],minValue);
            }
            int rotatedTimes = 0;

            for(int index = 0 ; index < length ; index++){
                if(nums[index] == minValue){
                    rotatedTimes = index;
                }
            }

            return rotatedTimes;
        }

    // ======================= Better Approach =======================================

        public static int rotatedTimes_1(int[] nums){

            int length = nums.length;
            int minValue = Integer.MAX_VALUE;
            int rotatedTimes = 0;

            for(int index = 0; index < length ; index++){           // T.C = O(N), S.C = O(1)
                if(nums[index]<minValue){
                    minValue = nums[index];
                    rotatedTimes = index;
                }
                
            }
            return rotatedTimes;
        }

    // ======================= Optimal Approach =======================================

        public static int rotatedTimes_2(int[] nums){
        
            int length = nums.length;
            int minValue = Integer.MAX_VALUE;
            int rotatedTimes = 0;
            int low = 0 , high = length - 1;

            while(low <= high){
                int mid = low + ((high-low)/2);

                // Handles Duplicates
                
                if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                    low++;
                    high--;
                    continue;   
                }

                if(nums[low]<=nums[high]){
                    minValue = Math.min(nums[low],minValue);            // T.C = O(Log N), S.C = O(1)
                    rotatedTimes = low;
                    break;
                }

                if(nums[low]<=nums[mid]){
                    minValue = Math.min(nums[low],minValue);
                    rotatedTimes = low;
                    low = mid + 1;
                }else{
                    minValue = Math.min(nums[mid],minValue);
                    rotatedTimes = mid;
                    high = mid - 1;
                }
            }
            
            return rotatedTimes;
        }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        int result = rotatedTimes_2(nums);
        System.out.println(result);
    }
}