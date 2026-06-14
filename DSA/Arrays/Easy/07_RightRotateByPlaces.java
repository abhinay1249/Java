// Problem Statement: Given an array of integers, rotating array of elements by k elements right.

// Example 1:

// Input : nums = [1, 2, 3, 4, 5, 6, 7], k = 2, right
// Output : [6, 7, 1, 2, 3, 4, 5]
// Explanation : rotate 1 step to the right: [7, 1, 2, 3, 4, 5, 6]
// rotate 2 steps to the right: [6, 7, 1, 2, 3, 4, 5]

// Example 2:

// Input : nums = [1, 2, 3, 4, 5, 6], k=2, left
// Output : [3, 4, 5, 6, 1, 2]
// Explanation :rotate 1 step to the left: [2, 3, 4, 5, 6, 1]   


class Main {
    
    // ======================== Brute Force Approach ===========================================

        public static void rightRotateByPlaces(int[]arr,int k){
            int n = arr.length;
            k%=n;
            if(n==0 || n==1) return;

            int[] temp = new int[k];


            for(int i = n-1;i>=n-k;i--){
                temp[i-(n-k)]=arr[i];
            }
            for(int i = n-k-1; i>=0;i--){
                arr[i+k]=arr[i];    
            }
            for(int i = 0;i<temp.length;i++){
                arr[i]=temp[i];
            }
        }
    
    
    // ======================= Optimal Approach =======================================

        private static void reverse(int start, int end, int[] arr){
            while(start<end){
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
    
        public static void rightRotateByPlaces_1(int[]arr,int k){
            int n = arr.length;
            k%=n;
            
            if(n==0 || n==1) return;
            
            reverse(0,n-k-1,arr);
            reverse(n-k,n-1,arr);
            reverse(0,n-1,arr);
        }


    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7};
        int[] arr_1 ={1,2,3,4,5,6,7};
        int k = 5;
        
        rightRotateByPlaces(arr,k);
        rightRotateByPlaces_1(arr_1,k);
        
        for(int i = 0;i<arr_1.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}