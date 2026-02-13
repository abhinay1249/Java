// Problem Statement: Given an array of N integers. 
// Every number in the array except one appears twice. Find the single number in the array.

import java.util.*;

class Main {
    
    // ======================= Brute Force Approach ===========================

    static int singleElement(int[] nums){
        int length = nums.length;
        
        if(length == 1) return nums[0];
        
        Map<Integer,Integer> freqCount = new HashMap<>();                     // T.C = O(N LOG M)+ O(N), S.C = O(N/2+1)        
        
        for(int index = 0 ; index < length ; index++){                                      
            freqCount.put(nums[index],freqCount.getOrDefault(nums[index],0)+1);
        }
        
        int singleElement = 0;
        
        for(Map.Entry<Integer,Integer> count : freqCount.entrySet()){
            if(count.getValue() == 1){
                singleElement = count.getKey();
                break;
            }
        }
        return singleElement;
    }
    
    // ======================= Better Approach =================================

    static int singleElement_1(int[] nums){
        int length = nums.length;
        int singleElement = 0;
       
       if(length == 1) return nums[0];
       
        for(int index = 0 ; index < length ; index++){                      // T.C = O(N), S.C = O(1)
            singleElement ^= nums[index];
        }
        return singleElement;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5,5,6,6};
        int result = singleElement_1(nums);
        System.out.println(result);
    }
}