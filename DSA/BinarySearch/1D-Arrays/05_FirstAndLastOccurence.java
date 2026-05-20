//  Problem Statement: Given a sorted array of N integers, 
// Write a program to find the index of the first and last occurrence of the target key. If the target is not found then return [-1,-1].

// Example 1:
// Input : N = 7, target = 13, array[] = {3, 4, 13, 13, 13, 20, 40}  
// Output : 4  
// Explanation: The target value 13 appears for the first time at index number 2 in the array.  

// Example 2:
// Input: N = 7, target = 60, array[] = {3, 4, 13, 13, 13, 20, 40}  
// Output: -1  
// Explanation: Target value 60 is not present in the array, so the output is -1.

class Main {

    // ======================= Brute Force Approach =======================================
    
        public static int[] firstAnsLastOccurence(int[] nums, int target){

            int length = nums.length;
            int lastOccurence = -1;
            int firstOccurence = -1;

            for(int index = 0 ; index < length ; index++){                  // T.C = O(N) S.C = O(1)
                if(nums[index] == target && firstOccurence == -1){
                    firstOccurence = index;
                }

                if(nums[length-index-1] == target && lastOccurence == -1){
                    lastOccurence = length - index - 1;
                }

                if(firstOccurence != -1 && lastOccurence != -1){
                    break;
                }
            }

            return new int[]{firstOccurence,lastOccurence};
        }

    // ======================= Better Approach =======================================
    
        public static int[] firstAnsLastOccurence_1(int[] nums, int target){

            int length = nums.length;
            int lastOccurence = -1;
            int firstOccurence = -1;

            for(int index = 0 ; index < length ; index++){                  // T.C = O(N) S.C = O(1)
                if(nums[index] == target){
                    if(firstOccurence == -1){
                        firstOccurence = index;
                    }
                    lastOccurence = index;
                }
            }
            return new int[]{firstOccurence,lastOccurence};
        }

    // ======================= Optimal Approach Using Lower and Upper Bounds =======================================

        public static int lowerBound(int[] nums, int target){
                
            int length = nums.length;
            int low = 0, high = length - 1;
            int firstOccurence = length;

            while(low <= high){
                int mid = low + ((high - low)/2);

                if(nums[mid]>=target){
                    firstOccurence = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            return firstOccurence;
        }

        public static int upperBound(int[] nums, int target){

            int length = nums.length;
            int low = 0, high = length - 1;
            int lastOccurence = length;

            while(low <= high){
                int mid = low + ((high - low)/2);                           // T.C = 2*O(log N) S.C = O(1)

                if(nums[mid]>target){
                    lastOccurence = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            return lastOccurence;
        }

        public static int[] firstAnsLastOccurence_2(int[] nums, int target){

            int length = nums.length;
            int first = lowerBound(nums,target);
            if(first == length || nums[first]!=target){
                return new int[]{-1,-1};
            }
            return new int[]{first,upperBound(nums,target)-1};
        }

    // ======================= Optimal Approach using Binary Search =======================================

        private static int firstOccurence(int[] nums, int target){
            
            int length = nums.length;
            int low = 0, high = length - 1;
            int first = -1;

            while(low <= high){

                int mid = low +((high - low)/2);

                if(nums[mid] == target){                                     // T.C = 2 * O(log N) S.C = O(1)
                    first = mid;
                    high = mid - 1;
                }else if(nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return first;
        }

        private static int lastOccurence(int[] nums, int target){

            int length = nums.length;
            int low = 0, high = length - 1;
            int last = -1;

            while(low <= high){

                int mid = low + ((high - low)/2);

                if(nums[mid] == target){
                    last = mid;
                    low = mid + 1;
                }else if(nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return last;
        }

        public static int[] firstAndLastOccurence_3(int[] nums, int target){

            int length = nums.length;
            int first = firstOccurence(nums,target);
            if(first == -1){
                return new int[]{-1,-1};
            }
            return new int[]{first,lastOccurence(nums,target)};
        }

    
    public static void main(String[] args) {
        int[] nums = {1,2,4,4,4,4,4,9,11};
        int target = 5;
        int[] result = firstAndLastOccurence_3(nums,target);

        for(int val : result){
            System.out.println(val);
        }
    }
}