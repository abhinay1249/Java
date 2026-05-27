// Problem Statement: You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'. 
// Your task is to find the smallest positive integer divisor, 
// such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given threshold value.

// Example 1:

// Input Format: N = 5, arr[] = {1,2,3,4,5}, limit = 8
// Result: 3
// Explanation: We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 
// The sum is 9(1 + 1 + 2 + 2 + 3)  if we choose 2 as a divisor. 
// Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. 
// Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.

// Example 2:

// Input Format: N = 4, arr[] = {8,4,2,3}, limit = 10
// Result: 2
// Explanation: If we choose 1, we get 17 as the sum. If we choose 2, we get 9(4+2+1+2) <= 10 as the answer. So, 2 is the answer.


import java.util.*;

class Main {

    // =========================== Brute Force Approach ==============================
    
        private static boolean minimumDivisor(int[] nums,int divisor,int limit){

            int sum = 0;
            int div = 0;
            int length = nums.length;
            boolean flag = false;

            for(int index = 0 ; index < length ; index++){
                div = (int) Math.ceil((double)nums[index]/divisor);         
                sum += div;

                if(sum <= limit){                           // T.C = O(N) * O(MaxNumber) S.C = O(1)
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            return flag;
        }

        public static int smallestDivisor(int[] nums, int limit){

            int maxNumber = Arrays.stream(nums).max().getAsInt();

            for(int index = 1 ; index <= maxNumber ; index++){
                if(minimumDivisor(nums,index,limit) == true){
                    return index;
                }
            }
            return -1;
        }
    
    // =========================== Optimal Approach ==============================

        private static boolean minimumDivisor_1(int[] nums, int divisor, int limit){
        
            int sum = 0;
            int div = 0;
            int length = nums.length;
            boolean flag = false;

            for(int index = 0 ; index < length ; index++){
                div = (int) Math.ceil((double)nums[index]/divisor);
                sum += div;

                if(sum <= limit){
                    flag = true;                                        
                }else{
                    flag = false;                          // T.C = O(log MaxNumber) * O(N) S.C = O(1)
                    break;
                }
            }
            return flag;
        }
    
        public static int smallestDivisor_1(int[] nums, int limit){

            int length = nums.length;

            if(limit < length) return -1;

            int low = 1;
            int high = Arrays.stream(nums).max().getAsInt();

            while(low <= high){
                int mid = low + ((high - low)/2);
                if(minimumDivisor_1(nums,mid,limit) == true){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return low;
        }

    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int limit = 5;
        int result = smallestDivisor_1(nums,limit);
        System.out.println(result);
    }
}