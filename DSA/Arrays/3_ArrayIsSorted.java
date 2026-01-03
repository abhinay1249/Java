// Problem Statement: Given an array of size n, 
// write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. 
// If the array is sorted then return True, Else return False.

class Main {

    // ======================= Brute-Force Approach =======================================

    static boolean isSorted(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n ; i++){
            for(int j = i+1;j<n;j++){
                if(!(arr[i]<=arr[j])) return false;
            }
        }
        return true;
    }

    // ======================= Optimal Approach =======================================

    static boolean isSorted_1(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n ; i++){
            if(!(arr[i]>=arr[i-1])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1,7,2,3,4,5};
        boolean result = isSorted(arr);
        boolean result1 = isSorted_1(arr);
        System.out.println("Result:"+result);
        System.out.println("Result:"+result1);
    }
}