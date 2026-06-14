// Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the intersection of two sorted arrays.

// The intersection of two arrays can be defined as the common elements in the two arrays.

// NOTE: Elements in the intersection should be in ascending order.

// Example 1:

// Input:n = 5,m = 5 arr1[] = {1,2,3,4,5}  arr2[] = {2,3,4,4,5}
// Output: {2,3,4,5}
// Explanation: Common Elements in arr1 and arr2  are:  2,3,4,5


import java.util.ArrayList;
import java.util.List;

class Main {

    // ======================= Brute Force Approach USING VISITED ARRAY =======================================
    
        public static List<Integer> intersectionOfSortedArrays(int[] arr_1,int[] arr_2){
            int n = arr_1.length;
            int m = arr_2.length;
            int[] freqCount = new int[m];

            List<Integer> intersectionArray = new ArrayList<>();

            if(n==0 || m==0) return intersectionArray;

            for(int i = 0; i < n;i++){
                for(int j = 0; j < m;j++){
                    if(arr_1[i]==arr_2[j] && freqCount[j]==0){
                        intersectionArray.add(arr_1[i]);
                        freqCount[j]=1;
                        break;
                    }
                    if(arr_2[j]>arr_1[i]) break;
                }
            }
            for(int num:intersectionArray) System.out.print(num+" ");
            return intersectionArray;
        }

    // ======================= Optimal Approach  =======================================
    
        public static List<Integer> intersectionOfSortedArrays_1(int[] arr_1,int[] arr_2){
            int n = arr_1.length;
            int m = arr_2.length;
            int i = 0, j = 0;

            List<Integer> intersectionArray = new ArrayList<>();

            if(n==0 || m==0) return intersectionArray;

            while(i<n && j<m){
                if(arr_1[i]==arr_2[j]){
                    intersectionArray.add(arr_1[i]);
                    i++;
                    j++;
                }else if(arr_1[i]<arr_2[j]){
                    i++;
                }else{
                    j++;
                }
            }

            for(int num:intersectionArray){
                System.out.print(num+" ");
            }

            return intersectionArray;
        }

    public static void main(String[] args) {
        int[] arr_1={1,2,3,4,5};
        int[] arr_2={2,3,5};

        intersectionOfSortedArrays(arr_1,arr_2);
        intersectionOfSortedArrays_1(arr_1,arr_2);
    }
}