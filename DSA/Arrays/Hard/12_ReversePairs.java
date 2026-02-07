import java.util.*;

class Main {

        // ==================================== Brute Force Approach ===========================================

        static int reversePairs(int[] nums){
        
            int length = nums.length;
            int count = 0;
            if(nums.length < 2) return count;

            for(int idx1 = 0 ; idx1 < nums.length ; idx1++){                    // T.C = O(N^2) S.C = O(1)
                for(int idx2 = idx1+1 ; idx2 < nums.length ; idx2++){
                    long value1 = nums[idx1];
                    long value2 = (2 * (long)nums[idx2]);
                    if(value1 > value2){
                        count++;
                    }
                }
            }
            return count;
        }

    // ==================================== Optimal Approach ===========================================

        static void merge(int[] nums, int low, int mid, int high){
	           List<Integer> temp = new ArrayList<>();
	           int left = low;
	           int right = mid+1;
    

	           while(left<=mid && right<=high){
	       	    if(nums[left] <= nums[right]){
	       		    temp.add(nums[left]);
	       		    left++;
                }else if(nums[left]>nums[right]){               // T.C = O(N LOG N)
	                   temp.add(nums[right]);
	                   right++;
                }
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
        }

        static int countPairs(int[] nums, int low, int mid, int high){

            int left = low;
            int right = mid+1;
            int count = 0;

            for(int idx = left ; idx <= mid ; idx++){

	            while(right <= high && (long)nums[idx] > 2 * (long)nums[right]){
	               right++;
	            }
	            count += (right - (mid+1));
	        }
	       return count;
        }

        static int mergeSort(int[] nums, int low, int high){
	           int mid = low + ((high - low)/2);
	           int count = 0;
    
	           if(low >= high) return count;

	           count+=mergeSort(nums,low,mid);
	           count+=mergeSort(nums,mid+1,high);
	           count+=countPairs(nums,low,mid,high);
	           merge(nums,low,mid,high);
    
	       return count;
    
        }

        static int reversePairs(int[]nums){
	           int length = nums.length;
	           return mergeSort(nums,0,length-1);
        }

    public static void main(String[] args) {
        int[] nums = {6,13,21,25,1,2,3,4,5,9};
        int result = reversePairs(nums);
        System.out.println(result);
    }
}