// Problem Statement: Given two sorted integer arrays nums1 and nums2, merge both the arrays into a single array sorted in non-decreasing order.
// The final sorted array should be stored inside the array nums1 and it should be done in-place.
// Array nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s whereas nums2 has a length of n.

import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================

        static int[] mergeTwoSortedArray(int[] nums1, int[] nums2, int m , int n){
        
            for(int idx = 0 ; idx < n ; idx++){
                nums1[m+i] = nums2[i];
            }                                                           //T.C = O(M)+ O(M LOG M), S.C = O(1)

            Arrays.sort(nums1);

            return nums1;
    
        }

    public static void main(String[] args) {
        int[] nums1 = {0, 2, 7, 8, 0, 0, 0};
        int[] nums2 = {-7, -3, -1};
        int m = nums1.length;
        int n = nums2.length;
        int[] result = mergeTwoSortedArray(nums1,nums2,m,n);
        for(int values: result){
            System.out.print(values+" ");
        }
        
    }
}