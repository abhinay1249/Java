import java.util.*;

class Main {

	// ======================= Brute Force Approach =======================================
	
    static int majorityElement(int[] nums){
	    
	    int element = -1;
	    int lengthOfArray = nums.length;
	    int maxCount = 0;

	    for(int i = 0 ; i < nums.length;i++){
	        int count = 0;
		    for(int j = 0 ; j < nums.length ; j++){
			    if(nums[i]==nums[j]){
				    count++;
			    }
		    }
		  if(count > (lengthOfArray/2)){
		      element = nums[i];
		      break;
		  }
	    }
	    return element;
    }
    
	// ======================= Better Approach =======================================

    static int majorityElement_1(int[] nums){
	
	    Map<Integer,Integer> freqCount = new TreeMap<>();
	
	    for(int i = 0; i < nums.length; i++){
		    freqCount.put(nums[i],freqCount.getOrDefault(nums[i],0)+1);
	    }
	
	    int majorityElement = 0;
	    int maxCount = 0;
	
	    for(Map.Entry<Integer,Integer> value : freqCount.entrySet()){
		    if(value.getValue() > nums.length/2){
			    majorityElement = value.getKey();
		    }
    	}
	    return majorityElement;
    }

	// ======================= Optimal Approach [MOORE'S VOTING ALGORITHM] =======================================

	static int majorityElement_2(int[] nums){
	    int element = nums[0];
	    int majorityElement = 0;
	    int count = 0;

	    for(int i = 0 ; i < nums.length ; i++){
		    if(element == nums[i]){
			    count++;
		    }else if(element != nums[i]){
			    count--;
		    }

		    if(count == 0){
			    element = nums[i+1];
		    }   
	    }
	
	    for(int i : nums){
		    if(element == i){
			    count++;
		    }
		    if(count>nums.length/2){
		        majorityElement=i;
	        }
	    }

	    return majorityElement;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 1, 2};
        int[] nums_1 = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int result = majorityElement(nums);
        int result_1 = majorityElement_1(nums_1);
        System.out.println(result);
        System.out.println(result_1);
    }
}