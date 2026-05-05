// Problem Statement: Given an integer array nums, rotate the array to the left by one.

// Note: There is no need to return anything, just modify the given array.


// Example 1:
// Input : nums = [1, 2, 3, 4, 5]  
// Output : [2, 3, 4, 5, 1]  
// Explanation : Initially, nums = [1, 2, 3, 4, 5]  
// Rotating once to the left results in nums = [2, 3, 4, 5, 1].

// Example 2:
// Input : nums = [-1, 0, 3, 6]  
// Output : [0, 3, 6, -1]  
// Explanation : Initially, nums = [-1, 0, 3, 6]  
// Rotating once to the left results in nums = [0, 3, 6, -1].

class Main {
    
    // ======================= Brute Force Approach =======================================

        static int[] leftRotateByOne(int[]arr){
            int targetElement = arr[0];
            int n = arr.length;
            int[] temp = new int[n];

            for(int i = 1;i<n;i++){
                temp[i-1]=arr[i];
            }
            temp[n-1]=targetElement;                    // T.C = O(2N), S.C = O(N-1)

            for(int i=0;i<temp.length;i++){
                System.out.print(temp[i]+" ");
            }
            System.out.println();

            return temp;
        }
    
    // ======================= Optimal Approach =======================================
    
        static int[] leftRotateByOne_1(int[]arr){
            int temp = arr[0];
            int n = arr.length;

            for(int i = 1;i<n;i++){
                arr[i-1]=arr[i];                            // T.C = O(N), S.C = O(1)
            }
            arr[n-1]=temp;

            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            return arr;
        }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] result = leftRotateByOne(arr);
        int[] result_1 = leftRotateByOne_1(arr);
    }
}