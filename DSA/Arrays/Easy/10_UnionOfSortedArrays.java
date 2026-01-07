// Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.

// The union of two arrays can be defined as the common and distinct elements in the two arrays.

// NOTE: Elements in the union should be in ascending order.


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
        
        for(int i : freq.keySet()){
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
        int i=0, j=0, idx=0;
        
        while(i<n && j<m){
            if(arr_1[i]<=arr_2[j]){
                if(union.size()==0 || union.get(union.size()-1)!=arr_1[i]){
                    union.add(arr_1[i]);
                    idx++;
                }
                i++;
            }else if(arr_1[i]>arr_2[j]){
                if(union.size()==0 || union.get(union.size()-1)!=arr_2[j]){
                    union.add(arr_2[j]);
                    idx++;
                }
                j++;
            }else{
                if(union.size()==0 || union.get(union.size()-1)!=arr_1[i]){
                    union.add(arr_1[i]);
                    idx++;
                }
                i++;
                j++;
            }
        }
        
        while(i<n){
            if(union.size()==0 || union.get(union.size()-1)!=arr_1[i]){
                union.add(arr_1[i]);
                idx++;
            }
            i++;
        }
        
        while(j<m){
            if(union.size()==0 || union.get(union.size()-1)!=arr_2[j]){
                union.add(arr_2[j]);
                idx++;
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