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
    
    // ==================================== Better Approach ===========================================
    
        static List<List<Integer>> fourSum(int[] nums, int target){
	        int length = nums.length;
	        Set<List<Integer>> quadra = new HashSet<>();
	        Set<Long> elementCheck = new HashSet<>();
	    
	        for(int index_1 = 0 ; index_1 < length ; index_1++){
	    	    for(int index_2 = index_1+1 ; index_2 < length ; index_2++){
	    		    for(int index_3 = index_2+1 ; index_3 < length ; index_3++){
	    			    long sum = (long) nums[index_1]+nums[index_2]+nums[index_3];

                        long element = (long) target - sum;
	    			    if(elementCheck.contains(element)){
	    				    List<Integer> temp = Arrays.asList(nums[index_1],nums[index_2],nums[index_3],(int)element);
	    				    Collections.sort(temp);
	    				    quadra.add(temp);
                        }
                        elementCheck.add((long)nums[index_3]);
                    }
                    elementCheck.clear();
                }
            }
            return new ArrayList<>(quadra);
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