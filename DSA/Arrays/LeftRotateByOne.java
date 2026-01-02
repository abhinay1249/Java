class Main {
    
    // ======================= Brute Force Approach =======================================

    static int[] leftRotateByOne(int[]arr){
        int targetElement = arr[0];
        int n = arr.length;
        int[] temp = new int[n];
        
        for(int i = 1;i<n;i++){
            temp[i-1]=arr[i];
        }
        temp[n-1]=targetElement;
        
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
            arr[i-1]=arr[i];
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