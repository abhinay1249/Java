import java.util.*;

class Main {

    // =========================== Brute Force Approach ==============================
    
        static boolean minimumDivisor(int[] nums,int divisor,int limit){

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

        static int smallestDivisor(int[] nums, int limit){

            int maxNumber = Arrays.stream(nums).max().getAsInt();

            for(int index = 1 ; index <= maxNumber ; index++){
                if(minimumDivisor(nums,index,limit) == true){
                    return index;
                }
            }
            return -1;
        }
    
    // =========================== Optimal Approach ==============================

        static boolean minimumDivisor_1(int[] nums,int divisor,int limit){
        
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
    
        static int smallestDivisor_1(int[] nums, int limit){

            int length = nums.length;

            if(threshold < length) return -1;

            int low = 1;
            int high = Arrays.stream(nums).max().getAsInt();

            while(low <= high){
                int mid = low + ((high - low)/2);
                if(minimumDivisor(nums,mid,limit) == true){
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