import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================
    
        static List<List<Integer>> fourSum(int[] nums, int target){
            int n = nums.length;
            Set<List<Integer>> elementList = new HashSet<>();

            for(int i = 0 ; i < n-3 ; i++){
                for(int j = i+1 ; j < n-2 ; j++){
                    for(int k = j+1 ;  k < n -1 ; k++){
                        for(int l = k+1 ; l < n ; l++){
                            if(nums[i]+nums[j]+nums[k]+nums[l] == target){
                                List<Integer> elements = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                                Collections.sort(elements);
                                elementList.add(elements);
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(elementList);
        }

    public static void main(String[] args) {
        int[] nums = {4,3,3,4,4,2,1,2,1,1};
        int target = 9;
        List<List<Integer>> res = fourSum(nums,target);
        for(List<Integer> num: res){
            System.out.println(num);
        }
    }
}