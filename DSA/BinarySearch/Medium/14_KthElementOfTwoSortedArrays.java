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
    
    public static void main(String[] args) {
            int[] nums1 = {100, 112, 256, 349, 770};
        int[] nums2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        int result = kthElement(nums1,nums2,k);
        System.out.println(result);
    }
}