// Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

import java.util.*;

class Main {
    
    // ======================= Brute Force Approach =======================================

    static int appearsOnce(int[] nums){

        int appearOnce = 0;
        for(int i = 0 ; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length ; j++){                          //T.C = O(N^2), S.C = O(1)
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count == 1){
                appearOnce = nums[i];
            }
        }
        return appearOnce;
    }

    // ======================= Brute Force Approach Using Array =======================================

    static int appearsOnce_1(int[] nums){
            
        int appearOnce = 0;
        int[] temp = new int[nums.length];
        
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[i] == nums[j]){
                    temp[i] = 1;                                                // T.C = O(N^2) + O(N) , S.C = O(N)
                    temp[j] = 1;
                    break;
                }
            }
        }
        
        for(int i=0;i<temp.length;i++){
            if(temp[i]==0){
                appearOnce = nums[i];
            } 
        }
        return appearOnce;
    }
    
    // ======================= Better Approach Using MAP =======================================

    static int appearsOnce_2(int[] nums){

        int arrayLength = nums.length;
        int appearOnce = 0;
        Map<Integer,Integer> freqCount = new HashMap<>();
    
        for(int i = 0; i < arrayLength ; i++){
            freqCount.put(nums[i],freqCount.getOrDefault(nums[i],0)+1);             // T.C = O(N log M)+O(N) , S.C = O(N)
        }
    
        for(Map.Entry<Integer,Integer> value : freqCount.entrySet()){
            if(value.getValue() == 1){
                 appearOnce = value.getKey();
            }
        }
        return appearOnce;
    }

    // ======================= Optimal Approach  =======================================
    
    static int appearsOnce_3(int[] nums){
        
        int appearOnce = 0;
        
        for(int i = 0; i < nums.length ; i++){
            appearOnce^=nums[i];
        }
        return appearOnce;
    }   
    
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        int result = appearsOnce(nums);
        int result_1 = appearsOnce_1(nums);
        int result_2 = appearsOnce_2(nums);
        int result_3 = appearsOnce_3(nums);
        System.out.println(result);
        System.out.println(result_1);
        System.out.println(result_2);
        System.out.println(result_3);
    }
}