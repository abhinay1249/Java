import java.util.*;

class Main{
    
    // ======================= Brute Force Approach =======================================

        static List<Integer> leaders(int[] nums){
        
	       int n = nums.length;
	       int idx = 0;
    
	       List<Integer> ans = new ArrayList<>();
    
	       if(n == 0) return ans;
    
	       for(int i = 0 ; i < n-1 ; i++){
	            boolean flag = true;
	       	    for(int j = i+1 ; j < n ; j++){
                
	       		    if(!(nums[i]>nums[j])){
	       			    flag = false;
	       			    break;
	       	    	}
	           	}
	       	    if(flag == true){
                    ans.add(nums[i]);
	       	    }
	        }
	        ans.add(nums[n-1]);
        	return ans;
        }

    // ======================= Optimal Approach =======================================

        static List<Integer> leaders_1(int[] nums){
            List<Integer> ans = new ArrayList<>();
            int maxNum = Integer.MIN_VALUE;
            int n = nums.length;

            for(int i = n - 1 ; i >= 0 ; i--){
                if(nums[i]>maxNum){
                    ans.add(nums[i]);
                    maxNum = Math.max(maxNum,nums[i]);
                }
            }
            Collections.reverse(ans);

            return ans;
        }
        
    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};
        List<Integer> res = leaders(nums);
        List<Integer> res_1 = leaders_1(nums);
        for(int i : res_1){
            System.out.print(i+" ");
        }
    }
}