// Problem Statement: Given an array, 
// find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.

// Example 1:
// Input : [1, 2, 4, 7, 7, 5]  
// Output:

// Second Smallest : 2  
// Second Largest : 5  
// Explanation: The elements are sorted as 1, 2, 4, 5, 7, 7.  
// Hence, the second smallest element is 2, and the second largest element is 5.

// Example 2:
// Input: [1]  
// Output:
  
// Second Smallest : -1  
// Second Largest : -1  
// Explanation: Since there is only one element in the array, it is both the largest and smallest element.  
// Therefore, there is no second smallest or second largest element present.


import java.util.Arrays;

class Main {
    
    // ======================= Brute-Force Approach =======================================
    
        public static int slargest(int[] arr){
            
            int n = arr.length;
            
            if(n==0 || n==1) return -1;
            
            Arrays.sort(arr);
            int slargest = 0;
            int largest = arr[n-1];
            
            for(int i = n-2;i>=0;i--){
                if(arr[i]<largest){
                    slargest = arr[i];
                    break;
                }
            }
            return slargest;
        }
        
        public static int ssmallest(int[] arr){
            int n = arr.length;
            
            if(n==0 || n==1) return -1;
            
            Arrays.sort(arr);
            int ssmallest = 0;
            int smallest = arr[0];
            
            for(int i = 1;i<n;i++){
                if(arr[i]>smallest){
                    ssmallest = arr[i];
                    break;
                }
            }
            return ssmallest;
        }
    
    // ======================= Better Approach =======================================
    
        public static int secondLargest(int[] arr){

            int n = arr.length;

            if(n==0 || n==1) return -1;

            int largest = arr[0];

            for(int i = 1;i<n;i++){
                if(arr[i]>largest){
                    largest = arr[i];
                }
            }
            int slargest = Integer.MIN_VALUE;

            for(int i = 0; i <n;i++){
                if(arr[i]<largest){
                    slargest = Math.max(slargest,arr[i]);
                }
            }
            return slargest;
        }
    
    // ======================= Optimal Approach =======================================
    
        public static int secondLargestElement(int[] arr){

            int n = arr.length;

            if(n==0 || n==1) return -1;

            int largest = arr[0];
            int slargest = Integer.MIN_VALUE;

            for(int i = 1;i<n;i++){
                if(arr[i]>largest){
                    slargest = largest;
                    largest = arr[i];
                }else if(arr[i]<largest && arr[i]> slargest){
                    slargest = arr[i];
                }
            }
            return slargest;
        }

        public static int secondSmallestElement(int[] arr){

            int n = arr.length;

            if(n==0 || n==1) return -1;

            int smallest = arr[0];
            int ssmallest = Integer.MAX_VALUE;

            for(int i = 1;i<n;i++){
                if(arr[i]<smallest){
                    ssmallest = smallest;
                    smallest = arr[i];
                }else if(arr[i]!=smallest && arr[i]<ssmallest){
                    ssmallest = arr[i];
                }
            }
            return ssmallest;
        }
    
    
    public static void main(String[] args) {
        int [] arr = {2,5,1,32,10};

        int result = slargest(arr);
        int result1 = ssmallest(arr);
        int result2 = secondLargest(arr);
        int result3 = secondLargestElement(arr);
        int result4 = secondSmallestElement(arr);
        
        System.out.println("SLargest: "+result);
        System.out.println("SSmallest: "+result1);
        System.out.println("Second Largest: "+result2);
        System.out.println("Second Largest: "+result3);
        System.out.println("Second Smallest: "+result4);
    }
}