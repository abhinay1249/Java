// Problem Statement: Given an array of size n, 
// write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. 
// If the array is sorted then return True, Else return False.

// Example 1:

// Input: N = 5, array[] = {1,2,3,4,5}
// Output: True.
// Explanation: The given array is sorted i.e Every element in the array is smaller than or equals to its next values, So the answer is True.

// Example 2:

// Input: N = 5, array[] = {5,4,6,7,8}
// Output: False.
// Explanation: The given array is Not sorted i.e Every element in the array is not smaller than or equal to its next values, So the answer is False.
// Here element 5 is not smaller than or equal to its future elements.


class Main {

    // ======================= Brute-Force Approach ==================================

        public static boolean isSorted(int[] arr){
            int n = arr.length; 
            for(int i = 0; i < n ; i++){                            
                for(int j = i+1;j<n;j++){                               // T.C = O(N^2), S.C  O(1)
                    if(!(arr[i]<=arr[j])) return false;
                }
            }
            return true;
        }

    // ======================= Optimal Approach =======================================

        public static boolean isSorted_1(int[] arr){
            int n = arr.length;
            for(int i = 1; i < n ; i++){
                if(!(arr[i]>=arr[i-1])) return false;               // T.C = O(N), S.C  O(1)
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