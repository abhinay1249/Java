// Problem Statement: Given an array of N integers. 
// Every number in the array except one appears twice. Find the single number in the array.

import java.util.*;

class Main {
    
    // ======================= Brute Force Approach ===========================

        public static int singleElement(int[] nums){
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

        public static int singleElement_1(int[] nums){
            int length = nums.length;
            int singleElement = 0;

           if(length == 1) return nums[0];

            for(int index = 0 ; index < length ; index++){                      // T.C = O(N), S.C = O(1)
                singleElement ^= nums[index];
            }
            return singleElement;
        }
    
    // ======================= Optimal Approach =================================

        public static int singleElement_2(int[] nums){
        
            int length = nums.length;

            if(length == 1) return nums[0];

            int low = 1, high = length - 2;

            if(nums[low] != nums[low-1]) return nums[low-1];                    // T.C = O(Log N), S.C = O(1)
            if(nums[high] != nums[high+1]) return nums[high+1];

            int singleElement = -1;

            while(low <= high){

                int mid = low + ((high-low)/2);

                if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                    singleElement = nums[mid];
                    break;
                }

                int prevIdx = mid - 1;
                int nextIdx = mid + 1;

                int prevElement = nums[mid -1], nextElement = nums[mid+1];

                if(((prevIdx%2==0) && nums[mid]==prevElement) || ((nextIdx%2==1) && nums[mid]==nextElement)){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return singleElement;
        }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5,5,6,6};
        int result = singleElement_2(nums);
        System.out.println(result);
    }
}