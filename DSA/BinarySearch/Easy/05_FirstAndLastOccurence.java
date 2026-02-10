class Main {

    // ======================= Brute Force Approach =======================================
    
        static int lastOccurence(int[] nums, int target){

            int length = nums.length;
            int lastOccurence = -1;
            int firstOccurence = -1;

            for(int index = 0 ; index < length ; index++){                  // T.C = O(N) S.C = O(1)
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


    public static void main(String[] args) {
        int[] nums = {1,2,4,4,4,4,4,9,11};
        int target = 5;
        int result = lastOccurence(nums,target);
        System.out.println(result);
    }
}