//  Problem Statement: Given a sorted array of N integers, 
// Write a program to find the index of the first and last occurrence of the target key. If the target is not found then return [-1,-1].

class Main {

    // ======================= Brute Force Approach =======================================
    
        static int[] firstAnsLastOccurence(int[] nums, int target){

            int length = nums.length;
            int lastOccurence = -1;
            int firstOccurence = -1;

            for(int index = 0 ; index < length ; index++){                  // T.C = O(2N) S.C = O(1)
                if(nums[index] == target){
                    firstOccurence = index;
                    break;
                }
            }

            for(int index = length-1 ; index >= 0 ; index--){
                if(nums[index] == target){
                    lastOccurence = index;
                    break;
                }
            }
            return new int[]{firstOccurence,lastOccurence};
        }

    // ======================= Better Approach =======================================
    
        static int[] firstAnsLastOccurence(int[] nums, int target){

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

        static int lowerBound(int[] nums, int target){
                
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

        static int upperBound(int[] nums, int target){

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

        static int[] firstAnsLastOccurence_2(int[] nums, int target){

            int length = nums.length;
            int first = lowerBound(nums,target);
            if(first == length || nums[first]!=target){
                return new int[]{-1,-1};
            }
            return new int[]{first,upperBound(nums,target)-1};
        }

    // ======================= Optimal Approach using Binary Search =======================================

        static int firstOccurence(int[] nums, int target){
            
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

        static int lastOccurence(int[] nums, int target){

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

        static int[] firstAnsLastOccurence_3(int[] nums, int target){

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