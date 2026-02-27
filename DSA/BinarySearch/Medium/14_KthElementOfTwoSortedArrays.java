// Problem Statement: Given two sorted arrays a and b of size m and n respectively. Find the kth element of the final sorted array.

import java.util.*;

class Main {

    // =========================== Brute Force Approach ============================== 

        static int kthElement(int[] nums1, int[] nums2, int k){
            int length1 = nums1.length;
            int length2 = nums2.length;

            List<Integer> sortedArray = new ArrayList<>();

            int left = 0, left_1 = 0;

            while(left < length1 && left_1 < length2){
                if(nums1[left]<nums2[left_1]){
                    sortedArray.add(nums1[left]);               // T.C = O(M + N), S.C = O(M + N)
                    left++;                             
                }else{
                    sortedArray.add(nums2[left_1]);
                    left_1++;
                }
            }

            while(left < length1){
                sortedArray.add(nums1[left]);
                left++;
            }
            while(left_1 < length2){
                sortedArray.add(nums2[left_1]);
                left_1++;
            }

            return sortedArray.get(k-1);
        }

    // =========================== Optimal Approach ==============================   

        static int kthElement_1(int[] nums1, int[] nums2, int k){
        
            int length_1 = nums1.length;
            int length_2 = nums2.length;

            if(length_1 > length_2){
                return kthElement_1(nums2,nums1,k);
            }

            int low = Math.max(0,k-length_2), high = Math.min(k,length_1);

            while(low <= high){
                int mid_1 = low + ((high-low)/2);
                int mid_2 = k - mid_1;

                int left_1 = Integer.MIN_VALUE;
                int left_2 = Integer.MIN_VALUE;                              // T.C = O(min(logM,logN)) , S.C = O(1)
                int right_1 = Integer.MAX_VALUE;
                int right_2 = Integer.MAX_VALUE;

                if(mid_1 - 1 >= 0) left_1 = nums1[mid_1-1];
                if(mid_2 - 1 >= 0) left_2 = nums2[mid_2-1];
                if(mid_1 < length_1) right_1 = nums1[mid_1];
                if(mid_2 < length_2) right_2 = nums2[mid_2];

                if(left_1 <= right_2 && left_2 <= right_1){
                    return Math.max(left_1,left_2);
                }else if(left_1 > right_2){                     
                    high = mid_1 - 1;
                }else{
                    low = mid_1 + 1;
                }
            }
            return 0;
        }

    public static void main(String[] args) {
            int[] nums1 = {100, 112, 256, 349, 770};
        int[] nums2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        int result = kthElement(nums1,nums2,k);
        System.out.println(result);
    }
}