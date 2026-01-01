class Main {
    
    static void reverse(int[]arr,int index, int n){
        while(index<n){
            swap(arr,index,n);
            index++;
            n--;
        }
    }
    
    static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    
    static void nextPermutation(int[] arr){
        int idx = -1;
        int n = arr.length;
        for(int i = n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx=i;
                break;
            }
        }
        
        if(idx==-1){
            reverse(arr,0,n-1);
            return;
        }
        
        for(int i = n-1;i>idx;i--){
            if(arr[i]>arr[idx]){
                swap(arr,i,idx);
                break;
            }
        }
        reverse(arr,idx+1,n-1);
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    
    public static void main(String[] args) {
        int arr[] = {1,3,2};
        nextPermutation(arr);
    }
}