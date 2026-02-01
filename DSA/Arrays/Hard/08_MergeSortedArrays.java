// Problem Statement: Given two sorted integer arrays nums1 and nums2, merge both the arrays into a single array sorted in non-decreasing order.
// The final sorted array should be stored inside the array nums1 and it should be done in-place.
// Array nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s whereas nums2 has a length of n.

import java.util.*;

class Main{

    // ==================================== Brute Force Approach ===========================================

        static int[] mergeTwoSortedArray(int[] nums1, int[] nums2, int m , int n){
        
            for(int idx = 0 ; idx < n ; idx++){
                nums1[m+idx] = nums2[idx];
            }                                                           //T.C = O(M)+ O(M LOG M), S.C = O(1)

            Arrays.sort(nums1);

            return nums1;
    
        }
    
    // ==================================== Optimal Approach ===========================================

        static int[] mergeTwoSortedArray_1(int[] nums1,int[] nums2, int m,int n) {

            if(n==0){
                return nums1;
            }

            int left = m-1;
            int right = n-1;
            int index = (m+n)-1;

            while(left>=0 && right >=0){
                if(nums1[left]<nums2[right]){
                    nums1[index] = nums2[right];
                    right--;
                    index--;
                }else if(nums1[left]>=nums2[right]){                             //T.C = O(M+N), S.C = O(1)
                    nums1[index] = nums1[left];
                    index--;
                    left--;
                }
            } 

            while(right>=0){
                nums1[index] = nums2[right];
                index--;
                right--;
            }
            return nums1;
        }


    public static void main(String[] args) {
        int[] nums1 = {0, 2, 7, 8, 0, 0, 0};
        int[] nums2 = {-7, -3, -1};
        int m = 4;
        int n = 3;
        int[] result = mergeTwoSortedArray_1(nums1,nums2,m,n);
        for(int values: result){
            System.out.print(values+" ");
        }
        
    }
}