// Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a target value. 
// In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.


// Example 1:

// Input :arr[] = [1,0,-1,0,-2,2], target = 0
// Result: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Explanation:We have to find unique quadruplets from the array such that the sum of those elements is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

// Example 2:

// Input : arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
// Result: [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
// Explanation: The sum of all the quadruplets is equal to the target i.e. 9.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {

    // ==================================== Brute Force Approach ===========================================
    
        public static List<List<Integer>> fourSum(int[] nums, int target){
            int n = nums.length;
            Set<List<Integer>> elementList = new HashSet<>();

            for(int i = 0 ; i < n-3 ; i++){
                for(int j = i+1 ; j < n-2 ; j++){
                    for(int k = j+1 ;  k < n -1 ; k++){
                        for(int l = k+1 ; l < n ; l++){                                 // T.C = O(N^4 * Log(M)), S.C = 2 * O(no of quadra)
                            if(nums[i]+nums[j]+nums[k]+nums[l] == target){
                                List<Integer> elements = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                                Collections.sort(elements);
                                elementList.add(elements);
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(elementList);
        }
    
    // ==================================== Better Approach ===========================================
    
        public static List<List<Integer>> fourSum_1(int[] nums, int target){
            
	        int length = nums.length;
	        Set<List<Integer>> quadra = new HashSet<>();
	        Set<Long> elementCheck = new HashSet<>();
	    
	        for(int index_1 = 0 ; index_1 < length ; index_1++){
	    	    for(int index_2 = index_1+1 ; index_2 < length ; index_2++){
	    		    for(int index_3 = index_2+1 ; index_3 < length ; index_3++){            // T.C = O(N^3 *Log(M)), S.C = O(N) + 2 * O(no of quadra)
	    			    long sum = (long) nums[index_1]+nums[index_2]+nums[index_3];

                        long element = (long) target - sum;
	    			    if(elementCheck.contains(element)){
	    				    List<Integer> temp = Arrays.asList(nums[index_1],nums[index_2],nums[index_3],(int)element);
	    				    Collections.sort(temp);
	    				    quadra.add(temp);
                        }
                        elementCheck.add((long)nums[index_3]);
                    }
                    elementCheck.clear();
                }
            }
            return new ArrayList<>(quadra);
        }

    // ==================================== Optimal Approach ===========================================

        public static List<List<Integer>> fourSum_2(int[] nums, int target){
        
	        int length = nums.length;

	        List<List<Integer>>  quadraplets = new ArrayList<>();

            if(length<4){
                return quadraplets;
            }

	        Arrays.sort(nums);

	        for(int idx_1 = 0 ; idx_1 < length ; idx_1++){
	    	    if(idx_1>0 && nums[idx_1] == nums[idx_1-1]){
	    		    continue;
                }                                                                               // T.C = O(N LOG N) + O(N^3), S.C = O(no of quadraplets) -->(no extra space)
	    	    for(int idx_2 = idx_1+1 ; idx_2 < length ; idx_2++){
	    		    if(idx_2>idx_1+1 && nums[idx_2] == nums[idx_2-1]){
	    			    continue;
                    }
                    int left = idx_2+1;
                    int right = length -1;

                    while(left<right){
                    	long sum = (long)(nums[idx_1]+nums[idx_2]);
                    	sum+=(long)(nums[left]+nums[right]);

                    	if(sum < target){
                    		left++;
                        }else if(sum>target){
                        	right--;
                        }else{
                        	List<Integer> elementList = Arrays.asList(nums[idx_1],nums[idx_2],nums[left],nums[right]);
                        	quadraplets.add(elementList);
                        	left++;
                        	right--;

                            while(left < right && nums[left] == nums[left-1]){
	                            left++;
                            }
                            while(left < right && nums[right] == nums[right+1]){
	                            right--;
                            }
                        }
                    }   
                }   
            }
            return quadraplets;
        }
        
    public static void main(String[] args) {
        int[] nums = {4,3,3,4,4,2,1,2,1,1};
        int target = 9;

        List<List<Integer>> res = fourSum(nums,target);
        
        for(List<Integer> num: res){
            System.out.println(num);
        }
    }
}