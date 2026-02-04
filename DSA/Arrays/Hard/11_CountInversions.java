import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================

        static int countInversions(int[] nums){
        
            int length = nums.length;
	        int count = 0;
    
	        if(length < 2){
	            return count;
	        }           
	        for(int index_1 =0 ; index_1 < length-1 ; index_1++){
	    	    for(int index_2 = index_1+1 ; index_2 < length ; index_2++){
	    		    if(nums[index_1]>nums[index_2]){
	    			    count++;
                    }
                }
            }
            return count;
        }

    public static void main(String[] args) {
        int[] nums = {5,3,2,1,4};
        int result = countInversions_1(nums);
        System.out.println(result);
    }
}