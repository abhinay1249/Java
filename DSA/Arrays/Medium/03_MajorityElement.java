import java.util.*;

class Main {
    static int majorityElement(int[] nums){
	    
	    int element = -1;
	    int lengthOfArray = nums.length;
	    int maxCount = 0;

	    for(int i = 0 ; i < nums.length;i++){
	        int count = 0;
		    for(int j = 0 ; j < nums.length ; j++){
			    if(nums[i]==nums[j]){
				    count++;
				    maxCount = Math.max(count,maxCount);
			    }
		    }
		  if(maxCount > (lengthOfArray/2)){
		      element = nums[i];
		      break;
		  }
	    }
	    return element;
    }
    
    public static void main(String[] args) {
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int result = majorityElement(nums);
        System.out.println(result);
    }
}