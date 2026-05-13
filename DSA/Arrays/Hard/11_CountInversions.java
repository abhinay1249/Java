// Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

// Inversion of an array: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].


// Example 1:
// Input Format: N = 5, array[] = {1,2,3,4,5}
// Result: 0
// Explanation: we have a sorted array and the sorted array has 0 inversions as for i < j you will never find a pair such that A[j] < A[i]. 
//     More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.

// Example 2:
// Input Format: N = 5, array[] = {5,4,3,2,1}
// Result: 10
// Explanation: we have a reverse sorted array and we will get the maximum inversions as for i < j we will always find a pair such that A[j] < A[i]. 
//     Example: 5 has index 0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3 which will satisfy out conditions and for reverse sorted array we will get maximum inversions and that is (n)*(n-1) / 2.For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

// Example 3:
// Input Format: N = 5, array[] = {5,3,2,1,4}
// Result: 7
// Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and (1,4) as both are not satisfy our condition.


import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================

        public static int countInversions(int[] nums){
        
            int length = nums.length;
	        int count = 0;
    
	        if(length < 2){
	            return count;
	        }           
	        for(int index_1 =0 ; index_1 < length-1 ; index_1++){                   // T.C = O(N^2) S.C = O(1)
	    	    for(int index_2 = index_1+1 ; index_2 < length ; index_2++){
	    		    if(nums[index_1]>nums[index_2]){
	    			    count++;
                    }
                }
            }
            return count;
        }
        
    // ==================================== Optimal Approach ===========================================

        public static int merge(int[] nums, int low, int mid, int high){
	        List<Integer> temp = new ArrayList<>();
	        int count = 0;
	        int left = low;
	        int right = mid+1;

	        while(left<=mid && right<=high){
	    	    if(nums[left] <= nums[right]){
	    		    temp.add(nums[left]);
	    		    left++;
                }else if(nums[left]>nums[right]){
	                temp.add(nums[right]);
	                count+=(mid-left+1);
	                right++;                             // T.C = O(N LOG N), S.C = O(N) Incase given array cannot be modified then simply clone it.
                }                                                                        // int[] nums = nums1.clone(); 
            }

            while(left<=mid){
	            temp.add(nums[left]);
	            left++;
            }

            while(right<=high){
	            temp.add(nums[right]);
	            right++;
            }

            for(int idx = low ; idx <= high ; idx++){
                nums[idx] = temp.get(idx - low);
            }

            return count;
        }

        public static int mergeSort(int[] nums, int low, int high){

	        int mid = low + ((high - low)/2);
	        int count = 0;

	        if(low >= high) return count;
    
	        count+=mergeSort(nums,low,mid);
	        count+=mergeSort(nums,mid+1,high);
	        count+=merge(nums,low,mid,high);

            return count;
        }

        static int countInversions_1(int[]nums){
	        int length = nums.length;
	        return mergeSort(nums,0,length-1);
        }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        int result = countInversions_1(nums);
        System.out.println(result);
    }
}