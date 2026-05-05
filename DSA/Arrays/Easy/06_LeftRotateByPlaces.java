// Problem Statement: Given an array of integers, rotating array of elements by k elements left.

// Examples

// Input : nums = [1, 2, 3, 4, 5, 6, 7], k = 2, right
// Output : [6, 7, 1, 2, 3, 4, 5]
// Explanation : rotate 1 step to the right: [7, 1, 2, 3, 4, 5, 6]
// rotate 2 steps to the right: [6, 7, 1, 2, 3, 4, 5] 

// Input : nums = [1, 2, 3, 4, 5, 6], k=2, left
// Output : [3, 4, 5, 6, 1, 2]
// Explanation :rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
// rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]


class Main {
    
    // ============================ Brute Force Approach ============================================

        static int[] leftRotateByPlaces(int[] arr,int k){
            int n = arr.length;
            k%=n;
            
            if(n==0 || n==1) return arr;
        
            int[] temp = new int[n];
            
            for(int i = 0; i < k;i++){
                temp[i]=arr[i];
            }
            
            for(int i = k;i<n;i++){                                 // T.C = O(N + K), S.C = O(K)
                arr[i-k]=arr[i];
            }
            
            for(int i = n-k ; i<temp.length;i++){
                arr[i]=temp[i-(n-k)];
            }
            
            for(int i = 0; i<n;i++){
                System.out.print(arr[i]+" ");
            }
        
            return arr;
        }

    // =================================== Optimal Approach =========================================

        static void reverse(int start,int end,int[]arr){
            while(start<end){
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }

        static void leftRotateByPlaces_1(int[]arr, int k){
            int a = 0;
            int n = arr.length;
            k%=n;

            if(n==0 || n==1) return;

            reverse(a,k-1,arr);
            reverse(k,n-1,arr);                                 // T.C = O(2N), S.C = O(1) 
            reverse(a,n-1,arr);

            for(int i = 0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
        }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] arr_1 = {1,2,3,4,5,6,7};
        int k =33;
        leftRotateByPlaces(arr,k);
        leftRotateByPlaces_1(arr_1,k);
    }
}