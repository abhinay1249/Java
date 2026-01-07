// Problem Statement: You are given an array of integers, 
// your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.


class Main {

    // ======================= Brute Force Approach =======================================

    static void moveZerosToEnd(int[] arr){
        int[] temp = new int[arr.length];
        int index = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i]!=0){
                temp[index]=arr[i];
                index++;
            }
        }
        for(int i = 0 ; i < temp.length;i++){
            arr[i]=temp[i];
        }
        for(int i = temp.length;i<arr.length;i++){
            arr[i]=0;
        }
    }

    // ======================= Optimal Approach =======================================
    
    static void moveZerosToEnd_1(int[] arr){

        int j = -1;

        for(int i = 0; i < arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        
        if(j==-1) return;
        
        for(int i = j+1;i<arr.length;i++){
            if(arr[i]!=0){
                swap(i,j,arr);
                j++;
            }
        }
    }
    
    static void swap(int left,int right, int[] arr){
        int temp = arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    
    public static void main(String[] args) {
        int[] arr={1,0,2,3,2,0,0,4,5,1};
        int[] arr_1={1,0,2,3,2,0,0,4,5,1};
        moveZerosToEnd(arr);
        moveZerosToEnd_1(arr_1);
        for(int i = 0; i < arr_1.length;i++){
            System.out.print(arr_1[i]+" ");
        }
    }
}