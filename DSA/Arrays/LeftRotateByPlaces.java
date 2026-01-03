class Main {
    
    // ============================ Brute Force Approach ============================================

    static int[] leftRotateByPlaces(int[] arr,int k){
        int n = arr.length;
        k%=n;
        
        if(n==0 || n==1) return;

        int[] temp = new int[n];
        
        for(int i = 0; i < k;i++){
            temp[i]=arr[i];
        }
        
        for(int i = k;i<n;i++){
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
        reverse(k,n-1,arr);
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