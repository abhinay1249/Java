// Problem Statement: Given two sorted integer arrays nums1 and nums2 of sizes m and n respectively,
// rearrange the elements such that them in-place such that
// the combined sequence of both arrays is sorted, after rearrangement:


// The first array nums1 should contain the first m smallest elements,
// and the second array nums2 should contain the remaining n elements,
// with both arrays maintaining sorted order.

// - Both arrays remain individually sorted
// - All elements in nums1 are less than or equal to all elements in nums2
// - No extra space is used (in-place rearrangement)

// The total set of elements across both arrays must remain the same.

// Example:
// Input:
// nums1  = {1, 3, 5, 7}
// nums2 = {0, 2, 6, 8, 9}

// Output:
// nums1  = {0, 1, 2, 3}
// nums2 = {5, 6, 7, 8, 9}

import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================

        public static int[] mergeTwoSortedArray(int[] nums1, int[] nums2, int m , int n){
        
	        int left = 0 ;
	        int right = 0;
	        int index = 0;
	        int[] result = new int[m+n];
    
	        while(left< m && right < n){
	            if(nums1[left]<nums2[right]){
	                result[index] = nums1[left];
	                index++;
	                left++;
	            }else{
	                result[index] = nums2[right];                       //T.C = O(M+N) + O(M+N), S.C = O(M+N)
	                index++;
	                right++;
	            }
	        }
    
	        while(left < m){
	            result[index++] = nums1[left++];
	        }
	        while(right < n){
	            result[index++] = nums2[right++];
	        }
    
	        for(int idx = 0 ; idx < m+n ; idx++){
	            if(idx < m){
	                nums1[idx] = result[idx];
	            }else{
	                nums2[idx-m] = result[idx];
	            }
	        }
	        return nums1;
	       // return nums2;
        }
    
    // ==================================== Optimal Approach ===========================================

        private static void swap(int left, int right, int[]nums1, int[] nums2){

            int temp = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = temp;

        }

        public static int[] mergeTwoSortedArray_1(int[] nums1, int[] nums2, int m , int n){
        
	        int left = m-1 ;
	        int right = 0;

            while(left>=0 && right < n){
                if(nums1[left] > nums2[right]){
                    swap(left,right,nums1,nums2);                          //T.C = O(min(m,n))+ O(N LOG N)+O(M LOG M), S.C = O(1)
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);

	        return nums1;
	       // return nums2;
        }

    // ==================================== Optimal Approach USING GAP METHOD (SHELL SORT)===========================================

        private static void swapIfGreater(int[]nums1,int[]nums2,int idx1,int idx2){
            if(nums1[idx1]>nums2[idx2]){
                swap(idx1,idx2,nums1,nums2);
            }
        }

        public static int[] mergeTwoSortedArray_2(int[] nums1, int[] nums2, int m , int n){
        
	        int length = (m+n);
	        int gap = (length/2) + (length%2);
    
	        while(gap>0){
	            int left = 0;
	            int right = left + gap;
    
	            while(right < length){                                              //T.C = log(M+N) * O(M+N), S.C = O(1)
	                if(left<m && right>=m){
	                    swapIfGreater(nums1,nums2,left,right-m);
	                }else if(left>=m){
	                    swapIfGreater(nums2,nums2,left-m,right-m);
	                }else{
	                    swapIfGreater(nums1,nums1,left,right);
	                }
	                left++;
	                right++;
	            }
	            if(gap == 1) break;
	            gap = (gap/2) + (gap%2);
	        }
	        return nums1;
	       // return nums2;
        }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7};
        int[] nums2 = {0,2,6,8,9};
        int m = nums1.length;
        int n = nums2.length;
        int[] result = mergeTwoSortedArray_1(nums1,nums2,m,n);
        for(int values: result){
            System.out.print(values+" ");
        }
        
    }
}