// Problem Statement: Given an array of integers, rotating array of elements by k elements right.

// Examples

// Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
// Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
// Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order

// Input : 1,2,0,1,0,4,0
// Output: 1,2,1,4,0,0,0
// Explanation : All the zeros are moved to the end and non-negative integers are moved to front by maintaining order


class Main {
    
    // ======================== Brute Force Approach ===========================================

    static void rightRotateByPlaces(int[]arr,int k){
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

    static void reverse(int start, int end, int[] arr){
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    static void rightRotateByPlaces_1(int[]arr,int k){
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