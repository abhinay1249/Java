// Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. 
// Find the number(between 1 to N), that is not present in the given array..


import java.util.*;

class Main {
    
    // ======================= Brute Force Approach  =======================================

    static int missingNumber(int[] arr){
        int length = arr.length;
        int missingNumber = -1;
        for(int i = 0 ; i <= length ; i++){
            int flag = 0;
            for(int j = 0; j < length ; j++){
                if(arr[j] == i){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                missingNumber = i;
            }
        }
        return missingNumber;
    }

    // ======================= Better Approach Using MAP =======================================

    static int missingNumber_1(int[] arr){
        
        int missing = -1;
        Map<Integer,Integer> freqCount = new HashMap<>();
        int length = arr.length;
        
        for(int i = 0; i <= length;i++){
            freqCount.put(i,freqCount.getOrDefault(i,0)+1);    
        }
        for(int i = 0; i < length;i++){
            freqCount.put(arr[i],freqCount.getOrDefault(arr[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer> value : freqCount.entrySet()){
            if(value.getValue()==1){
                missing = value.getKey();
                break;
            }
        }
        return missing;
    }

    // ======================= Optimal Approach Using MATH =======================================
    
    static int missingNumber_2(int[] arr){
        int length = arr.length;
        
        int sumOfNumbers = length*(length+1)/2;
        
        int arraySum = 0;
        
        for(int i = 0 ; i < length ; i++){
            arraySum+=arr[i];
        }
        
        int missingNumber = sumOfNumbers - arraySum;
        
        return missingNumber;
    }
    
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        int result = missingNumber(arr);
        int result_1 = missingNumber_1(arr);
        int result_2 = missingNumber_2(arr);
        System.out.println(result);
        System.out.println(result_1);
        System.out.println(result_2);
    }
}