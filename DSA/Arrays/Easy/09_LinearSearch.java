// Problem Statement: Given an array, 
// and an element num the task is to find if num is present in the given array or not. If present print the index of the element or print -1.

// Example 1:

// Input: arr[] = 1 2 3 4 5, num = 3  
// Output: 2  `
// Explanation : 3 is present at the 2nd index of the array.

// Example 2:

// Input : arr[] = 5 4 3 2 1, num = 5  
// Output : 0  
// Explanation: 5 is present at the 0th index of the array.

class Main {


    // ======================= Optimal Approach USING RECURSION =======================================
    
    static int linearSearch(int[] arr, int num){
        return search(arr,num,0);
    }
    
    private static int search(int[] arr,int num,int index){

        if(index==arr.length || arr.length==0){
            return -1;
        }
        if(arr[index]==num){
            return index;
        }
        return search(arr,num,index+1);
    }

    // ======================= Optimal Approach USING LOOP =======================================

    static int linearSearch_1(int[] arr, int num){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[i]==num) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int num = 4;
        int result = linearSearch(arr,num);
        int result_1 = linearSearch_1(arr,num);
        System.out.println(result);
        System.out.println(result_1);
    }
}