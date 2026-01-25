// Problem Statement: Given an array of integers arr[] and an integer target.

// 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

// 2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

 
import java.util.*;


class Main {

	// ======================= Brute Force Approach - Variant - 1 =======================================
    
    	static boolean twoSum(int[] nums, int target){
	
	    	int sumOfNumbers = 0;
	
	    	for(int i = 0 ; i < nums.length ; i++){
	    		for(int j = i+1 ; j < nums.length ; j++){
	    			if(nums[i]+nums[j] == target){
	    				return true;
	    			}
	    		}
	    	}
	    	return false;
    	}

	// ======================= Brute Force Approach - Variant - 2 =======================================
    
		static List<Integer> twoSum_1(int[] nums, int target){
		    List<Integer> indices = new ArrayList<>();

		    for(int i = 0 ; i < nums.length ; i++){
		    	for(int j = i+1 ; j < nums.length ; j++){
		    		if(nums[i]+nums[j] == target){
		    			indices.add(i);
		    			indices.add(j);
		    			return indices;
		    		}
		    	}
		    }
		    indices.add(-1);
		    indices.add(-1);
		    return indices;
    	}

	// ======================= Better Approach Variant - 1 =======================================
    
    	static Boolean twoSum_2(int[] nums, int target){
		
		    Map<Integer, Integer> twoSumMap = new TreeMap<>();

		    for(int i = 0 ; i < nums.length ; i++){
		        if(twoSumMap.containsKey(target - nums[i])){
		    		return true;
		    	}else{
		    	    twoSumMap.put(nums[i],i);
		    	}
		    }
		    return false;
    	}

	// ======================= Optimal Approach Variant -2 =======================================
    

    	static int[] twoSum_3(int[] nums, int target){
		
		    Map<Integer, Integer> twoSumMap = new TreeMap<>();

		    for(int i = 0 ; i < nums.length ; i++){
		        if(twoSumMap.containsKey(target - nums[i])){
		    		return new int[]{twoSumMap.get(target-nums[i]),i};
		    	}else{
		    	    twoSumMap.put(nums[i],i);
		    	}
		    }
		    return new int[]{-1,-1};
    	}
	
	// ======================= Optimal Approach Variant- 1 =======================================
    

    	static Boolean twoSum_4(int[] nums, int target){
		    Arrays.sort(nums);
		    int left = 0, right = nums.length-1;
	
		    while(left<right){
		    	int sum = nums[left]+nums[right];
	
		    	if(sum == target){
		    		return true;
		    	}else if(sum<target){
		    		left++;
		    	}else{
		    		right--;
		    	}
		    }
		    return false;
    	}
    
    public static void main(String[] args) {
        int[] nums = {2,6,5,8,11};
        int target = 14;
        boolean result = twoSum(nums,target);
        System.out.println(result);
		List<Integer> result_1 = new ArrayList<>(twoSum_1(nums,target));
        for(int i : result_1){
            System.out.println(i);
        }
        boolean result_2 = twoSum_2(nums,target);
        System.out.println(result_2);
        int[] result_3 = twoSum_3(nums,target);
        for(int i=0;i<result_3.length;i++){
            System.out.println(result_3[i]);
        }
        boolean result_4 = twoSum_4(nums,target);
        System.out.println(result_4);
    }
}