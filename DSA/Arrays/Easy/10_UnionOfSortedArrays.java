// Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.

// The union of two arrays can be defined as the common and distinct elements in the two arrays.

// NOTE: Elements in the union should be in ascending order.

// Examples

// Input:n = 5,m = 5 arr1[] = {1,2,3,4,5}  arr2[] = {2,3,4,4,5}
// Output: {1,2,3,4,5}
// Explanation: Common Elements in arr1 and arr2  are:  2,3,4,5
// Distnict Elements in arr1 are : 1
// Distnict Elemennts in arr2 are : No distinct elements.
// Union of arr1 and arr2 is {1,2,3,4,5}

// Input:n = 10,m = 7,arr1[] = {1,2,3,4,5,6,7,8,9,10}arr2[] = {2,3,4,4,5,11,12}
// Output: {1,2,3,4,5,6,7,8,9,10,11,12}
// Explanation: Common Elements in arr1 and arr2  are:  2,3,4,5
// Distnict Elements in arr1 are : 1,6,7,8,9,10
// Distnict Elemennts in arr2 are : 11,12
// Union of arr1 and arr2 is {1,2,3,4,5,6,7,8,9,10,11,12}



import java.util.*;

class Main {

    // ======================= Brute Force Approach USING MAP =======================================

        static int[] unionOfSortedArrays(int[] arr_1,int[] arr_2){

            Map<Integer,Integer> freq = new HashMap<>();

            for(int i = 0; i < arr_1.length;i++){
                freq.put(arr_1[i],freq.getOrDefault(arr_1[i],0)+1);
            }
            for(int i = 0 ; i < arr_2.length;i++){
                freq.put(arr_2[i],freq.getOrDefault(arr_2[i],0)+1);
            }

            int[] unionOfArrays = new int[freq.size()];
            int idx = 0;

            for(int i : freq.keySet()){              // T.C = O(N) + O(M) + O(X) + O(X LOG X) where X = No of Unique Elements, S.C = O(X)
                unionOfArrays[idx]=i;
                idx++;
            }

            Arrays.sort(unionOfArrays);

            for(int i:unionOfArrays){
                System.out.print(i+" ");
            }
            return unionOfArrays;
        }
    
    // ======================= Brute Force Approach USING SET =======================================
    
    static List<Integer> unionOfSortedArrays_1(int[] arr_1,int[] arr_2){
        
        Set<Integer> freq = new HashSet<>();
        
        for(int i = 0; i < arr_1.length;i++){
            freq.add(arr_1[i]);
        }
        for(int i = 0 ; i < arr_2.length;i++){
            freq.add(arr_2[i]);
        }
        
        List<Integer> unionOfArrays = new ArrayList<>();
        
        freq.forEach((i) -> unionOfArrays.add(i));
        
        for(int i : unionOfArrays){
            System.out.print(i+" ");
        }
        return unionOfArrays;
        // return new ArrayList<>(freq);
    }

    // ======================= Optimal Approach =======================================
    
    static List<Integer> unionOfSortedArrays_2(int[] arr_1,int[] arr_2){
        
        int n = arr_1.length;
        int m = arr_2.length;
        List<Integer> union = new ArrayList<>();;
        int i=0, j=0;
        
        while(i<n && j<m){
            if(arr_1[i] < arr_2[j]){
                if(union.size()==0 || union.get(union.size()-1)!=arr_1[i]){
                    union.add(arr_1[i]);
                }
                i++;
            }else if(arr_1[i]>arr_2[j]){
                if(union.size()==0 || union.get(union.size()-1)!=arr_2[j]){
                    union.add(arr_2[j]);
                }
                j++;
            }else{
                if(union.size()==0 || union.get(union.size()-1)!=arr_1[i]){
                    union.add(arr_1[i]);
                }
                i++;
                j++;
            }
        }
        
        while(i<n){
            if(union.size()==0 || union.get(union.size()-1)!=arr_1[i]){
                union.add(arr_1[i]);
            }
            i++;
        }
        
        while(j<m){
            if(union.size()==0 || union.get(union.size()-1)!=arr_2[j]){
                union.add(arr_2[j]);
            }
            j++;
        }
        for(int k :union){
            System.out.print(k+" ");
        }
        return union;
    }
    public static void main(String[] args) {    
        int[] arr_1 = {1,2,3,4,5,7};
        int[] arr_2 = {2,3,4,6,6};
        unionOfSortedArrays(arr_1,arr_2);
        unionOfSortedArrays_1(arr_1,arr_2);
        unionOfSortedArrays_2(arr_1,arr_2);
    }
}