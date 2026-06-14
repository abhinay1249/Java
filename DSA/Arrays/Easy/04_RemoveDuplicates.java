// Problem Statement: Given an integer array sorted in non-decreasing order, 
// remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.

// If there are k elements after removing the duplicates, 
// then the first k elements of the array should hold the final result. It does not matter what you leave beyond the first k elements.


// Example 1:

// Input: arr[]=[1,1,2,2,2,3,3]
// Output: [1,2,3,_,_,_,_]
// Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.

// Example 2:

// Input: arr[]=[1,1,1,2,2,3,3,3,3,4,4]
// Output: [1,2,3,4,_,_,_,_,_,_,_]
// Explanation: Total number of unique elements are 4, i.e[1,2,3,4] and Therefore return 4 after assigning [1,2,3,4] in the beginning of the array.


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
    
    
    // ======================= Brute Force Approach =======================================

        public static int removeDuplicates(int[]arr){

            List<Integer> al = new ArrayList<>();
            int n = arr.length;
            int index = 0;
            for(int i = 0 ; i < n ; i++){
                if(!(al.contains(arr[i]))){                             // T.C = O(N^2) , S.C = O(Unique Elements)
                    al.add(arr[i]);
                    arr[index]=arr[i];
                    index++;
                }
            }
            return index;
        }

    // ======================= Better Approach =======================================

        public static int[] removeDuplicates_1(int[] nums){
            int length = nums.length;

            if(length == 1 || length == 0){
                return nums;
            }

            Set<Integer> hs = new HashSet<>();
            int index = 0;                                            // T.C = O(N), S.C = O(Unique Elements)

            for(int i = 0 ; i < length ;i++){
                if(!hs.contains(nums[i])){
                    hs.add(nums[i]);
                    nums[index] = nums[i];
                    index++;
                }
            }

            return nums;
        }
    
    
    // ======================= Optimal Approach =======================================

        public static int removeDuplicates_2(int[]arr){

            int n = arr.length;
            int i = 0;

            for(int j = 1; j < n ; j++){

                if(arr[j]!=arr[i]){
                    arr[i+1]=arr[j];                                    // T.C = O(N) , S.C = O(1)
                    i++;
                }
            }
            return i+1;
        }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3,3,4};
        int[] nums={1,1,1,2,2,3,3,4};

        int result = removeDuplicates(arr);
        int[] result1 = removeDuplicates_1(arr);
        int result2 = removeDuplicates_2(nums);
        
        System.out.println("Unique: "+result);
        System.out.println("Unique: "+result2);
        
        for(int i = 0; i < result1.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}