// ======================= Optimal Approach =======================================

class Main {
    static int largest(int[] arr){
        int n = arr.length;
        int largest = arr[0];
        
        for(int i=1;i<n;i++){
            if(largest<arr[i]) largest = arr[i]; 
        }
        return largest;
    }
    public static void main(String[] args) {
        int [] arr = {2,5,1,32,10};
        int result = largest(arr);
        System.out.println(result);
    }
}