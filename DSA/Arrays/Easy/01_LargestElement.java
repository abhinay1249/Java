// Problem Statement: Given an array, we have to find the largest element in the array.

// Example 1:

// Input : arr[] = {2, 5, 1, 3, 0}  
// Output: 5  
// Explanation: 5 is the largest element in the array.

// Example 2:

// Input : arr[] = {8, 10, 5, 7, 9}  
// Output : 10  
// Explanation : 10 is the largest element in the array.


import java.util.Arrays;

class Main {

// ======================= Brute Force Approach =======================================

    static int largest(int[] arr){

        Arrays.sort(arr);

        return arr[arr.length-1];
    }

// ======================= Optimal Approach =======================================


    static int largest_1(int[] arr){
        
        int n = arr.length;
        int largest = arr[0];
        
        for(int i=1;i<n;i++){
            if(largest<arr[i]) largest = arr[i]; 
        }
        return largest;
    }
    public static void main(String[] args) {
        int [] arr = {2,5,1,32,10};
        int [] arr_1 = {2,5,1,32,10};
        int result = largest(arr);
        int result_1 = largest_1(arr);
        System.out.println(result);
        System.out.println(result_1);
    }
}