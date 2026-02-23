import java.util.*;

class Main {

    // =========================== Brute Force Approach ============================== 

        static double findMedianSortedArrays(int[] nums1, int[] nums2) {

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

    public static void main(String[] args) {
        int[] nums1 = {2,4,6};
        int[] nums2 = {1,3,5};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}