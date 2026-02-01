import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================

        static int[] mergeTwoSortedArray(int[] nums, int[] nums1, int m , int n){
        
	        int left = 0 ;
	        int right = 0;
	        int index = 0;
	        int[] result = new int[m+n];
    
	        while(left< m && right < n){
	            if(nums[left]<nums1[right]){
	                result[index] = nums[left];
	                index++;
	                left++;
	            }else{
	                result[index] = nums1[right];
	                index++;
	                right++;
	            }
	        }
    
	        while(left < m){
	            result[index++] = nums[left++];
	        }
	        while(right < n){
	            result[index++] = nums1[right++];
	        }
    
	        for(int idx = 0 ; idx < m+n ; idx++){
	            if(idx < m){
	                nums[idx] = result[idx];
	            }else{
	                nums1[idx-m] = result[idx];
	            }
	        }
	        return nums1;
	       // return nums1;
        }
    
    // ==================================== Optimal Approach ===========================================

        static void swap(int left, int right, int[]nums, int[] nums1){

            int temp = nums[left];
            nums[left] = nums1[right];
            nums1[right] = temp;

        }

        static int[] mergeTwoSortedArray_1(int[] nums, int[] nums1, int m , int n){
        
	        int left = m-1 ;
	        int right = 0;

            while(left>=0 && right < n){
                if(nums[left] > nums1[right]){
                    swap(left,right,nums,nums1);
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            Arrays.sort(nums);
            Arrays.sort(nums1);

	        return nums;
	       // return nums1;
        }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int[] nums1 = {0,2,6,8,9};
        int m = nums.length;
        int n = nums1.length;
        int[] result = mergeTwoSortedArray_1(nums,nums1,m,n);
        for(int values: result){
            System.out.print(values+" ");
        }
        
    }
}