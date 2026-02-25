// Problem Statement: Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays.
// The median is defined as the middle value of a sorted list of numbers. 
// In case the length of the list is even, the median is the average of the two middle elements.


import java.util.*;

class Main {

    // =========================== Brute Force Approach ============================== 

        static double medianOfSortedArrays(int[] nums1, int[] nums2) {

            int nums1Length = nums1.length;
            int nums2Length = nums2.length;

            int start1 = 0, start2 = 0;
            List<Integer> sortedArray = new ArrayList<>();

            while(start1 < nums1Length && start2 < nums2Length){
                if(nums1[start1] < nums2[start2]){
                    sortedArray.add(nums1[start1]);
                    start1++;
                }else {
                    sortedArray.add(nums2[start2]);
                    start2++;
                }
            }

            while(start1 < nums1Length){
                sortedArray.add(nums1[start1]);
                start1++;                           // T.C = O(M + N) , S.C = O(M + N)
            }
            while(start2 < nums2Length){
                sortedArray.add(nums2[start2]);
                start2++;      
            }

            int length = sortedArray.size();

            int low = 0;
            int high = length - 1;

            int mid = low + ((high - low)/2);

            if(length%2==0){
                return (double)(sortedArray.get(mid) + sortedArray.get(mid+1))/2;
            }else{
                return (double) sortedArray.get(mid);
            }
        }

    // =========================== Better Approach ============================== 

        static double medianOfSortedArrays_1(int[] nums1, int[] nums2) {
        
            int length_1 = nums1.length;
            int length_2 = nums2.length;
            int totalLength = (length_1+length_2);

            int left = 0, left_1 = 0;

            int prev = 0, curr = 0;
            int count = 0;                              // T.C = O(M + N) , S.C = O(1)

            while(count <= totalLength/2){

                prev = curr;                                

                if(left < length_1 && (left_1 >= length_2 || nums1[left] <= nums2[left_1])){
                    curr = nums1[left++];
                }else{
                    curr = nums2[left_1++];
                }
                count++;
            }

            if(totalLength%2 == 0){
                return (double) ((double)(prev+curr)/2);
            }
            return (double) curr;
        }

    // =========================== Optimal Approach ==============================     

        static double medianOfSortedArrays_2(int[] nums1, int[] nums2){
            int length1 = nums1.length;
            int length2 = nums2.length;

            if(length1 > length2) return a(nums2,nums1);
            int totalLength = length1+length2;
            int totalElementsOnLeft = (totalLength+1)/2;

            int low = 0, high = length1;

            while(low <= high){
                int left1 = Integer.MIN_VALUE;                          // T.C = O(log(M + N)) , S.C = O(1)
                int left2 = Integer.MIN_VALUE;
                int right1 = Integer.MAX_VALUE;
                int right2 = Integer.MAX_VALUE;

                int mid1 = low+((high-low)/2);
                int mid2 = totalElementsOnLeft - mid1;

                if(mid1>0) left1 = nums1[mid1 - 1];
                if(mid2>0) left2 = nums2[mid2 - 1];

                if(mid1<length1) right1 = nums1[mid1];
                if(mid2<length2) right2 = nums2[mid2];

                if(left1 < right2 && left2 < right1){
                    if(totalLength%2==0){
                        return ((double)(Math.max(left1,left2)+Math.min(right1,right2))/2);
                    }else{
                        return (double)Math.max(left1,left2);
                    }
                }
                else if(left1 > right2){
                    high = mid1 - 1;
                }else{
                    low = mid1 + 1;
                }
            }
            return 0;
        }

    public static void main(String[] args) {
        int[] nums1 = {2,4,6};
        int[] nums2 = {1,3,5};
        double result = medianOfSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}