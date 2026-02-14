//  Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.

class Main{

    static int binarySearch(int[] nums, int target) {
        int length = nums.length;

        int low = 0;
        int high = length - 1;
        
        while(low <= high){

            int mid = low + ((high-low)/2);

            if(nums[mid] == target) return mid;
            else if(nums[mid]>target){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        
        int[] nums = {3,4,6,7,9,12,16,17};
        int target = 12;
        int result = binarySearch(nums,target);
        System.out.println(result);

    }
}